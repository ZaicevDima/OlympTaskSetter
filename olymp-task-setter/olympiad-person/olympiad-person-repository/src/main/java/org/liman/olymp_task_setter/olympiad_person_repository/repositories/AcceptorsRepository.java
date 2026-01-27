package org.liman.olymp_task_setter.olympiad_person_repository.repositories;

import org.liman.olymp_task_setter.olympiad_person_repository.entities.AcceptorsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AcceptorsRepository extends JpaRepository<AcceptorsEntity, UUID> {
    Optional<AcceptorsEntity> findFirstByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
}
