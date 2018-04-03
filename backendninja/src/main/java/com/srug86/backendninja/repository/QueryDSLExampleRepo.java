package com.srug86.backendninja.repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.srug86.backendninja.entity.Course;
import com.srug86.backendninja.entity.QCourse;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("queryDSLExampleRepo")
public class QueryDSLExampleRepo {

    private QCourse qCourse = QCourse.course;

    @PersistenceContext
    private EntityManager em;

    // Example of JPAQuery using a BooleanBuilder
    public Course find(boolean exists) {
        JPAQuery<Course> query = new JPAQuery<Course>(em);

        BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));

        if (exists) {
            Predicate predicate2 = qCourse.id.eq(23);
            predicateBuilder.and(predicate2);
        } else {
            Predicate predicate3 = qCourse.name.endsWith("OP");
            predicateBuilder.and(predicate3);
        }

        return query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
    }

    public Course findCourseById(int id) {
        JPAQuery<Course> query = new JPAQuery<Course>(em);
        return query.select(qCourse).from(qCourse).where(qCourse.id.eq(id)).fetchOne();
    }

    public List<Course> findCoursesByNumberOfHours(int fromHours, int toHours) {
        JPAQuery<Course> query = new JPAQuery<Course>(em);
        return query.select(qCourse).from(qCourse).where(qCourse.hours.between(fromHours, toHours)).fetch();
    }
}
