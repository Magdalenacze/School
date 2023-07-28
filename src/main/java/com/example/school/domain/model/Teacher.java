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
@Table(name = "teachers")
@PrimaryKeyJoinColumn(name = "teacher_id")
@Getter
@Setter
@ToString
public class Teacher extends Person {

    @OneToMany(mappedBy = "teacher")
    private Set<Exam> exams;

    public Teacher() {
        super();
    }
}
