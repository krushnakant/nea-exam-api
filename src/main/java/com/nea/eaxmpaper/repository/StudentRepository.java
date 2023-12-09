// Project : eaxmpaperapi -> com.nea.eaxmpaper.repository -> StudentRepository.java
// Author  : krushnakant
// Created : 9 Dec 2023 12:52:17
package com.nea.eaxmpaper.repository;

import com.nea.eaxmpaper.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author krushnakant
 */
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // here method name is same as named query >>> @NamedQuery(name = "Student.findByStudentID"
    public Student findByStudentID(Integer studentID);

    public Student findByFName(String fName);

}
