package org.liman.olymp_task_setter.olympiad_task_repository.repositories;

import org.liman.olymp_task_setter.olympiad_task_repository.entities.olympiads.OlympiadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface OlympiadRepository extends JpaRepository<OlympiadEntity, Void> {
    Optional<OlympiadEntity> findById(UUID id);
    boolean existsById(UUID id);
}
