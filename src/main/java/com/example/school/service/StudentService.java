package com.example.school.service;

import com.example.school.domain.model.Student;
import com.example.school.domain.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional(readOnly = true)
    public Student getStudent(UUID id) {
        return studentRepository.getReferenceById(id);
    }

    @Transactional
    public Student createStudent(Student studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());

        return studentRepository.save(student);
    }

    @Transactional
    public Student updateStudent(UUID id, Student studentRequest) {
        Student student = studentRepository.getReferenceById(id);
        student.setName(studentRequest.getName());

        return studentRepository.save(student);
    }

    @Transactional
    public void deleteStudent(UUID id) {
        studentRepository.deleteById(id);
    }
}