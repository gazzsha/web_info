package com.school.web_info.utils;

import com.school.web_info.dto.daculty.FacultyDto;
import com.school.web_info.dto.test.ResultTestDto;
import com.school.web_info.dto.test.TestDto;
import com.school.web_info.dto.test.TestShortInfoDto;
import com.school.web_info.dto.user.UserShortInfoDto;
import com.school.web_info.entity.answer.Answer;
import com.school.web_info.entity.faculty.Faculty;
import com.school.web_info.entity.resulttest.ResultTest;
import com.school.web_info.entity.test.Test;
import com.school.web_info.entity.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-19T17:27:44+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class PojoMapperImpl implements PojoMapper {

    @Override
    public TestDto testToTestDto(Test test) {
        if ( test == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String title = null;
        String description = null;
        String imgUrl = null;
        List<Answer> answerList = null;

        id = test.get_id();
        name = test.getName();
        title = test.getTitle();
        description = test.getDescription();
        imgUrl = test.getImgUrl();
        List<Answer> list = test.getAnswerList();
        if ( list != null ) {
            answerList = new ArrayList<Answer>( list );
        }

        TestDto testDto = new TestDto( id, name, title, description, imgUrl, answerList );

        return testDto;
    }

    @Override
    public TestShortInfoDto testToTestShortDto(Test test) {
        if ( test == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String title = null;
        String description = null;

        id = test.get_id();
        name = test.getName();
        title = test.getTitle();
        description = test.getDescription();

        Integer countAnswer = test.getAnswerList().size();

        TestShortInfoDto testShortInfoDto = new TestShortInfoDto( id, name, title, description, countAnswer );

        return testShortInfoDto;
    }

    @Override
    public UserShortInfoDto userToUserShortInfoDto(User user) {
        if ( user == null ) {
            return null;
        }

        Long id = null;
        String name = null;
        String lastName = null;
        String email = null;

        id = user.getId();
        name = user.getName();
        lastName = user.getLastName();
        email = user.getEmail();

        UserShortInfoDto userShortInfoDto = new UserShortInfoDto( id, name, lastName, email );

        return userShortInfoDto;
    }

    @Override
    public ResultTestDto resultTestToResultTestDto(ResultTest resultTest) {
        if ( resultTest == null ) {
            return null;
        }

        Long countTrueAnswer = null;

        countTrueAnswer = resultTest.getCountTrueAnswer();

        UserShortInfoDto user = PojoMapper.INSTANCE.userToUserShortInfoDto(resultTest.getUser());

        ResultTestDto resultTestDto = new ResultTestDto( countTrueAnswer, user );

        return resultTestDto;
    }

    @Override
    public FacultyDto facultyToFacultyDto(Faculty faculty) {
        if ( faculty == null ) {
            return null;
        }

        Long id = null;
        String facultyName = null;

        id = faculty.getId();
        facultyName = faculty.getFacultyName();

        FacultyDto facultyDto = new FacultyDto( id, facultyName );

        return facultyDto;
    }
}
