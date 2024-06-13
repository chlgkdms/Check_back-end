package com.example.check_backend.domain.user.controller.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;
    private LocalDateTime expiredAt;
}
