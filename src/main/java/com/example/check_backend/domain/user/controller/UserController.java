package com.example.check_backend.domain.user.controller;

import com.example.check_backend.domain.user.controller.dto.reponse.ProfileSavedCheckListResponse;
import com.example.check_backend.domain.user.controller.dto.reponse.TokenResponse;
import com.example.check_backend.domain.user.controller.dto.request.UserLoginRequest;
import com.example.check_backend.domain.user.controller.dto.request.UserSignUpRequest;
import com.example.check_backend.domain.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signUp(@RequestBody UserSignUpRequest request) {
        System.out.println(request.getAccountId());
        userService.userSignUp(request);
    }

    @PostMapping("/login")
    public TokenResponse login(@Valid @RequestBody UserLoginRequest request) {
        return userService.login(request);
    }

    @GetMapping("/profile")
    public ProfileSavedCheckListResponse profile() {
        return userService.getProfile();
    }
}
