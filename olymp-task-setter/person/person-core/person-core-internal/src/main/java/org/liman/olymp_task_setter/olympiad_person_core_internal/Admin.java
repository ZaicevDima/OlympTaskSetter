package org.liman.olymp_task_setter.olympiad_person_core_internal;

import org.liman.olymp_task_setter.olympiad_person_core_shared.AdminView;
import org.liman.olymp_task_setter.olympiad_person_core_shared.PersonView;

public final class Admin implements Person {

    private String name;
    private String surname;
    private String patronymic;

    Admin(String name, String surname, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
    }

    public PersonView view() {
        return new AdminView(name, surname, patronymic);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
