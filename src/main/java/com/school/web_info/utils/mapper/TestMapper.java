package com.school.web_info.utils.mapper;

import com.school.web_info.dto.test.TestDto;
import com.school.web_info.entity.test.Test;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TestMapper extends Mappable<Test, TestDto> {
    @Override
    @Mapping(target = "_id", ignore = true)
    Test toEntity(TestDto dto);
}
