package com.school.web_info.service;


import com.school.web_info.entity.test.Test;

public interface TestService {

    Test getById(String id);

    void save(Test test);

}
