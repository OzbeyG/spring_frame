package com.cydeo.service;

import com.cydeo.dto.CourseDTO;

import java.util.List;

public interface CourseService {

    CourseDTO createCourse(CourseDTO courseDTO);

    CourseDTO getCourseById(long id);

    List<CourseDTO> getCoursesByCategory(String category);

    List<CourseDTO> getCourses();

    void updateCourse(Long id, CourseDTO courseDTO);

    void deleteCourseById(long id);

    void deleteCourses();


}
