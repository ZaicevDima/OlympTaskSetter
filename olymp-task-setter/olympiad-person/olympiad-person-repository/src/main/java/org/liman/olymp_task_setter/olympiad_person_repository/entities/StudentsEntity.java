package org.liman.olymp_task_setter.olympiad_person_repository.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "students", schema = "person")
public class StudentsEntity extends BasePerson {

    @Column(name = "school")
    private String school;

    @Column(name = "class_number")
    private Integer classNumber;

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

}
