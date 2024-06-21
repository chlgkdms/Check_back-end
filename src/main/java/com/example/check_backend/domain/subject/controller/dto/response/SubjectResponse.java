package com.example.check_backend.domain.subject.controller.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@Getter
public class SubjectResponse {
    private final List<SubjectListElement> subjectList;
}
