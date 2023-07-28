package com.example.school.service;

import com.example.school.domain.model.Exam;
import com.example.school.domain.repository.ExamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ExamService {
    private final ExamRepository examRepository;
    public ExamService(ExamRepository examRepository) {
        this.examRepository = examRepository;
    }
    @Transactional(readOnly = true)
    public List<Exam> getExams() {
        return examRepository.findAll();
    }
    @Transactional(readOnly = true)
    public Exam getExam(UUID id) {
        return examRepository.getReferenceById(id);
    }
    @Transactional
    public Exam createExam(Exam examRequest) {
        Exam exam = new Exam();
        exam.setName(examRequest.getName());

        return examRepository.save(exam);
    }
    @Transactional
    public Exam updateExam(UUID id, Exam examRequest) {
        Exam exam = examRepository.getReferenceById(id);
        exam.setName(examRequest.getName());

        return examRepository.save(exam);
    }
    @Transactional
    public void deleteExam(UUID id) {
        examRepository.deleteById(id);
    }
}
