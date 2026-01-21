package org.liman.olymp_task_setter.olympiad_task_core_internal;

public record ClassNumber(int value) {

    public ClassNumber {
        if (value < 1 || value > 11) {
            throw new IllegalArgumentException("ClassNumber value must be more 0 and less 12");
        }
    }
}
