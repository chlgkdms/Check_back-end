package com.example.check_backend.domain.checklist_content.entity.repository;

import com.example.check_backend.domain.checklist_content.entity.ChecklistContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Repository
public interface ChecklistContentRepository extends JpaRepository<ChecklistContent, Long> {
    List<ChecklistContent> findAllByCheckListId(Long checkListId);
}
