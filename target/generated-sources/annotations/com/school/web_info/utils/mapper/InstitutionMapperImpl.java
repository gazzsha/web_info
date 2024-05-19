package com.school.web_info.utils.mapper;

import com.school.web_info.dto.institution.InstitutionDto;
import com.school.web_info.entity.institution.EducationalInstitution;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-19T17:27:44+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class InstitutionMapperImpl implements InstitutionMapper {

    @Override
    public InstitutionDto toDto(EducationalInstitution entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String institution = null;

        id = entity.getId();
        institution = entity.getInstitution();

        InstitutionDto institutionDto = new InstitutionDto( id, institution );

        return institutionDto;
    }

    @Override
    public List<InstitutionDto> toDto(List<EducationalInstitution> entity) {
        if ( entity == null ) {
            return null;
        }

        List<InstitutionDto> list = new ArrayList<InstitutionDto>( entity.size() );
        for ( EducationalInstitution educationalInstitution : entity ) {
            list.add( toDto( educationalInstitution ) );
        }

        return list;
    }

    @Override
    public EducationalInstitution toEntity(InstitutionDto dto) {
        if ( dto == null ) {
            return null;
        }

        EducationalInstitution educationalInstitution = new EducationalInstitution();

        educationalInstitution.setId( dto.id() );
        educationalInstitution.setInstitution( dto.institution() );

        return educationalInstitution;
    }

    @Override
    public List<EducationalInstitution> toEntity(List<InstitutionDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<EducationalInstitution> list = new ArrayList<EducationalInstitution>( dtos.size() );
        for ( InstitutionDto institutionDto : dtos ) {
            list.add( toEntity( institutionDto ) );
        }

        return list;
    }
}
