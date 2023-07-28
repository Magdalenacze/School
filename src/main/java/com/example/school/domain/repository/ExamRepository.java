package com.example.school.domain.repository;

import com.example.school.domain.model.Exam;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ExamRepository extends JpaRepository<Exam, UUID> {

    List<Exam> findAllByStudentId(UUID id, Pageable pageable);
    List<Exam> findAllByTeacherId(UUID id, Pageable pageable);
}