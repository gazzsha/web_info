package com.school.web_info.repository;

import com.school.web_info.entity.User;
import com.school.web_info.entity.questioner.Questioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionaryRepository extends JpaRepository<Questioner, Long> {

    @Query("SELECT q FROM Questioner q " +
            "JOIN FETCH q.user u " +
            "JOIN FETCH q.faculty " +
            "JOIN FETCH q.admission " +
            "JOIN FETCH q.educationalInstitution " +
            "WHERE u = :user")
    Optional<Questioner> findByUser(@Param("user") User user);


    @Query("FROM Questioner q " +
            "JOIN FETCH q.user u " +
            "JOIN FETCH q.faculty " +
            "JOIN FETCH q.admission " +
            "JOIN FETCH q.educationalInstitution")
    List<Questioner> findAll();


//    @Query("SELECT q FROM Questioner q " +
//            "JOIN FETCH q.user u " +
//            "JOIN FETCH q.faculty " +
//            "JOIN FETCH q.admission " +
//            "JOIN FETCH q.educationalInstitution " +
//            "WHERE (:user is null or q.user = :user) " +
//            "AND (:facultyName is null or q.faculty.facultyName = :facultyName) " +
//            "AND (:education is null or q.educationalInstitution.institution = :education) " +
//            "AND (:admission is null or q.admission.admissionVariant = :admission) ")
//    List<Questioner> findAllByFilter(@Param("user") User user, @Param("faculty") String facultyName,
//                                     @Param("educationInstitution") String education,@Param("admission") String admission);
}
