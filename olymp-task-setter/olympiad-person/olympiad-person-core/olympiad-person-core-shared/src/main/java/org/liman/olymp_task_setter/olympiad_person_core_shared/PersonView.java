package org.liman.olymp_task_setter.olympiad_person_core_shared;

public sealed interface PersonView permits AdminView, AcceptorView, StudentView {
    String name();
    String surname();
    String patronymic();
}
