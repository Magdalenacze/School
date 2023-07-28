package com.example.school.controller;

import com.example.school.domain.model.Exam;
import com.example.school.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/exams")
@RequiredArgsConstructor
public class ExamApiController {

    private final ExamService examService;

    @GetMapping
    List<Exam> getExams() {
        return examService.getExams();
    }

    @GetMapping("{id}")
    Exam getExam(@PathVariable UUID id) {
        return examService.getExam(id);
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Exam createExam(@RequestBody Exam exam) {
        return examService.createExam(exam);
    }
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    Exam updateExam(@PathVariable UUID id, @RequestBody Exam exam) {
        return examService.updateExam(id, exam);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void deleteExam(@PathVariable UUID id) {
        examService.deleteExam(id);
    }
}