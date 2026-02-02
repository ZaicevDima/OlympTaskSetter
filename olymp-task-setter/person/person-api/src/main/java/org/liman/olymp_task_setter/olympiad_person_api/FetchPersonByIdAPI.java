package org.liman.olymp_task_setter.olympiad_person_api;


import org.liman.olymp_task_setter.olympiad_person_repository.entities.BasePerson;

import java.util.UUID;

@FunctionalInterface
public interface FetchPersonByIdAPI {
    BasePerson fetchById(UUID id);
}
