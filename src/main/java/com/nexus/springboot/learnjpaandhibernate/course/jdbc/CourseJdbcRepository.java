package com.nexus.springboot.learnjpaandhibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_QUERY =
            """
                    INSERT INTO COURSE (id, name, author)
                    VALUES (1, 'Learn Angular', 'Udemy');
            """;

    public void insert() {
        springJdbcTemplate.update(INSERT_QUERY);
    }

}
