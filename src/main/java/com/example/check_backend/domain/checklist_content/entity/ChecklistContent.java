package com.example.check_backend.domain.checklist_content.entity;

import com.example.check_backend.domain.checklist.entity.CheckList;
import com.example.check_backend.domain.user.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "tbl_checklist_content")
@Entity
public class ChecklistContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "check_list_id")
    private CheckList checkList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String content;

    private Boolean isCleared;

    @Builder
    public ChecklistContent(Long id, CheckList checkList, User user, String content, Boolean isCleared) {
        this.id = id;
        this.checkList = checkList;
        this.user = user;
        this.content = content;
        this.isCleared = isCleared;
    }
}
