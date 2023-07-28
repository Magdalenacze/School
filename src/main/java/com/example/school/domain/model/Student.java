package com.example.school.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "students")
@PrimaryKeyJoinColumn(name = "student_id")
@Getter
@Setter
@ToString
public class Student extends Person {

    @OneToMany(mappedBy = "student")
    private Set<Exam> exams;

    public Student() {
        super();
    }
}
