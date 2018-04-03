package com.srug86.backendninja.service;

import com.srug86.backendninja.entity.Course;
import com.srug86.backendninja.model.CourseModel;

import java.util.List;

public interface ICourseService {

    public abstract List<CourseModel> listAllCourses();

    public abstract CourseModel addCourse(CourseModel courseModel);

    public abstract int removeCourse(int id);

    public abstract CourseModel updateCourse(CourseModel courseModel);
}
