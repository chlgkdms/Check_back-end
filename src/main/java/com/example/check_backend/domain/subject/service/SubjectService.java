package com.example.check_backend.domain.subject.service;

import com.example.check_backend.domain.subject.controller.dto.request.CreateSubjectRequest;
import com.example.check_backend.domain.subject.controller.dto.response.SubjectResponse;
import com.example.check_backend.domain.subject.entity.Subject;
import com.example.check_backend.domain.subject.entity.repository.SubjectRepository;
import com.example.check_backend.domain.subject.exception.SubjectNotFoundException;
import com.example.check_backend.domain.user.entity.User;
import com.example.check_backend.domain.user.facade.UserFacade;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;

    @Transactional
    public void createSubject(CreateSubjectRequest request) {
        User user  = userFacade.getCurrentUser();

        Subject subject = Subject.builder()
                .user(user)
                .name(request.getSubjectName())
                .build();

        subjectRepository.save(subject);
    }

    public SubjectResponse findOneSubject(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> SubjectNotFoundException.EXCEPTION
        );
        return new SubjectResponse(subject);
    }

//    @Transactional
//    public Long updateSubject(Long subjectId, CreateSubjectRequest subjectRequest) {
//        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
//                () -> SubjectNotFoundException.EXCEPTION
//        );
//        subject.update(subjectRequest);
//        return subject.getId();
//    }
}
