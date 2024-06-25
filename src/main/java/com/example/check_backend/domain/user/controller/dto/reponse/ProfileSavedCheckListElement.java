package com.example.check_backend.domain.user.controller.dto.reponse;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProfileSavedCheckListElement {
    private final String title;
    private final Long id;
    private final Boolean isSaved;
    private final List<String> content;
}
