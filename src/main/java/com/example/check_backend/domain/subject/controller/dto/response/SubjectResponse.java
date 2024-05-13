package com.example.check_backend.domain.subject.controller.dto.response;

import com.example.check_backend.domain.subject.entity.Subject;
import com.example.check_backend.domain.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SubjectResponse {
    private Long id;
    private String subjectName;
    private User writer;

    public SubjectResponse(Subject subject) {
        this.id = subject.getId();
        this.subjectName = subject.getName();
        this.writer = subject.getUser();
    }
}
