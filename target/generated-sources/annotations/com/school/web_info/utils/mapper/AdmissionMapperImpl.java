package com.school.web_info.utils.mapper;

import com.school.web_info.dto.admission.AdmissionDto;
import com.school.web_info.entity.admission.Admission;
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
public class AdmissionMapperImpl implements AdmissionMapper {

    @Override
    public AdmissionDto toDto(Admission entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String admissionVariant = null;

        id = entity.getId();
        admissionVariant = entity.getAdmissionVariant();

        AdmissionDto admissionDto = new AdmissionDto( id, admissionVariant );

        return admissionDto;
    }

    @Override
    public List<AdmissionDto> toDto(List<Admission> entity) {
        if ( entity == null ) {
            return null;
        }

        List<AdmissionDto> list = new ArrayList<AdmissionDto>( entity.size() );
        for ( Admission admission : entity ) {
            list.add( toDto( admission ) );
        }

        return list;
    }

    @Override
    public Admission toEntity(AdmissionDto dto) {
        if ( dto == null ) {
            return null;
        }

        Admission admission = new Admission();

        admission.setId( dto.id() );
        admission.setAdmissionVariant( dto.admissionVariant() );

        return admission;
    }

    @Override
    public List<Admission> toEntity(List<AdmissionDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Admission> list = new ArrayList<Admission>( dtos.size() );
        for ( AdmissionDto admissionDto : dtos ) {
            list.add( toEntity( admissionDto ) );
        }

        return list;
    }
}
