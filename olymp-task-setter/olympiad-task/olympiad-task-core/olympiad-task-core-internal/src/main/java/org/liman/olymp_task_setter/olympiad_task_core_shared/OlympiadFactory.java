package org.liman.olymp_task_setter.olympiad_task_core_shared;

import org.liman.olymp_task_setter.olympiad_task_core_internal.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class OlympiadFactory {

    public Olympiad createOlympiad(OlympiadId id,
                                   OlympiadName name,
                                   ClassNumber classNumber,
                                   List<OlympiadTask> tasks,
                                   Year year,
                                   Instant createdAt,
                                   Instant modifiedAt) {
        return new Olympiad(id, name, classNumber, tasks, year, createdAt, modifiedAt);
    }
}
