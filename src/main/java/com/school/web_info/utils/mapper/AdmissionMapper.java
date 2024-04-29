package com.school.web_info.utils.mapper;

import com.school.web_info.dto.admission.AdmissionDto;
import com.school.web_info.entity.admission.Admission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdmissionMapper extends Mappable<Admission, AdmissionDto> {
}
