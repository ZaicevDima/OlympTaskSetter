package com.zaytsev.d.olymp_task_setter.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class GradesValues {
    @Id
    @Column(unique=true)
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private String grade;

    public GradesValues(String grade) {
        this.grade = grade;
    }

    public GradesValues() {

    }
}
