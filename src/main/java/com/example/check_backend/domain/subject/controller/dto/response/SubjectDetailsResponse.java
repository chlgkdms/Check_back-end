package com.example.check_backend.domain.subject.controller.dto.response;

import com.example.check_backend.domain.checklist.entity.Checklist;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class SubjectDetailsResponse {
    private Long id;
    private String subjectName;
    private List<Checklist> checklist;
}