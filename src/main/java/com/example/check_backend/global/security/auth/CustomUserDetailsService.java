package com.example.check_backend.global.security.auth;

import com.example.check_backend.domain.user.entity.User;
import com.example.check_backend.domain.user.entity.repository.UserRepository;
import com.example.check_backend.domain.user.service.exception.user.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String accountId) throws UsernameNotFoundException {
        User user = userRepository.findByAccountId(accountId)
                .orElseThrow(UserNotFoundException::new);

        return new CustomUserDetails(user.getAccountId());
    }
}
