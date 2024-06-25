package com.example.check_backend.domain.checklist_content.controller;

import com.example.check_backend.domain.checklist_content.controller.dto.request.CreateChecklistContentRequest;
import com.example.check_backend.domain.checklist_content.service.ChecklistContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/checklistcontents")
@RestController
public class ChecklistContentController {
    private final ChecklistContentService checklistContentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create/{subject-id}")
    public void createChecklistContent(@RequestBody CreateChecklistContentRequest request, @PathVariable(name = "subject-id") Long subjectId) {
        checklistContentService.createChecklistContent(subjectId, request);
    }

}
