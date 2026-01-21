package org.liman.olymp_task_setter.olympiad_task_core_internal;

import java.util.Objects;

public record OlympiadTask(TaskStatus status) {

    public OlympiadTask {
        Objects.requireNonNull(status, "OlympiadTask status mustn't be null");
    }
}
