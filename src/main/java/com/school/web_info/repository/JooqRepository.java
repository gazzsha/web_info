package com.school.web_info.repository;

import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.Result;

public interface JooqRepository {
    Result<Record3<String, String, Double>> findRatingByFacultyAndTest();
}
