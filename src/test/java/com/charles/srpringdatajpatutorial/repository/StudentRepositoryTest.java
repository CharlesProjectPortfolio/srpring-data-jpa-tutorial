package com.charles.srpringdatajpatutorial.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.charles.srpringdatajpatutorial.entity.Guardian;
import com.charles.srpringdatajpatutorial.entity.Student;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {

        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
                //.guardianName("Nikhil")
                //.guardianEmail("nikhil@gmail.com")
                //.guardianMobile("99999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
            .email("nikhil@gmail.com")
            .name("Nikhil")
            .mobile("999999932")
            .build();

        Student student = Student.builder()
            .firstName("Shivan")
            .emailId("shivan@gmail.com")
            .lastName("Kumar")
            .guardian(guardian)
            .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {

        List<Student> studentList = 
                studentRepository.findAll();

        System.out.println("StudentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = 
            studentRepository.findByFirstName("Shivan");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = 
            studentRepository.findByFirstNameContaining("sh");

        System.out.println("Students = " + students);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> students = 
            studentRepository.findByGuardianName("Nikhil");

        System.out.println("students = " + students);
    }

    @Test
    public void printgetStudentByEmailAddress(){
        Student student = 
            studentRepository.getStudentByEmailAddress(
                "shabbir@gmail.com"
            );

        System.out.println("students = " + student);

    }

    @Test
    public void printgetStudentFirstNameByEmailAddress() {
        String firstName = 
            studentRepository.getStudentFirstNameByEmailAddress("shivan@gmail.com");

        System.out.println("firstName = " + firstName);
    }

    @Test
    public void printgetStudentByEmailAddressNative() {
        Student student = 
            studentRepository.getStudentByEmailAddressNative("shivan@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void printgetStudentByEmailAddressNativeNamedParam() {
        Student student = 
            studentRepository.getStudentByEmailAddressNativeNamedParam("shivan@gmail.com");

        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest() {
        studentRepository.updateStudentNameByEmailId(
            "shabbir dawoodi", 
            "shabbir@gmail.com"
            );
    }
}
