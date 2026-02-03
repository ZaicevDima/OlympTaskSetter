package org.liman.olymp_task_setter.task_repository.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks_metadata", schema = "task")
@Getter
@Setter
public class TaskMetadataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "olympiad_id")
    UUID olympiadId;

    @Column(name = "number")
    int taskNumber;

    @Column(name = "class_number")
    int classNumber;

    @Column(name = "created_at")
    @CurrentTimestamp
    LocalDateTime createdAt;
}
