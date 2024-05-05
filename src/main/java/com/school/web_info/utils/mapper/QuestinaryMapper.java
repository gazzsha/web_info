package com.school.web_info.utils.mapper;

import com.school.web_info.dto.questioner.QuestionerDto;
import com.school.web_info.entity.questioner.Questioner;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface QuestinaryMapper extends Mappable<Questioner, QuestionerDto> {

    @Override
    default QuestionerDto toDto(Questioner entity) {
        return new QuestionerDto(
                entity.getUser().getName(),
                entity.getUser().getLastName(),
                entity.getSurname(),
                entity.getBirthday(),
                entity.getFaculty().getFacultyName(),
                entity.getCity(),
                entity.getEducationalInstitution().getInstitution(),
                entity.getAdmission().getAdmissionVariant(),
                entity.getLevelCpp(),
                entity.getLevelPython(),
                entity.getLevelJava(),
                entity.getLevelCSharp(),
                entity.getLevelSql()
        );
    }

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "faculty", ignore = true)
    @Mapping(target = "educationalInstitution", ignore = true)
    @Mapping(target = "admission", ignore = true)
    Questioner toEntity(QuestionerDto dto);
}
