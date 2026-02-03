package org.liman.olymp_task_setter.task_api.task;

import org.liman.olymp_task_setter.task_api.model.ResultTaskModel;
import org.liman.olymp_task_setter.task_api.model.TaskModel;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FunctionalInterface
public interface UpdateTaskAPI {

    @PostMapping("/update/{id}")
    ResultTaskModel update(UUID id, TaskModel task);
}
