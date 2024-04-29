package com.school.web_info.utils;

import com.school.web_info.dto.FacultyDto;
import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.dto.TestDto;
import com.school.web_info.dto.TestShortInfoDto;
import com.school.web_info.dto.UserShortInfoDto;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.Test;
import com.school.web_info.entity.User;
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




