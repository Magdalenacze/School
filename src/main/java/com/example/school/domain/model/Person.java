package com.example.school.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
@ToString
public abstract class Person {

    private String name;

    @Id
    private UUID id;

    public Person() {
        this.id = UUID.randomUUID();
    }
    public Person(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
