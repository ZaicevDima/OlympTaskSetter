package org.liman.olymp_task_setter.olympiad_task_core_internal;

import java.util.Objects;

public record OlympiadName(String value) {

    public OlympiadName {
        Objects.requireNonNull(value, "OlympiadName value mustn't be null");

        if (value.isBlank()) {
            throw new IllegalArgumentException("OlympiadName value mustn't be blank");
        }
    }
}
