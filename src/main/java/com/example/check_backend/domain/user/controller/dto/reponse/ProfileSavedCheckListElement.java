package com.example.check_backend.domain.user.controller.dto.reponse;

import com.example.check_backend.domain.checklist_content.controller.dto.response.CheckListContentListElement;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Builder
public class ProfileSavedCheckListElement {
    private final String title;
    private final Long id;
    private final Boolean isSaved;
    private final List<String> checkListContentList;
    private final LocalDate date;
    private final String writer;
}
