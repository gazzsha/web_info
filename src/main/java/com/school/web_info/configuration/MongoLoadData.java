package com.school.web_info.configuration;

import com.school.web_info.repository.TestRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.context.annotation.Configuration;


@Configuration
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@AllArgsConstructor
public class MongoLoadData {

    TestRepository testRepository;

//   @Bean
//    CommandLineRunner loadTestData() {
//        return args -> {
//            testRepository.deleteAll();
//            Test test = Test.of("Знания программирования",
//                    "Тест",
//                    "Предлагается пройти тестирование для оцения ваших навыков в плане информатики и программирования.",
//                    "informatics-test.png",
//                    List.of(Answer.of("Вопрос1",List.of("Мы люди?","width и height для фиксации размеров кнопок по кеглю их шрифта. пониженный line-height (и небольшой padding-right у правой кнопки) для учета особенностей метрик символов < и >. исправлен border-radius."),"Мы животные?"),
//                    Answer.of("Вопрос 2",List.of("Мы кто?","Мы люди"),"Мы кто?")));
//            Test test1 = Test.of("Знания программирования","Тест",
//                    "Предлагается пройти тестирование для оцения ваших навыков в плане информатики и программирования.",
//                    "sql_test.jpg",
//                  List.of(Answer.of("ВОпрос 2(1)",List.of("Сколько нам лет?","Если к изображению применить свойство max-width: 100% оно останется в границах родительского элемента, даже при том, что его изначальный размер больше."),"Мы животные?")));
//          testRepository.save(test);
//            testRepository.save(test1);
//        };
//    }
}
