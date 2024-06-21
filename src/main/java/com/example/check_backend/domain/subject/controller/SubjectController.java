package com.example.check_backend.domain.subject.controller;

import com.example.check_backend.domain.subject.controller.dto.request.CreateSubjectRequest;
import com.example.check_backend.domain.subject.controller.dto.response.SubjectDetailsResponse;
import com.example.check_backend.domain.subject.controller.dto.response.SubjectResponse;
import com.example.check_backend.domain.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/subjects")
@RestController
public class SubjectController {
    private final SubjectService subjectService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/create")
    public void createSubject(@RequestBody CreateSubjectRequest request) {
        subjectService.createSubject(request);
    }

    @GetMapping("/all")
    public SubjectResponse getAllSubjects() {
        return subjectService.findAllSubjects();
    }

    @GetMapping("/{subject-id}")
    public SubjectDetailsResponse subjectDetails(@PathVariable(name = "subject-id") Long subjectId) {
        return subjectService.findOneSubject(subjectId);
    }
}