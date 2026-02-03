package org.liman.olymp_task_setter.task_api.task;

import org.liman.olymp_task_setter.task_api.model.ResultTaskModel;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@FunctionalInterface
public interface FetchTaskByIdAPI {

    @GetMapping("/fetch/{id}")
    ResultTaskModel fetchById(UUID id);
}
