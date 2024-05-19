//package com.school.web_info.configuration;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.school.web_info.service.TestService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//
//
//@Configuration
//@RequiredArgsConstructor
//public class MongoLoadData {
//
//    private final ObjectMapper mapper;
//
//    private final TestService testService;
//
//    @Bean
//    CommandLineRunner loadTestData() {
//        return args -> {
//            String filePath = "src/main/resources/test-data/sql-test.json";
//            Test test = mapper.readValue(new File(filePath), Test.class);
////                Test test = Test.of("Знания программирования",
////                        "Тест",
////                        "Предлагается пройти тестирование для оцения ваших навыков в плане информатики и программирования.",
////                        "informatics-test.png",
////                        List.of(Answer.of("Вопрос1", List.of("Мы люди?", "width и height для фиксации размеров кнопок по кеглю их шрифта. пониженный line-height (и небольшой padding-right у правой кнопки) для учета особенностей метрик символов < и >. исправлен border-radius."), "Мы животные?"),
////                                Answer.of("Вопрос 2", List.of("Мы кто?", "Мы люди"), "Мы кто?")));
////                Test test1 = Test.of("Знания программирования", "Тест",
////                        "Предлагается пройти тестирование для оцения ваших навыков в плане информатики и программирования.",
////                        "sql_test.jpg",
////                        List.of(Answer.of("ВОпрос 2(1)", List.of("Сколько нам лет?", "Если к изображению применить свойство max-width: 100% оно останется в границах родительского элемента, даже при том, что его изначальный размер больше."), "Мы животные?")));
////                testRepository.save(test);
////                testRepository.save(test1);
//            testService.save(test);
//        };
//    }
//}
