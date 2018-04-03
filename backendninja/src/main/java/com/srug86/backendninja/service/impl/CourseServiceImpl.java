package com.srug86.backendninja.service.impl;

import com.srug86.backendninja.converter.CourseConverter;
import com.srug86.backendninja.entity.Course;
import com.srug86.backendninja.model.CourseModel;
import com.srug86.backendninja.repository.ICourseJpaRepository;
import com.srug86.backendninja.service.ICourseService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("courseServiceImpl")
public class CourseServiceImpl implements ICourseService {

    private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);

    @Autowired
    @Qualifier("courseJpaRepository")
    private ICourseJpaRepository courseJpaRepository;

    @Autowired
    @Qualifier("courseConverter")
    private CourseConverter courseConverter;

    @Override
    public List<CourseModel> listAllCourses() {
        LOG.info("Call: " + "listAllCourses()");
        List<CourseModel> models = new ArrayList<>();
        for (Course course : courseJpaRepository.findAll()) {
            models.add(courseConverter.entity2Model(course));
        }
        return models;
    }

    @Override
    public CourseModel addCourse(CourseModel courseModel) {
        LOG.info("Call: " + "addCourse()" + " -- Param: " + courseModel.toString());
        courseJpaRepository.save(courseConverter.model2Entity(courseModel));
        return courseModel;
    }

    @Override
    public int removeCourse(int id) {
        LOG.info("Call: " + "removeCourse()" + " -- Param: " + id);
        courseJpaRepository.delete(id);
        return 0;
    }

    @Override
    public CourseModel updateCourse(CourseModel courseModel) {
        LOG.info("Call: " + "updateCourse()" + " -- Param: " + courseModel.toString());
        courseJpaRepository.save(courseConverter.model2Entity(courseModel));
        return courseModel;
    }
}
