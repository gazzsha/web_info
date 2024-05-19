package com.school.web_info.utils.mapper;

import com.school.web_info.dto.daculty.FacultyDto;
import com.school.web_info.entity.faculty.Faculty;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface FacultyMapper extends Mappable<Faculty, FacultyDto> {
}
