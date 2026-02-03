package org.liman.olymp_task_setter.task_repository.repositories;

import org.liman.olymp_task_setter.task_repository.entities.TaskMetadataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskMetadataRepository extends JpaRepository<TaskMetadataEntity, UUID> {
}
