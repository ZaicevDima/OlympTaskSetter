package org.liman.olymp_task_setter.task_api.task;

import java.util.UUID;

@FunctionalInterface
public interface DeleteTaskAPI {

    void delete(UUID id);
}
