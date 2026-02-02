package org.liman.olymp_task_setter.olympiad_core_shared;

import java.util.Objects;
import java.util.UUID;

public record OlympiadId(UUID value) {

    public OlympiadId {
        Objects.requireNonNull(value, "OlympiadId mustn't be null");
    }
}
