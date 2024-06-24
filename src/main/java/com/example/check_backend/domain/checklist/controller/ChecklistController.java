package com.example.check_backend.domain.checklist.controller;

import com.example.check_backend.domain.checklist.controller.dto.request.CreateChecklistRequest;
import com.example.check_backend.domain.checklist.service.ChecklistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/checklists")
@RestController
public class ChecklistController {
    private final ChecklistService checklistService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{subject-id}")
    public void createChecklist(@RequestBody CreateChecklistRequest request, @PathVariable(name = "subject-id") Long subjectId) {
        checklistService.createChecklist(subjectId, request);
    }
}
