package org.liman.olymp_task_setter.olympiad_person_api;


import org.liman.olymp_task_setter.olympiad_person_core_shared.PersonView;

import java.util.UUID;

@FunctionalInterface
public interface SavePersonAPI {
    UUID addPerson(PersonView olympiadView);
}
