package com.example.check_backend.domain.subject.controller.dto.response;

import com.example.check_backend.domain.checklist.controller.dto.response.CheckListElement;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class SubjectDetailsResponse {
//    private final Long id;
//    private final String subjectName;
    private List<CheckListElement> checklist;
}