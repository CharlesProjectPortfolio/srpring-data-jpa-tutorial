package com.charles.srpringdatajpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.charles.srpringdatajpatutorial.entity.Course;
import com.charles.srpringdatajpatutorial.entity.Student;
import com.charles.srpringdatajpatutorial.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {

        List<Course> courses = 
            courseRepository.findAll();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {

        Teacher teacher = Teacher.builder()
                .firstName("Priyanka")
                .lastName("Singh")
                .build();
        Course course = 
                Course.builder()
                        .title("Python")
                        .credit(6)
                        .teacher(teacher)
                        .build();

        courseRepository.save(course);

    }

    @Test
    public void findAllPagination() {
        org.springframework.data.domain.Pageable firstPageWiththreeRecords = 
                PageRequest.of(0, 3);

        org.springframework.data.domain.Pageable secondPageWithTwoRecords =
                PageRequest.of(1,2);

        List<Course> courses = 
        courseRepository.findAll(firstPageWiththreeRecords).getContent();

        Long totalElements = 
        courseRepository.findAll(firstPageWiththreeRecords).getTotalElements();

        int totalPages = 
            courseRepository.findAll(firstPageWiththreeRecords).getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting() {

        org.springframework.data.domain.Pageable sortByTitle = 
                PageRequest.of(0, 2, Sort.by("title"));

        org.springframework.data.domain.Pageable sortByCreditDesc = 
                PageRequest.of(0, 2, Sort.by("credit").descending());

        org.springframework.data.domain.Pageable sortByTitleAndCreditDesc = 
                PageRequest.of(0, 
                                2, 
                                Sort.by("title")
                                .descending()
                                .and(Sort.by("credit")));

        List<Course> courses =
                courseRepository.findAll(sortByTitle).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void printfindByTitleContaining() {

        org.springframework.data.domain.Pageable firstPageTenRecords = 
                PageRequest.of(0, 10);

        List<Course> courses = 
                courseRepository.findByTitleContaining("D", firstPageTenRecords).getContent();

        System.out.println("courses = " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {

        Teacher teacher = Teacher.builder()
                                    .firstName("Lizze")
                                    .lastName("Morgan")
                                    .build();

        Student student = Student.builder()
                                    .firstName("Abhishek")
                                    .lastName("Singh")
                                    .emailId("abhishek@gmail.com")
                                    .build();
        Course course = Course.builder()
                                .title("AI")
                                .credit(12)
                                .teacher(teacher)
                                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}
