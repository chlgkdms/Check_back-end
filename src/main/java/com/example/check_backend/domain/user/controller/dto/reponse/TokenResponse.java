package com.example.check_backend.domain.user.controller.dto.reponse;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class TokenResponse {
    private String accessToken;
    private LocalDateTime expiredAt;
}
