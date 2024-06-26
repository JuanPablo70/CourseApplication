package com.nexus.springboot.learnjpaandhibernate.course.jdbc;

import com.nexus.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static final String INSERT_QUERY =
            """
                    INSERT INTO COURSE (id, name, author)
                    VALUES (?, ?, ?);
            """;

    private static final String DELETE_QUERY =
            """
                    DELETE FROM COURSE WHERE id = ?;
            """;

    private static final String SELECT_QUERY =
            """
                    SELECT * FROM COURSE WHERE id = ?;
            """;

    public void insert(Course course) {
        springJdbcTemplate.update(INSERT_QUERY, course.getId(), course.getName(), course.getAuthor());
    }

    public void deleteById(Long id) {
        springJdbcTemplate.update(DELETE_QUERY, id);
    }

    public Course findById(Long id) {
        //BeanPropertyRowMapper<>(Course.class) maps the result of the query into a Course object
        return springJdbcTemplate.queryForObject(SELECT_QUERY, new BeanPropertyRowMapper<>(Course.class),id);
    }

}
