package com.example.check_backend.domain.checklist.service;

import com.example.check_backend.domain.checklist.entity.repository.ChecklistRepository;
import com.example.check_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ChecklistService {
    private final ChecklistRepository checklistRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createChecklist(){

    }
}
