package org.liman.olymp_task_setter.olympiad_person_api;

import java.util.UUID;

@FunctionalInterface
public interface DeletePersonAPI {
    void deletePerson(UUID id);
}
