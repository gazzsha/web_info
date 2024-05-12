package com.school.web_info.service.impl;

import com.school.web_info.entity.User;
import com.school.web_info.entity.admission.Admission;
import com.school.web_info.entity.faculty.Faculty;
import com.school.web_info.entity.institution.EducationalInstitution;
import com.school.web_info.entity.questioner.Questioner;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.repository.QuestionaryRepository;
import com.school.web_info.service.AdmissionService;
import com.school.web_info.service.EducationInstitutionService;
import com.school.web_info.service.FacultyService;
import com.school.web_info.service.QuestionaryService;
import com.school.web_info.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.StringTokenizer;


@Service
@RequiredArgsConstructor
public class DefaultQuestionaryService implements QuestionaryService {

    private final AdmissionService admissionService;
    private final EducationInstitutionService institutionService;
    private final FacultyService facultyService;
    private final QuestionaryRepository questionaryRepository;
    private final UserService userService;

    @Override
    public List<Questioner> getAll() {
        return questionaryRepository.findAll();
    }

    @Override
    @Transactional(isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRES_NEW)
    public Questioner createQuestioner(Object userObject, Questioner questioner, String faculty, String admission, String institution) {
        UserDetails userDetails = (UserDetails) userObject;
        StringTokenizer stringTokenizer = new StringTokenizer(userDetails.getUsername());
        Admission admissionObject = admissionService.getAdmissionByAdmissionVariant(admission);
        EducationalInstitution educationalInstitution = institutionService.getEducationInstitution(institution);
        Faculty facultyObject = facultyService.getByFacultyName(faculty);
        String name = stringTokenizer.nextToken();
        String lastName = stringTokenizer.nextToken();
        User user = userService.getUserByNameAndLastName(name, lastName)
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь с именем %s и фамилией %s не найден", name, lastName)));
        Questioner existing = questionaryRepository.findByUser(user).orElse(null);
        questioner.setId(existing != null ? existing.getId() : null);
        questioner.setUser(user);
        questioner.setAdmission(admissionObject);
        questioner.setFaculty(facultyObject);
        questioner.setEducationalInstitution(educationalInstitution);
        return questionaryRepository.save(questioner);
    }

    @Override
    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Questioner getUserProfile(Object userObject) {
        UserDetails userDetails = (UserDetails) userObject;
        StringTokenizer stringTokenizer = new StringTokenizer(userDetails.getUsername());
        String name = stringTokenizer.nextToken();
        String lastName = stringTokenizer.nextToken();
        User user = userService.getUserByNameAndLastName(name, lastName)
                .orElseThrow(() -> new NotFoundException(String.format("Пользователь с именем %s и фамилией %s не найден", name, lastName)));
        return questionaryRepository.findByUser(user).orElseThrow(()
                -> new NotFoundException(String.format("Пользователь с именем %s и фамилией %s не прошел анкетирование", name, lastName)));
    }

    @Override
    public Questioner getUserProfileById(Long id) {
        return questionaryRepository.findByUserId(id).orElseThrow(()
                -> new NotFoundException(String.format("Пользователь с id %s не существует", id)));
    }
}