package com.school.web_info.utils.mapper;

import com.school.web_info.dto.questioner.QuestionerDto;
import com.school.web_info.entity.questioner.Questioner;
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
public class QuestinaryMapperImpl implements QuestinaryMapper {

    @Override
    public List<QuestionerDto> toDto(List<Questioner> entity) {
        if ( entity == null ) {
            return null;
        }

        List<QuestionerDto> list = new ArrayList<QuestionerDto>( entity.size() );
        for ( Questioner questioner : entity ) {
            list.add( toDto( questioner ) );
        }

        return list;
    }

    @Override
    public List<Questioner> toEntity(List<QuestionerDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Questioner> list = new ArrayList<Questioner>( dtos.size() );
        for ( QuestionerDto questionerDto : dtos ) {
            list.add( toEntity( questionerDto ) );
        }

        return list;
    }

    @Override
    public Questioner toEntity(QuestionerDto dto) {
        if ( dto == null ) {
            return null;
        }

        Questioner questioner = new Questioner();

        questioner.setSurname( dto.surname() );
        questioner.setBirthday( dto.birthday() );
        questioner.setCity( dto.city() );
        questioner.setLevelCpp( dto.levelCpp() );
        questioner.setLevelPython( dto.levelPython() );
        questioner.setLevelJava( dto.levelJava() );
        questioner.setLevelCSharp( dto.levelCSharp() );
        questioner.setLevelSql( dto.levelSql() );

        return questioner;
    }
}
