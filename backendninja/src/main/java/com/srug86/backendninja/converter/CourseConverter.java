package com.srug86.backendninja.converter;

import com.srug86.backendninja.entity.Course;
import com.srug86.backendninja.model.CourseModel;
import org.springframework.stereotype.Component;

@Component("courseConverter")
public class CourseConverter {

    // Entity to Model
    public CourseModel entity2Model(Course course) {
        CourseModel courseModel = new CourseModel();
        courseModel.setName(course.getName());
        courseModel.setDescription(course.getDescription());
        courseModel.setPrice(course.getPrice());
        courseModel.setHours(course.getHours());
        return courseModel;
    }

    // Model to Entity
    public Course model2Entity(CourseModel courseModel) {
        Course course = new Course();
        course.setName(courseModel.getName());
        course.setDescription(courseModel.getDescription());
        course.setPrice(courseModel.getPrice());
        course.setHours(courseModel.getHours());
        return course;
    }
}
