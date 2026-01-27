package org.liman.olymp_task_setter.olympiad_person_repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "admins", schema = "person")
public class AdminEntity extends BasePerson {
}
