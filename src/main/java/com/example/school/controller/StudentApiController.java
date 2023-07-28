package com.example.school.controller;

import com.example.school.domain.model.Student;
import com.example.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/students")
@RequiredArgsConstructor
public class StudentApiController {

    private final StudentService studentService;

    @GetMapping("{id}")
    Student getStudent(@PathVariable UUID id) {
        return studentService.getStudent(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Student updateStudent(@PathVariable UUID id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
    }
}
