package com.example.check_backend.domain.user.service;

import com.example.check_backend.domain.checklist.entity.repository.ChecklistRepository;
import com.example.check_backend.domain.checklist_content.entity.ChecklistContent;
import com.example.check_backend.domain.checklist_content.entity.repository.ChecklistContentRepository;
import com.example.check_backend.domain.user.controller.dto.reponse.ProfileSavedCheckListElement;
import com.example.check_backend.domain.user.controller.dto.reponse.ProfileSavedCheckListResponse;
import com.example.check_backend.domain.user.controller.dto.reponse.TokenResponse;
import com.example.check_backend.domain.user.controller.dto.request.UserLoginRequest;
import com.example.check_backend.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.check_backend.domain.user.entity.User;
import com.example.check_backend.domain.user.entity.repository.UserRepository;
import com.example.check_backend.domain.user.facade.UserFacade;
import com.example.check_backend.domain.user.service.exception.user.UserNotFoundException;
import com.example.check_backend.domain.user.service.exception.user.PasswordMismatchException;
import com.example.check_backend.global.security.jwt.JwtProperties;
import com.example.check_backend.global.security.jwt.JwtTokenProvider;
import jakarta.validation.constraints.AssertTrue;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;
    private final UserFacade userFacade;
    private final ChecklistRepository checklistRepository;
    private final ChecklistContentRepository checklistContentRepository;

    @Transactional
    public void userSignUp(UserSignUpRequest request) {
        userRepository.save(User.builder()
                        .accountId(request.getAccountId())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .nickname(request.getNickname())
                .build());
    }

    @Transactional
    public TokenResponse login(UserLoginRequest request) {
        User user = userRepository.findByAccountId(request.getAccountId())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return jwtTokenProvider.getToken(user.getAccountId());
    }

    @Transactional
    public ProfileSavedCheckListResponse getProfile() {
        User user = userFacade.getCurrentUser();

        List<ProfileSavedCheckListElement> profileList = checklistRepository.findAllByUserIdAndIsSaved(user.getId(), true).stream()
                .filter(checkList -> checkList.getIsSaved())
                .map(checkList -> {
                    List<String> checkListContentList = checklistContentRepository.findAllByCheckListId(checkList.getId()).stream()
                            .map(content -> {
                                return content.getContent();
                            }).collect(Collectors.toList());

                    return ProfileSavedCheckListElement.builder()
                            .id(checkList.getId())
                            .title(checkList.getTitle())
                            .isSaved(checkList.getIsSaved())
                            .checkListContentList(checkListContentList)
                            .date(checkList.getDate())
                            .writer(checkList.getUser().getNickname())
                            .build();
                })
                .collect(Collectors.toList());

        return new ProfileSavedCheckListResponse(
                user.getNickname(),
                profileList
        );

    }
}
