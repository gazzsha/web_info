package com.school.web_info.utils.mapper;

import com.school.web_info.dto.test.TestDto;
import com.school.web_info.entity.answer.Answer;
import com.school.web_info.entity.test.Test;
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
public class TestMapperImpl implements TestMapper {

    @Override
    public TestDto toDto(Test entity) {
        if ( entity == null ) {
            return null;
        }

        String id = null;
        String name = null;
        String title = null;
        String description = null;
        String imgUrl = null;
        List<Answer> answerList = null;

        id = entity.get_id();
        name = entity.getName();
        title = entity.getTitle();
        description = entity.getDescription();
        imgUrl = entity.getImgUrl();
        List<Answer> list = entity.getAnswerList();
        if ( list != null ) {
            answerList = new ArrayList<Answer>( list );
        }

        TestDto testDto = new TestDto( id, name, title, description, imgUrl, answerList );

        return testDto;
    }

    @Override
    public List<TestDto> toDto(List<Test> entity) {
        if ( entity == null ) {
            return null;
        }

        List<TestDto> list = new ArrayList<TestDto>( entity.size() );
        for ( Test test : entity ) {
            list.add( toDto( test ) );
        }

        return list;
    }

    @Override
    public List<Test> toEntity(List<TestDto> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Test> list = new ArrayList<Test>( dtos.size() );
        for ( TestDto testDto : dtos ) {
            list.add( toEntity( testDto ) );
        }

        return list;
    }

    @Override
    public Test toEntity(TestDto dto) {
        if ( dto == null ) {
            return null;
        }

        Test test = new Test();

        test.setName( dto.name() );
        test.setTitle( dto.title() );
        test.setDescription( dto.description() );
        test.setImgUrl( dto.imgUrl() );
        List<Answer> list = dto.answerList();
        if ( list != null ) {
            test.setAnswerList( new ArrayList<Answer>( list ) );
        }

        return test;
    }
}
