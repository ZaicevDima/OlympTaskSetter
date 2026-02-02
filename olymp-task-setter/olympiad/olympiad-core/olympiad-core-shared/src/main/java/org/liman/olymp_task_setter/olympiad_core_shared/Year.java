package org.liman.olymp_task_setter.olympiad_core_shared;

public record Year(int value) {

    public Year {
        if (value < 1900 || value > 3000) {
            throw new IllegalArgumentException("Year value must be more 1900 and less 3000");
        }
    }
}
