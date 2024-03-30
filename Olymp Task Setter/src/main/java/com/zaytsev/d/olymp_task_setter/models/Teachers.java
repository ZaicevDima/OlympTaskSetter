package com.zaytsev.d.olymp_task_setter.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Teachers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String surname;

    private String patronymic;

    private String school;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Grades> gradesList;


    public Teachers() {

    }


    public Teachers(String name, String surname, String patronymic, String school) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.school = school;
    }


    public Teachers(String name, String surname, String school) {
        this.name = name;
        this.surname = surname;
        this.school = school;
    }
    public Teachers(String name, String surname, String school, List<Grades> gradesList) {
        this.name = name;
        this.surname = surname;
        this.school = school;
        this.gradesList = gradesList;
    }
    public Teachers(String name, String surname, String patronymic, String school, List<Grades> gradesList) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.school = school;
        this.gradesList = gradesList;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

