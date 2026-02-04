package org.liman.olymp_task_setter.task_api.task_metadata;

import org.liman.olymp_task_setter.task_api.model.TaskMetadataModel;

import java.util.Collection;

@FunctionalInterface
public interface AddAllTasksMetadataAPI {

    void addAll(Collection<TaskMetadataModel> tasksMetadata);
}
