package com.school.web_info.utils.mapper;

import com.school.web_info.dto.daculty.FacultyDto;
import com.school.web_info.entity.faculty.Faculty;
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
public class FacultyMapperImpl implements FacultyMapper {

    @Override
    public FacultyDto toDto(Faculty entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String facultyName = null;

        id = entity.getId();
        facultyName = entity.getFacultyName();

        FacultyDto facultyDto = new FacultyDto( id, facultyName );

        return facultyDto;
    }

    @Override
    public List<FacultyDto> toDto(List<Faculty> entity) {
        if ( entity == null ) {
            return null;
        }

        List<FacultyDto> list = new ArrayList<FacultyDto>( entity.size() );
        for ( Faculty faculty : entity ) {
            list.add( toDto( faculty ) );
        }

        return list;
    }

    @Override
    public Faculty toEntity(FacultyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Faculty faculty = new Faculty();

        faculty.setId( dto.id() );
        faculty.setFacultyName( dto.facultyName() );

        return faculty;
    }

    @Override
    public List<Faculty> toEntity(List<FacultyDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Faculty> list = new ArrayList<Faculty>( dtos.size() );
        for ( FacultyDto facultyDto : dtos ) {
            list.add( toEntity( facultyDto ) );
        }

        return list;
    }
}
