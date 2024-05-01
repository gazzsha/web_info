package com.school.web_info.service;

import com.school.web_info.entity.questioner.Questioner;

public interface QuestionaryService {

    Questioner createQuestioner(Object userObject, Questioner questioner, String faculty, String admission, String institution);

}
