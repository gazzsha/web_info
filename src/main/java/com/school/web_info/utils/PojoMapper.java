package com.school.web_info.utils;

import com.school.web_info.dto.daculty.FacultyDto;
import com.school.web_info.dto.test.ResultTestDto;
import com.school.web_info.dto.test.TestDto;
import com.school.web_info.dto.test.TestShortInfoDto;
import com.school.web_info.dto.user.UserShortInfoDto;
import com.school.web_info.entity.resulttest.ResultTest;
import com.school.web_info.entity.test.Test;
import com.school.web_info.entity.user.User;
import com.school.web_info.entity.faculty.Faculty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PojoMapper {
    PojoMapper INSTANCE = Mappers.getMapper(PojoMapper.class);

    TestDto testToTestDto(Test test);


    @Mappings({
            @Mapping(target = "countAnswer", expression = "java(test.getAnswerList().size())")
    })
    TestShortInfoDto testToTestShortDto(Test test);


    UserShortInfoDto userToUserShortInfoDto(User user);

    @Mappings({
            @Mapping(target = "countTrueAnswer", source = "countTrueAnswer"),
            @Mapping(target = "user",
                    expression = "java(PojoMapper.INSTANCE.userToUserShortInfoDto(resultTest.getUser()))")
    })
    ResultTestDto resultTestToResultTestDto(ResultTest resultTest);

    FacultyDto facultyToFacultyDto(Faculty faculty);
}




