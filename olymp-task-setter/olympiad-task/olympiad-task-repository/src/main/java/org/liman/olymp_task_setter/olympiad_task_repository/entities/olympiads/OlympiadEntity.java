package org.liman.olymp_task_setter.olympiad_task_repository.entities.olympiads;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "olympiads")
@Getter
@Setter
public class OlympiadEntity {
    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private Integer year;

}
