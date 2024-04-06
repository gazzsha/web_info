package com.school.web_info.repository;

import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ResultTestRepository extends JpaRepository<ResultTest, Long> {
    Optional<ResultTest> findResultTestByUserAndTestId(User user, String testId);

    Optional<ResultTest> findResultTestByTestId(String testId);


    @Query("select distinct r.testId from ResultTest r")
    List<String> findDistinctTestId();
}
