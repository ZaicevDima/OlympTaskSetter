package org.liman.olymp_task_setter.task_api.task;

import org.liman.olymp_task_setter.task_api.model.TaskModel;

import java.util.UUID;

@FunctionalInterface
public interface AddTaskAPI {

    UUID add(TaskModel task);
}
