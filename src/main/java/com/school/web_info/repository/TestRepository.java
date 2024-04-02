package com.school.web_info.repository;

import com.school.web_info.entity.Test;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TestRepository extends MongoRepository<Test,String> {
    Test findBy_id(String id);
}
