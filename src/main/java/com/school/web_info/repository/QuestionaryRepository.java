package com.school.web_info.repository;

import com.school.web_info.entity.questioner.Questioner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionaryRepository extends JpaRepository<Questioner, Long> {

}
