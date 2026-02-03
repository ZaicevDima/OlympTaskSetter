package org.liman.olymp_task_setter.task_api.task_metadata;

import org.liman.olymp_task_setter.task_api.model.ResultTaskMetadataModel;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@FunctionalInterface
public interface FetchTaskMetadataByIdAPI {

    @GetMapping("/fetch/{id}")
    ResultTaskMetadataModel fetchById(UUID id);
}
