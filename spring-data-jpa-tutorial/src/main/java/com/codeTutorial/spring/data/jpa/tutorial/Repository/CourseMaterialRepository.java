package com.codeTutorial.spring.data.jpa.tutorial.Repository;

import com.codeTutorial.spring.data.jpa.tutorial.Entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {
}
