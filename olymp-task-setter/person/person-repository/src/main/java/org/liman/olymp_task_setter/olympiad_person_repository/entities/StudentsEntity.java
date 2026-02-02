package org.liman.olymp_task_setter.olympiad_person_repository.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "students", schema = "person")
@Getter
@Setter
public class StudentsEntity extends BasePerson {

    @Column(name = "school")
    private String school;

    @Column(name = "class_number")
    private Integer classNumber;

}
