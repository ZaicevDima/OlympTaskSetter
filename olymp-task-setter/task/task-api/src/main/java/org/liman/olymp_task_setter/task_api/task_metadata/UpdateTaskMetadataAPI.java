package org.liman.olymp_task_setter.task_api.task_metadata;

import org.liman.olymp_task_setter.task_api.model.ResultTaskMetadataModel;
import org.liman.olymp_task_setter.task_api.model.TaskMetadataModel;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@FunctionalInterface
public interface UpdateTaskMetadataAPI {

    @PostMapping("/update/{id}")
    ResultTaskMetadataModel update(UUID id, TaskMetadataModel taskMetadata);
}
