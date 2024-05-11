package com.school.web_info.repository.impl;

import com.school.web_info.repository.JooqRepository;
import com.school.web_info.service.TestService;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.jooq.Record3;
import org.jooq.Result;
import org.springframework.stereotype.Repository;

import static com.school.web.jooq.db.tables.Faculty.FACULTY;
import static com.school.web.jooq.db.tables.Questionnaire.QUESTIONNAIRE;
import static com.school.web.jooq.db.tables.ResultTest.RESULT_TEST;
import static com.school.web.jooq.db.tables.Users.USERS;
import static org.jooq.impl.DSL.avg;

@Repository
@RequiredArgsConstructor
public class DefaultJooqRepository implements JooqRepository {

    private final TestService testService;
    private final DSLContext dslContext;


    @Override
    public Result<Record3<String, String, Double>> findRatingByFacultyAndTest() {
        return dslContext.select(RESULT_TEST.TEST_ID,
                        FACULTY.FACULTY_NAME,
                        avg(RESULT_TEST.COUNT_TRUE_ANSWER).cast(Double.class))
                .from(RESULT_TEST)
                .join(USERS).on(USERS.ID.eq(RESULT_TEST.USER_ID))
                .join(QUESTIONNAIRE).on(USERS.ID.eq(QUESTIONNAIRE.USER_ID))
                .join(FACULTY).on(FACULTY.ID.eq(QUESTIONNAIRE.FACULTY_ID))
                .groupBy(RESULT_TEST.TEST_ID, FACULTY.FACULTY_NAME)
                .fetch();
    }
}
