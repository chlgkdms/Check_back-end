package com.example.check_backend.domain.user.controller.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProfileSavedCheckListResponse {
    private final String nickname;
    private final List<ProfileSavedCheckListElement> profileCheckList;
}
