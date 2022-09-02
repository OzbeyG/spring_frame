package com.cydeo.controller;

import com.cydeo.entity.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseControllerResponseWrapper {

    private final CourseService courseService;

    public CourseControllerResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }


      @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses(){//ResponseWrapper whatever want to show in Postman

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("version","v3")
                .body(new ResponseWrapper("successfully retrieved",courseService.getCourses()));
      }

      @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long id){
        return ResponseEntity.ok(new ResponseWrapper("course: " + id + " retrieved", courseService.getCourseById(id)));
      }
}
