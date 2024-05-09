package com.school.web_info.service;

import com.school.web_info.entity.questioner.Questioner;

import java.util.List;

public interface QuestionaryService {


    List<Questioner> getAll();

    Questioner createQuestioner(Object userObject, Questioner questioner, String faculty, String admission, String institution);


    Questioner getUserProfile(Object userObject);
}
