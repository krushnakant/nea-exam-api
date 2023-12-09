// Project : eaxmpaperapi -> com.nea.eaxmpaper.repository -> TeacherRepository.java
// Author  : krushnakant
// Created : 9 Dec 2023 15:44:57
package com.nea.eaxmpaper.repository;

import com.nea.eaxmpaper.model.Student;
import com.nea.eaxmpaper.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author krushnakant
 */
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    public Student findByTeacherID(Integer teacherID);
}
