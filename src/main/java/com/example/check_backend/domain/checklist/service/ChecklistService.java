package com.example.check_backend.domain.checklist.service;

import com.example.check_backend.domain.checklist.controller.dto.request.CreateChecklistRequest;
import com.example.check_backend.domain.checklist.entity.CheckList;
import com.example.check_backend.domain.checklist.entity.repository.ChecklistRepository;
import com.example.check_backend.domain.checklist.exception.ChecklistNotFoundException;
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

    @Transactional
    public void updateSave(Long checklistId) {
        CheckList checkList = checklistRepository.findById(checklistId)
                .orElseThrow(() -> ChecklistNotFoundException.EXCEPTION);

        Boolean savedStatus = checkList.getIsSaved().equals(true) ? false : true;

        checkList.updateIsSaved(savedStatus);
    }
}
