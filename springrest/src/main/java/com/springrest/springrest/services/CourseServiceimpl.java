package com.springrest.springrest.services;

import com.springrest.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseServiceimpl implements CourseService {

    List<Course> list;

    public CourseServiceimpl(){
        list = new ArrayList<>();
        list.add(new Course(145, "Java Core Course", "this contains the basics of java"));
        list.add(new Course(4343, "spring boot course", "creating rest api using spring boot"));
    }

    @Override
    public List<Course> getCourses() {
        return list;
    }

    @Override
    public Course getCourse(long courseId) {

        Course c = null;
        for(Course course:list){
            if(course.getId() == courseId){
                c=course;
                break;
            }
        }
        return c;
    }

    @Override
    public Course addCourse(Course course) {
        list.add(course);
        return course;
    }

    @Override
    public Course updateCourse(Course course) {
        for(Course c:list){
            if(c.getId() == course.getId()){
                c.setTitle(course.getTitle());
                c.setDescription(course.getDescription());
            }
        }
        return course;
    }

    @Override
    public Course deleteCourse(long courseId) {
        Course c = null;
        for (Course course: list){
            if(course.getId() == courseId){
                c = course;
                list.remove(course);
                break;
            }
        }
        return c;
    }


}
