package com.example.check_backend.domain.subject.service;

import com.example.check_backend.domain.subject.controller.dto.request.SubjectRequest;
import com.example.check_backend.domain.subject.controller.dto.response.SubjectResponse;
import com.example.check_backend.domain.subject.entity.Subject;
import com.example.check_backend.domain.subject.entity.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectResponse createSubject(SubjectRequest subjectRequest) {
        Subject subject = new Subject(subjectRequest);
        subjectRepository.save(subject);
        return new SubjectResponse(subject);
    }

    public SubjectResponse findOneSubject(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new IllegalArgumentException("Subject not found")
        );
        return new SubjectResponse(subject);
    }

    @Transactional
    public Long updateSubject(Long subjectId, SubjectRequest subjectRequest) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new IllegalArgumentException("SubjectId not found")
        );
        subject.update(subjectRequest);
        return subject.getId();
    }
}
