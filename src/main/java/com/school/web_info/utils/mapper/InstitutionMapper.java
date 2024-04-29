package com.school.web_info.utils.mapper;

import com.school.web_info.dto.institution.InstitutionDto;
import com.school.web_info.entity.institution.EducationalInstitution;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InstitutionMapper extends Mappable<EducationalInstitution, InstitutionDto> {
}
