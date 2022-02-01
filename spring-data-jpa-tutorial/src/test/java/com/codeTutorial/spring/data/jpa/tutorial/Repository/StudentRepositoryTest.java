package com.codeTutorial.spring.data.jpa.tutorial.Repository;

import com.codeTutorial.spring.data.jpa.tutorial.Entity.Guardian;
import com.codeTutorial.spring.data.jpa.tutorial.Entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("kayacihat@gmail.com")
                .firstName("Cihat Can")
                .lastName("KAYA")
        //   .guardianName("ASdd")
        //   .guardianMobile("5433555535")
                  .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian= Guardian.builder()
                .email("guardian@gmail.com")
                .name("guardian")
                .mobile("112334956")
                .build();

        Student student=Student.builder()
                .firstName("deneme")
                .emailId("deneme@gmail.com")
                .lastName("dene")
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
    public void printStudentByFirstName(){

        List<Student> students=
        studentRepository.findByFirstName("Cihat can");

        System.out.println("students = "+ students);
    }


    @Test
    public void printStudentByFirstNameContaining(){

        List<Student> students=
                studentRepository.findByFirstNameContaining("Cihat");

        System.out.println("students = "+ students);
    }

    @Test
    public void printStudentBasedOnGUardianName(){
        List<Student> students =
                studentRepository.findByGuardianName("guardian");
        System.out.println("Guardian = "+ students);
    }

    @Test
    public void printGetStudentByEmailAdress(){
        Student student =
                studentRepository.getStudentByEmailAdress(
                      "deneme@gmail.com"
                );
        System.out.println("students = "+ student);
    }

    @Test
    public void printGetStudentFirstNameByEmailAdress(){
        String firstname =
                studentRepository.getStudentFirstNameByEmailAdress(
                        "deneme@gmail.com"
                );
        System.out.println("firstName = "+ firstname);
    }

    @Test
    public void printgetStudentByEmailAdressNative(){
        Student student =
                studentRepository.getStudentByEmailAdressNative(
                        "kayacihat@gmail.com"
                );
        System.out.println("students = "+ student);
    }

    @Test
    public void printgetStudentByEmailAdressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAdressNativeNamedParam(
                        "kayacihat@gmail.com"
                );
        System.out.println("students = "+ student);
    }

    @Test
    public void updateStudentNamedByEmailIdTest() {
        studentRepository.updateStudentNamedByEmailId(
                "can",
                "kayacihat@gmail.com"
        );
    }
}