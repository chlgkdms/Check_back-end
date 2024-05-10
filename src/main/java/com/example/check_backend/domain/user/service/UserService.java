package com.example.check_backend.domain.user.service;

import com.example.check_backend.domain.user.controller.dto.reponse.TokenResponse;
import com.example.check_backend.domain.user.controller.dto.request.UserLoginRequest;
import com.example.check_backend.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.check_backend.domain.user.entity.User;
import com.example.check_backend.domain.user.entity.repository.UserRepository;
import com.example.check_backend.domain.user.service.exception.user.AccountIdNotFoundException;
import com.example.check_backend.domain.user.service.exception.user.PasswordMismatchException;
import com.example.check_backend.global.security.jwt.JwtProperties;
import com.example.check_backend.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtProperties jwtProperties;

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
                .orElseThrow(() -> AccountIdNotFoundException.EXCEPTION);

        if (!request.getPassword().equals(user.getPassword())) {
            throw PasswordMismatchException.EXCEPTION;
        }

        return TokenResponse
                .builder()
                .accessToken(jwtTokenProvider.createAccessToken(user.getAccountId()))
                .expiredAt(java.time.LocalDateTime.now()
                        .plusSeconds(jwtProperties.getAccessExpiration()))
                .build();
    }
}
