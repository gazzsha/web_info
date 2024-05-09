package com.school.web_info.repository;

import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResultTestRepository extends JpaRepository<ResultTest, Long> {


    @Query("from ResultTest r join fetch User u where r.testId = :testId ")
    Optional<ResultTest> findResultTestByUserAndTestId(@Param(value = "user") User user, @Param("testId") String testId);

    Optional<ResultTest> findResultTestByTestId(String testId);


    @Query("select distinct r.testId from ResultTest r")
    List<String> findDistinctTestId();
}
