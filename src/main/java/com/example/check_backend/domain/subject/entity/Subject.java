package com.example.check_backend.domain.subject.entity;

import com.example.check_backend.domain.subject.controller.dto.request.SubjectRequest;
import com.example.check_backend.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_subject")
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(
            columnDefinition = "VARCHAR(20)",
            nullable = false
    )
    private String name;

    public Subject(SubjectRequest request) {
        this.name = request.getSubjectName();
        this.user = request.getUsername();
    }

    public void update(SubjectRequest request) {
        this.id = request.getUsername().getId();
        this.name = request.getSubjectName();
        this.user = request.getUsername();
    }
}
