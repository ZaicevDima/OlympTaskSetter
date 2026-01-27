package org.liman.olymp_task_setter.olympiad_person_core_internal;

import org.liman.olymp_task_setter.olympiad_person_core_shared.PersonView;
import org.liman.olymp_task_setter.olympiad_person_core_shared.StudentView;

public final class Student implements Person {

    private String name;
    private String surname;
    private String patronymic;
    private String school;
    private int classNumber;

    Student(String name, String surname, String patronymic, String school, int classNumber) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.school = school;
        this.classNumber = classNumber;
    }

    public PersonView view() {
        return new StudentView(name, surname, patronymic, school, classNumber);
    }

    public int getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(int classNumber) {
        this.classNumber = classNumber;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
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
}

