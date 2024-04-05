package com.example.check_backend.domain.user.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;

@Getter
@Entity
@Table(name = "tbl_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            columnDefinition = "VARCHAR(12)",
            nullable = false,
            unique = true
    )
    private String accountId;

    @Column(
            columnDefinition = "CHAR(256)",
            nullable = false
    )
    private String password;

    @Column(
            columnDefinition = "VARCHAR(10)",
            nullable = false,
            unique = true
    )
    private String nickname;

}