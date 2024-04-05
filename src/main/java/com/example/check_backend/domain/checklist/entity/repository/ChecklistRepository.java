package com.example.check_backend.domain.checklist.entity.repository;

import com.example.check_backend.domain.checklist.entity.Checklist;
import com.example.check_backend.domain.user.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChecklistRepository extends CrudRepository<Checklist, Long> {

}
