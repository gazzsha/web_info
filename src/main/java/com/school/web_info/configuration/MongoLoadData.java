package com.school.web_info.configuration;

import com.school.web_info.entity.Answer;
import com.school.web_info.entity.Test;
import com.school.web_info.repository.TestRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Configuration
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MongoLoadData {

    TestRepository testRepository;

    @Bean
    CommandLineRunner loadTestData() {
        return args -> {
            testRepository.deleteAll();
            Test test = Test.of(List.of(Answer.of("Вопрос1",List.of("Мы люди?","width и height для фиксации размеров кнопок по кеглю их шрифта. пониженный line-height (и небольшой padding-right у правой кнопки) для учета особенностей метрик символов < и >. исправлен border-radius."),"Мы животные?"),
                    Answer.of("Вопрос 2",List.of("Мы кто?","Мы люди"),"Мы кто?")));
            Test test1 = Test.of(List.of(Answer.of("ВОпрос 2(1)",List.of("Сколько нам лет?","Если к изображению применить свойство max-width: 100% оно останется в границах родительского элемента, даже при том, что его изначальный размер больше."),"Мы животные?")));
            testRepository.save(test);
            testRepository.save(test1);
        };
    }
}
