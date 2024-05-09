package com.school.web_info.service;


import com.school.web_info.entity.Test;
import com.school.web_info.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TestService {

    Test getById(String id);

    void save(Test test);

    List<String> getAllTestsId();

}
