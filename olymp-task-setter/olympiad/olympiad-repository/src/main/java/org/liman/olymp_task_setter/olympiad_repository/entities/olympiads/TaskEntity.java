package org.liman.olymp_task_setter.olympiad_repository.entities.olympiads;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "tasks")
public class TaskEntity {
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getOlympiadId() {
        return olympiadId;
    }

    public void setOlympiadId(UUID olympiadId) {
        this.olympiadId = olympiadId;
    }

    public Integer getClassNumber() {
        return classNumber;
    }

    public void setClassNumber(Integer classNumber) {
        this.classNumber = classNumber;
    }

    public Integer getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(Integer taskNumber) {
        this.taskNumber = taskNumber;
    }

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "olympiad_id")
    private UUID olympiadId;

    @Column(name = "class_number")
    private Integer classNumber;

    @Column(name = "number")
    private Integer taskNumber;
}
