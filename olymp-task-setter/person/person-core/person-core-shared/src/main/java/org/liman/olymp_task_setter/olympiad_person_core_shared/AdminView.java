package org.liman.olymp_task_setter.olympiad_person_core_shared;

public record AdminView(String name,
                        String surname,
                        String patronymic) implements PersonView {
}
