package com.javangar.mentofitvx.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javangar.mentofitvx.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
