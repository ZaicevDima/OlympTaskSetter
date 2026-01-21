package org.liman.olymp_task_setter.olympiad_task_repository.entities.olympiads;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "tasks")
@Getter
@Setter
public class TaskEntity {
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
