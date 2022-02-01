package com.codeTutorial.spring.data.jpa.tutorial.Repository;

import com.codeTutorial.spring.data.jpa.tutorial.Entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository  extends JpaRepository<Teacher,Long> {
}
