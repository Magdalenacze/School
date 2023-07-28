package com.example.school.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Table(name="exams")
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class Exam {

    @Id
    private UUID id;

    private String name;
    private double score;

    public Exam(String name) {
        this.name = name;
    }

    @ManyToOne
    private Student student;
    @ManyToOne
    private Teacher teacher;
}
