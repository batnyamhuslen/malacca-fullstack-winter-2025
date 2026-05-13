package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByEmail(String email);

    List<Student> findAllByFirstNameContainingIgnoreCase(String name);

    List<Student> findByGradeLevel(Integer gradeLevel);

    List<Student> findByGradeLevelLessThanEqual(Integer maxGrade);

    List<Student> findAllByOrderByLastNameAsc();

    @Query("SELECT s FROM Student s " +
           "WHERE s.gradeLevel >= :minGrade " +
           "ORDER BY s.gradeLevel")
    List<Student> findByMinGrade(@Param("minGrade") Integer minGrade);

    @Query(value = "SELECT COUNT(*) FROM student " +
                   "WHERE grade_level = :grade", 
           nativeQuery = true)
    Long countByGrade(@Param("grade") Integer grade);
}