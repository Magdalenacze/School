package com.example.school.service;

import com.example.school.domain.model.Teacher;
import com.example.school.domain.repository.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Transactional(readOnly = true)
    public Teacher getTeacher(UUID id) {
        return teacherRepository.getReferenceById(id);
    }

    @Transactional
    public Teacher createTeacher(Teacher teacherRequest) {
        Teacher teacher = new Teacher();
        teacher.setName(teacherRequest.getName());

        return teacherRepository.save(teacher);
    }

    @Transactional
    public Teacher updateTeacher(UUID id, Teacher teacherRequest) {
        Teacher teacher = teacherRepository.getReferenceById(id);
        teacher.setName(teacherRequest.getName());

        return teacherRepository.save(teacher);
    }

    @Transactional
    public void deleteTeacher(UUID id) {
        teacherRepository.deleteById(id);
    }
}