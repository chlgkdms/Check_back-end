package com.example.check_backend.domain.user.entity.repository;

import com.example.check_backend.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Boolean existsByAccountId(String accountId);
    Optional<User> findByAccountId(String accountId);
}
