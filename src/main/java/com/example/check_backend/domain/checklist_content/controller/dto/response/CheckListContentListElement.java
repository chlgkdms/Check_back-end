package com.example.check_backend.domain.checklist_content.controller.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CheckListContentListElement {
    private final Long id;
    private final String content;
    private final Boolean isCleared;
}
