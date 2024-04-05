package com.school.web_info.utils;

import com.school.web_info.dto.ResultTestDto;
import com.school.web_info.dto.TestDto;
import com.school.web_info.dto.UserShortInfoDto;
import com.school.web_info.entity.ResultTest;
import com.school.web_info.entity.Test;
import com.school.web_info.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;


@Mapper
public interface PojoMapper {
    PojoMapper INSTANCE = Mappers.getMapper(PojoMapper.class);

    TestDto testToTestDto(Test test);


    @Mappings({
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "lastName", target = "lastName"),
            @Mapping(source = "email", target = "email"),
            @Mapping(source = "birthday", target = "birthday", dateFormat = "dd.MM.yyyy"),
            @Mapping(source = "schoolName", target = "school"),
            @Mapping(source = "skills", target = "skills")
    })
    UserShortInfoDto userToUserShortInfoDto(User user);
    @Mappings({
            @Mapping(target = "countTrueAnswer", source = "countTrueAnswer"),
            @Mapping(target = "user",
                    expression = "java(PojoMapper.INSTANCE.userToUserShortInfoDto(resultTest.getUser()))")
    })
    ResultTestDto resultTestToResultTestDto(ResultTest resultTest);
}




