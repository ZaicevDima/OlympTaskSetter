package com.zaytsev.d.olymp_task_setter.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;

    private String patronymic;

    private String classNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Grades> gradesList;


    public Students() {

    }


    public Students(String name, String surname, String patronymic, String classNumber) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.classNumber = classNumber;
    }


    public Students(String name, String surname, String classNumber) {
        this.name = name;
        this.surname = surname;
        this.classNumber = classNumber;
    }
    public Students(String name, String surname, String classNumber, List<Grades> gradesList) {
        this.name = name;
        this.surname = surname;
        this.classNumber = classNumber;
        this.gradesList = gradesList;
    }
    public Students(String name, String surname, String patronymic, String classNumber, List<Grades> gradesList) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.classNumber = classNumber;
        this.gradesList = gradesList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }
}
