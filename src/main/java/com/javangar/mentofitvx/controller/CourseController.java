package com.javangar.mentofitvx.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javangar.mentofitvx.model.Course;
import com.javangar.mentofitvx.repository.CourseRepository;

@CrossOrigin(origins = "*")
@RestController
@Service
@RequestMapping("/api")
public class CourseController {
	
	@Autowired
    private CourseRepository courseRepository;

	@PostMapping("/course")
	public void create(@RequestBody Course course) {
		courseRepository.save(course);
	}
    
    @GetMapping("/course")
    public ResponseEntity<List<Course>> findAll(){
    	List<Course> courses = courseRepository.findAll();
        if (courses == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(courses);
    }
    
	@GetMapping("/course/{id}")
    public ResponseEntity<Optional<Course>> findById(@PathVariable("id") int id){
    	if (courseRepository.findById((long) id) == null) {
        	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(courseRepository.findById((long) id));
    }
}