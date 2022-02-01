package com.codeTutorial.spring.data.jpa.tutorial.Repository;

import com.codeTutorial.spring.data.jpa.tutorial.Entity.Course;
import com.codeTutorial.spring.data.jpa.tutorial.Entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

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
                        .url("www.mynet.com")
                        .course(course)
                        .build();

        repository.save(courseMaterial);
    }

    @Test
    public void printAllCoursesMaterials() {
        List<CourseMaterial> courseMaterials =
                repository.findAll();
        System.out.println("courses materials = " + courseMaterials);
    }
}