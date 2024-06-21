package com.example.check_backend.domain.subject.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubjectListElement {
    private final Long id;
    private final String subjectName;
    private final String writer;
}
