package org.liman.olymp_task_setter.olympiad_task_core_shared;

import org.liman.olymp_task_setter.olympiad_task_core_internal.*;

import java.time.Instant;
import java.util.List;

public class Olympiad {

    private final OlympiadId id;
    private final OlympiadName name;
    private final ClassNumber classNumber;
    private final List<OlympiadTask> tasks;
    private final Year year;
    private final Instant createdAt;
    private final Instant modifiedAt;

    Olympiad(OlympiadId id,
             OlympiadName name,
             ClassNumber classNumber,
             List<OlympiadTask> tasks,
             Year year,
             Instant createdAt,
             Instant modifiedAt) {
        this.id = id;
        this.name = name;
        this.classNumber = classNumber;
        this.tasks = tasks;
        this.year = year;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public OlympiadView view() {
        return new OlympiadView(id.value(), name.value(), classNumber.value(), tasks, year.value(), createdAt, modifiedAt);
    }
}
