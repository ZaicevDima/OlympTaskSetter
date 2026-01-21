package org.liman.olymp_task_setter.olympiad_task_core_internal;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record OlympiadView(UUID id,
                           String name,
                           int classNumber,
                           List<OlympiadTask> tasks,
                           int year,
                           Instant createdAt,
                           Instant modifiedAt) {
}
