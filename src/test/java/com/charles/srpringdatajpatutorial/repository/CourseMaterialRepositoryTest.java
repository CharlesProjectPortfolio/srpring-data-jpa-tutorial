package com.charles.srpringdatajpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.charles.srpringdatajpatutorial.entity.Course;
import com.charles.srpringdatajpatutorial.entity.CourseMaterial;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    public void SaveCourseMaterial() {

        Course course = 
            Course.builder()
            .title(".net")
            .credit(6)
            .build();

        CourseMaterial courseMaterial = 
            CourseMaterial.builder()
            .url("www.dailycodebuffer.com")
            .course(course)
            .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCourseMaterials() {
        List<CourseMaterial> courseMaterials = 
            repository.findAll();

        System.out.println("courseMaterials = " + courseMaterials);
    }
}
