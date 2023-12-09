// Project : eaxmpaperapi -> com.nea.eaxmpaper.controller -> StudentController.java
// Author  : krushnakant
// Created : 9 Dec 2023 12:51:24
package com.nea.eaxmpaper.controller;

import com.nea.eaxmpaper.model.Student;
import com.nea.eaxmpaper.repository.StudentRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author krushnakant
 */
@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentRepository repository;

    public StudentController(StudentRepository repository) {
        this.repository = repository;
    }

    /**
     * List All records
     *
     * @return
     */
    @GetMapping
    List<Student> findAll() {
        return repository.findAll();
    }

    /**
     * get Single student by Primary key(id)
     *
     * @param studentID
     * @return
     */
    @GetMapping("/{studentID}")
    Student findById(@PathVariable Integer studentID) {

        return repository.findByStudentID(studentID);
    }

    /**
     * Find student by its first name.
     *
     * @param fName
     * @return
     */
    @GetMapping("/name/{fName}")
    Student findByFirstName(@PathVariable String fName) {

        return repository.findByFName(fName);
    }

    /**
     * Add new Entry.
     *
     * @param newStudent
     * @return
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // 201
    Student create(@RequestBody Student newStudent) {
        return repository.save(newStudent);
    }

    /**
     * Update student based on primary key
     *
     * @param student
     * @return
     */
    @PutMapping
    public Student update(@RequestBody Student student) {
        return repository.save(student);
    }

    /**
     * delete a student based on primary key
     *
     * @param studentID
     */
    @ResponseStatus(HttpStatus.NO_CONTENT) // 204
    @DeleteMapping("/{studentID}")
    public void deleteById(@PathVariable Integer studentID) {
        repository.deleteById(studentID);
    }

}
