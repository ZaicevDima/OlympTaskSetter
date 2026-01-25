package org.liman.olymp_task_setter.olympiad_task_use_cases.exceptions;

public class EntityAlreadyExistsException extends RuntimeException {

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
