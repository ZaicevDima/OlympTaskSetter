package org.liman.olymp_task_setter.olympiad_repository.repositories;

import org.liman.olymp_task_setter.olympiad_repository.entities.olympiads.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OlympiadTaskRepository extends JpaRepository<TaskEntity, Void> {
}
