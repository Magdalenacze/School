package com.example.school.controller;

import com.example.school.domain.model.Teacher;
import com.example.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/teachers")
@RequiredArgsConstructor
public class TeacherApiController {

    private final TeacherService teacherService;

    @GetMapping("{id}")
    Teacher getTeacher(@PathVariable UUID id) {
        return teacherService.getTeacher(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Teacher createTeacher(@RequestBody Teacher teacher) {
        return teacherService.createTeacher(teacher);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Teacher updateTeacher(@PathVariable UUID id, @RequestBody Teacher teacher) {
        return teacherService.updateTeacher(id, teacher);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteTeacher(@PathVariable UUID id) {
        teacherService.deleteTeacher(id);
    }
}
