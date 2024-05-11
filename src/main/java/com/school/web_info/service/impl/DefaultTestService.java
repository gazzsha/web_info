package com.school.web_info.service.impl;

import com.school.web_info.entity.Test;
import com.school.web_info.exception.error.NotFoundException;
import com.school.web_info.repository.TestRepository;
import com.school.web_info.service.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultTestService implements TestService {

    private final TestRepository testRepository;

    @Override
    public Test getById(String id) {
        return testRepository.findBy_id(id).orElseThrow(() -> new NotFoundException(String.format("Test with id %s not found", id)));
    }

    @Override
    public void save(Test test) {
        testRepository.save(test);
    }

}
