package com.example.check_backend.domain.subject.controller.dto.request;

import com.example.check_backend.domain.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SubjectRequest {
    private String subjectName;
    private User username;
}
