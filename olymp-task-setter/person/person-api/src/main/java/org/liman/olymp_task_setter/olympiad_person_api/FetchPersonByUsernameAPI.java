package org.liman.olymp_task_setter.olympiad_person_api;


import org.liman.olymp_task_setter.olympiad_person_repository.entities.BasePerson;

@FunctionalInterface
public interface FetchPersonByUsernameAPI {
    BasePerson fetchByUsername(String name, String surname, String patronymic);
}
