package com.zaytsev.d.olymp_task_setter.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Getter
    @Setter
    private String taskName;
    @Getter
    @Setter
    private Long activityId;

    @Getter
    @Setter
    private String grade;
    @Getter
    @Setter
    private Long studentId;
    @Getter
    @Setter
    private Long teacherId;

    public Grades() {

    }

    public Grades(String taskName, Long activityId, String grade, Long studentId, Long teacherId) {
        this.taskName = taskName;
        this.activityId = activityId;
        this.grade = grade;
        this.studentId = studentId;
        this.teacherId = teacherId;
    }
}
