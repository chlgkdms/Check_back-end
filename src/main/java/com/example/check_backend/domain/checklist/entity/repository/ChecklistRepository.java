package com.example.check_backend.domain.checklist.entity.repository;

import com.example.check_backend.domain.checklist.entity.CheckList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklistRepository extends JpaRepository<CheckList, Long> {
    List<CheckList> findAllBySubjectId(Long subjectId);
}
