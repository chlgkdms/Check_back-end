package com.example.check_backend.domain.checklist.controller.dto.response;

import com.example.check_backend.domain.subject.entity.Subject;
import com.example.check_backend.domain.user.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CheckListElement {
    private final Long id;
    private final String nickname;
    private final String title;
    private final LocalDate date;
    private final Boolean isSaved;

}
