package com.school.web_info.repository;

import com.school.web_info.entity.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface TestRepository extends MongoRepository<Test, String> {
    Optional<Test> findBy_id(String id);

    List<String> findAll_id();
}
