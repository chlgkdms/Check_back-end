package com.example.check_backend.domain.checklist_content.entity.repository;

import com.example.check_backend.domain.checklist_content.entity.ChecklistContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistContentRepository extends CrudRepository<ChecklistContent, Long> {
}
