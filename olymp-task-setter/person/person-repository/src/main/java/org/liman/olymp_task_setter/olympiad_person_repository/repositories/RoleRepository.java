package org.liman.olymp_task_setter.olympiad_person_repository.repositories;

import org.liman.olymp_task_setter.olympiad_person_repository.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
}
