package com.charles.srpringdatajpatutorial.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.charles.srpringdatajpatutorial.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{
    
    Page<Course> findByTitleContaining(String title, Pageable pageable);
}
