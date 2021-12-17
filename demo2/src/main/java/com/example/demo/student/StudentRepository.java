package com.example.demo.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    /**
     * There are two ways to do Specific Query using
     * annotation @Query(SELECT * FROM student WHERE email = email)
     *  OR
     *  Without query annotation
     */

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentsByEmail(String email);


}
