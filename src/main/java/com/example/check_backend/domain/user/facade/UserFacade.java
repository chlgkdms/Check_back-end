package com.example.check_backend.domain.user.facade;

import com.example.check_backend.domain.user.entity.User;
import com.example.check_backend.domain.user.entity.repository.UserRepository;
import com.example.check_backend.domain.user.service.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User getUserByAccountId(String accountId) {
        return userRepository.findByAccountId(accountId).orElseThrow(()-> UserNotFoundException.EXCEPTION);
    }

    public User getCurrentUser() {
        String accountId = SecurityContextHolder.getContext().getAuthentication().getName();
        return getUserByAccountId(accountId);
    }
}
