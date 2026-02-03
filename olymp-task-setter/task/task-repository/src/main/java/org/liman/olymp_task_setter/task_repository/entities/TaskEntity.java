package org.liman.olymp_task_setter.task_repository.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tasks", schema = "task")
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(name = "task_information_id")
    UUID taskInformationId;

    @Column(name = "student_id")
    UUID studentId;

    @Column(name = "acceptor_id")
    UUID acceptorId;

    @Column(name = "status")
    String status;

    @Column(name = "attempt")
    int attempt;

    @Column(name = "created_at")
    @CurrentTimestamp
    LocalDateTime createdAt;
}
