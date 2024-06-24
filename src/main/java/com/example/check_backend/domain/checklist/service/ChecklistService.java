package com.example.check_backend.domain.checklist.service;

import com.example.check_backend.domain.checklist.controller.dto.request.CreateChecklistRequest;
import com.example.check_backend.domain.checklist.entity.CheckList;
import com.example.check_backend.domain.checklist.entity.repository.ChecklistRepository;
import com.example.check_backend.domain.subject.entity.Subject;
import com.example.check_backend.domain.subject.entity.repository.SubjectRepository;
import com.example.check_backend.domain.subject.exception.SubjectNotFoundException;
import com.example.check_backend.domain.user.entity.User;
import com.example.check_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class ChecklistService {
    private final ChecklistRepository checklistRepository;
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createChecklist(Long subjectId, CreateChecklistRequest request) {
        User user = userFacade.getCurrentUser();
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> SubjectNotFoundException.EXCEPTION);

        checklistRepository.save(
                CheckList.builder()
                        .subject(subject)
                        .user(user)
                        .title(request.getTitle())
                        .date(LocalDate.now())
                        .isSaved(false)
                        .build()
        );
    }
}
