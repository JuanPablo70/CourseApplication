package com.nexus.springboot.learnjpaandhibernate.course;

import com.nexus.springboot.learnjpaandhibernate.course.jdbc.CourseJdbcRepository;
import com.nexus.springboot.learnjpaandhibernate.course.jpa.CourseJpaRepository;
import com.nexus.springboot.learnjpaandhibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseSpringDataJpaRepository repository;

    @Override
    public void run(String... args) throws Exception {
        repository.save(new Course(1L, "Learn Angular", "Udemy"));
        repository.save(new Course(2L, "Learn Python", "Udemy"));
        repository.save(new Course(3L, "Learn MongoDB", "Udemy"));

        repository.deleteById(3L);

        System.out.println(repository.findById(1L));
        System.out.println(repository.findById(2L));
    }

}
