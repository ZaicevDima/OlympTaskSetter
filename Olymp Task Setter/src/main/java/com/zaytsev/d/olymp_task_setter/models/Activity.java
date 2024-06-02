package com.zaytsev.d.olymp_task_setter.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String activityName;

    @Getter
    @Setter
    private int amountTasks;

    @OneToMany
    @Getter
    @Setter
    private List<GradesValues> gradesValuesList;

    public Activity() {

    }

    public Activity(String activityName, int amountTasks) {
        this.activityName = activityName;
        this.amountTasks = amountTasks;
    }

    public void addGradeValue(List<GradesValues> grades) {
        gradesValuesList.addAll(grades);
    }
}
