package com.example.check_backend.domain.checklist_content.service;

import com.example.check_backend.domain.checklist.entity.CheckList;
import com.example.check_backend.domain.checklist.entity.repository.ChecklistRepository;
import com.example.check_backend.domain.checklist.exception.ChecklistNotFoundException;
import com.example.check_backend.domain.checklist.service.ChecklistService;
import com.example.check_backend.domain.checklist_content.controller.dto.request.CreateChecklistContentRequest;
import com.example.check_backend.domain.checklist_content.entity.ChecklistContent;
import com.example.check_backend.domain.checklist_content.entity.repository.ChecklistContentRepository;
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
public class ChecklistContentService {
    private final ChecklistContentRepository checklistContentRepository;
    private final ChecklistRepository checklistRepository;
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createChecklistContent(Long subjectId, CreateChecklistContentRequest request) {
        User user = userFacade.getCurrentUser();

        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> SubjectNotFoundException.EXCEPTION);

        CheckList checkList = checklistRepository.save(
                CheckList.builder()
                        .user(user)
                        .title(request.getTitle())
                        .date(LocalDate.now())
                        .isSaved(false)
                        .subject(subject)
                        .build()
        );


        request.getContent().forEach(content -> {
            checklistContentRepository.save(
                    ChecklistContent.builder()
                            .checkList(checkList)
                            .content(content)
                            .isCleared(false)
                            .user(user)
                            .build());
        });
    }
}
