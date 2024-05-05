package com.nexus.springboot.learnjpaandhibernate.course.jpa;

import com.nexus.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseJpaRepository {

    @PersistenceContext //More specific than Autowired
    private EntityManager entityManager;

    public void insert(Course course) {
        entityManager.merge(course); //Automatically maps the Course object with the query
    }

    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    public void deleteById(Long id) {
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
    }

}
