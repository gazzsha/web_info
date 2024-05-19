package com.school.web_info.repository;

import com.school.web_info.entity.resulttest.ResultTest;
import com.school.web_info.entity.user.User;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResultTestRepository extends JpaRepository<ResultTest, Long> {


    @Query("from ResultTest r join fetch r.user where r.testId = :testId and r.user = :user")
    ResultTest findResultTestByUserAndTestId(@Param(value = "user") User user, @Param("testId") String testId);


    Optional<ResultTest> findResultTestByTestId(String testId);


    @NotNull
    @Override
    @Query("from ResultTest r join fetch r.user")
    List<ResultTest> findAll();

    @Query("from ResultTest r join fetch r.user where r.user.id = :id")
    List<ResultTest> findAllByUserId(@Param(value = "id") Long id);
}
