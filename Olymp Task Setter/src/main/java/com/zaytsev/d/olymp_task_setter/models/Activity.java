package com.zaytsev.d.olymp_task_setter.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String activityName;

    @Getter
    @Setter
    private int amountTasks;

    public Activity() {

    }

    public Activity(String activityName, int amountTasks) {
        this.activityName = activityName;
        this.amountTasks = amountTasks;
    }
}
