package org.liman.olymp_task_setter.olympiad_person_repository.repositories;

import org.liman.olymp_task_setter.olympiad_person_repository.entities.StudentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentsEntity, UUID> {
    Optional<StudentsEntity> findFirstByNameAndSurnameAndPatronymic(String name, String surname, String patronymic);
}
