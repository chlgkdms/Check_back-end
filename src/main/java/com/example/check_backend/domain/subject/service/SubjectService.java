package com.example.check_backend.domain.subject.service;

import com.example.check_backend.domain.checklist.controller.dto.response.CheckListElement;
import com.example.check_backend.domain.checklist.entity.repository.ChecklistRepository;
import com.example.check_backend.domain.subject.controller.dto.request.CreateSubjectRequest;
import com.example.check_backend.domain.subject.controller.dto.response.SubjectDetailsResponse;
import com.example.check_backend.domain.subject.controller.dto.response.SubjectListElement;
import com.example.check_backend.domain.subject.controller.dto.response.SubjectResponse;
import com.example.check_backend.domain.subject.entity.Subject;
import com.example.check_backend.domain.subject.entity.repository.SubjectRepository;
import com.example.check_backend.domain.subject.exception.SubjectNotFoundException;
import com.example.check_backend.domain.user.entity.User;
import com.example.check_backend.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final UserFacade userFacade;
    private final ChecklistRepository checklistRepository;

    @Transactional
    public void createSubject(CreateSubjectRequest request) {
        User user = userFacade.getCurrentUser();

        Subject subject = Subject.builder().user(user).name(request.getSubjectName()).build();

        subjectRepository.save(subject);
    }

    @Transactional(readOnly = true)
    public SubjectDetailsResponse findOneSubject(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> SubjectNotFoundException.EXCEPTION);

        List<CheckListElement> checkElementList = checklistRepository.findAllBySubjectId(subjectId).stream().map(checklist -> {
            return CheckListElement.builder().date(checklist.getDate()).title(checklist.getTitle()).subject(subject).isSaved(checklist.getIsSaved()).build();
        }).collect(Collectors.toList());

        return new SubjectDetailsResponse(checkElementList);
    }

    @Transactional(readOnly = true)
    public SubjectResponse findAllSubjects() {
        List<SubjectListElement> subjectListElementList = subjectRepository.findAll().stream().map(subject -> {
            User user = userFacade.getUserById(subject.getUser().getId());

            return SubjectListElement.builder().id(subject.getId()).subjectName(subject.getName()).writer(user.getNickname()).build();
        }).collect(Collectors.toList());

        return new SubjectResponse(subjectListElementList);
    }
}

