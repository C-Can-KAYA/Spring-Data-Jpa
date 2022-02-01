package com.codeTutorial.spring.data.jpa.tutorial.Repository;

import com.codeTutorial.spring.data.jpa.tutorial.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    List<Student> findByLastNameNotNull();

    List<Student> findByGuardianName(String guardianName);

    Student findByFirstNameAndLastName(String firstName,
                                       String lastName);

    //JPQL
    @Query("select s from Student s where s.emailId= ?1")
    Student getStudentByEmailAdress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId= ?1")
    String getStudentFirstNameByEmailAdress(String emailId);

    //NativeQuery
    @Query(
            value = "select * from tbl_student s where s.email_address = ?1" ,
                    nativeQuery = true
    )
    Student getStudentByEmailAdressNative(String emailId);

    //Native Named Param
    @Query(
            value = "select * from tbl_student s where s.email_address = :emailId" ,
            nativeQuery = true
    )
    Student getStudentByEmailAdressNativeNamedParam(
            @Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
            value="update tbl_student set first_name = ?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNamedByEmailId(String firstName, String emailId);
}
