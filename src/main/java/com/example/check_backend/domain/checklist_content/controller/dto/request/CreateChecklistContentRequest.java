package com.example.check_backend.domain.checklist_content.controller.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@Getter
public class CreateChecklistContentRequest {
    private String title;
    private List<String> content;
}
