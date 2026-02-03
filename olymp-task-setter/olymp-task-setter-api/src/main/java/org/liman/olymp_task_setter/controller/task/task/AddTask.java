package org.liman.olymp_task_setter.controller.task.task;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.internal.IncomingTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "3. API для работы с задачами олимпиды", description = "Раздел содержит api для работы с задачами олимпиды")
@Validated
@FunctionalInterface
public interface AddTask {

    @PostMapping("/add")
    ResponseEntity<UUID> add(@RequestBody IncomingTaskDTO taskDTO);
}
