package com.example.school.service;

import com.example.school.domain.model.Exam;
import com.example.school.domain.repository.ExamRepository;
import com.example.school.domain.repository.StudentRepository;
import com.example.school.domain.repository.TeacherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback
class ExamServiceIT {

    @Autowired
    private ExamService examService;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private TeacherRepository teacherRepository;
    @BeforeEach
    void setUp() {
    }
    @Test
    void schouldGetAllExams() {

        // given
        examRepository.deleteAll();

        examRepository.saveAll(List.of(
                new Exam("Exam 1"),
                new Exam("Exam 2"),
                new Exam("Exam 3")
        ));

        // when
        List<Exam> exams = examService.getExams();

        // then
        assertThat(exams)
                .hasSize(3)
                .extracting(Exam::getName)
                .containsExactlyInAnyOrder("Exam 1", "Exam 2", "Exam 3");
    }
    @Test
    void schouldSingleGetExam() {

        // given
        Exam exam = new Exam("Exam 2");

        examRepository.saveAll(List.of(
                new Exam("Exam 1"),
                exam,
                new Exam("Exam 3")

        ));

        //when
        Exam result = examService.getExam(exam.getId());

        //then
        assertThat(result.getId()).isEqualTo(exam.getId());
    }
    @Test
    void schouldCreateExam() {

        // given
        Exam exam = new Exam("Exam");

        //when
        Exam result = examService.createExam(exam);

        //then
        assertThat(result.getName()).isEqualTo(exam.getName());
        assertThat(result.getName()).isEqualTo(examRepository.getById(result.getId()).getName());
    }
    @Test
    void shouldUpdateExam() {

        // given
        Exam exam = new Exam("Exam");
        exam = examService.createExam(exam);

        exam.setName("updated");
    }
    @Test
    void schouldDeleteExam() {
    }
}