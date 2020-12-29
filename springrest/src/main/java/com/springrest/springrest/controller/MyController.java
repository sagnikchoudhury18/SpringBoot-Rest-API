package com.springrest.springrest.controller;

import java.util.*;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/home")
    public String home(){
        return "this is home page";
    }

    //get all the courses
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();
    }

    //get a particular course
    @GetMapping("/courses/{courseId}")
    public Course getCourse(@PathVariable String courseId){
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    //add a course
    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    //update a course
    @PutMapping("/course")
    public Course updateCourse(@RequestBody Course course)  {
        return this.courseService.updateCourse(course);
    }

    //delete a course
    @DeleteMapping("/courses/{courseId}")
    public Course deleteCourse(@PathVariable String courseId){
        return this.courseService.deleteCourse(Long.parseLong(courseId));
    }

}
