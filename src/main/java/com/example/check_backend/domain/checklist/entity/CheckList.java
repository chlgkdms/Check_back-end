package com.example.check_backend.domain.checklist.entity;

import com.example.check_backend.domain.subject.entity.Subject;
import com.example.check_backend.domain.user.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_check_list")
@Entity
public class CheckList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(columnDefinition = "VARCHAR(20)", nullable = false)
    private String title;

    @Column(columnDefinition = "DATE", nullable = false)
    private LocalDate date;

    @Column(columnDefinition = "TINYINT(1)", nullable = false)
    private Boolean isSaved;

    @Builder
    public CheckList(Subject subject, User user, String title, LocalDate date, Boolean isSaved) {
        this.subject = subject;
        this.user = user;
        this.title = title;
        this.date = date;
        this.isSaved = isSaved;
    }

    public void updateIsSaved(Boolean savedStatus) {
        this.isSaved = savedStatus;
    }

}
