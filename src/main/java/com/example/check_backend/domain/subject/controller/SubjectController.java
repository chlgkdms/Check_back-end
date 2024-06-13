package com.example.check_backend.domain.subject.controller;

import com.example.check_backend.domain.subject.controller.dto.request.CreateSubjectRequest;
import com.example.check_backend.domain.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping ("/subjects")
@RestController
public class SubjectController {
    private final SubjectService subjectService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createSubject(@RequestBody CreateSubjectRequest request) {
        subjectService.createSubject(request);
    }
}
