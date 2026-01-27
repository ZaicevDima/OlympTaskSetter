package org.liman.olymp_task_setter.olympiad_person_core_shared;

public record StudentView(String name,
                          String surname,
                          String patronymic,
                          String school,
                          int classNumber) implements PersonView {
}
