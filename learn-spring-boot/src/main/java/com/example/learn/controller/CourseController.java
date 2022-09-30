package com.example.learn.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.learn.bean.Course;

@RestController
public class CourseController {

	@GetMapping("/courses")
	public List<Course> getCourses(){
		return Arrays.asList(new Course(1, "Learn Springboot & Microservices", "Great Author"),
				new Course(2, "Learn Springboot", "Author"));
	}
	
	@GetMapping("/courses/1")
	public Course getCourse(){
		return new Course(1, "Learn Springboot & Microservices", "Great Author");
	}
}
