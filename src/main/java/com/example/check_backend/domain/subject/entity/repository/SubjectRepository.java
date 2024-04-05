package com.example.check_backend.domain.subject.entity.repository;

import com.example.check_backend.domain.subject.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {
}
