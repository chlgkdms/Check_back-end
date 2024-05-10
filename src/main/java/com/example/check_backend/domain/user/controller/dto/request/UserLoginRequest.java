package com.example.check_backend.domain.user.controller.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserLoginRequest {
    @NotNull(message = "아이디를 입력하세요.")
    private String accountId;

    @NotNull(message = "비밀번호를 입력하세요.")
    @Column(length = 30)
    private String password;
}
