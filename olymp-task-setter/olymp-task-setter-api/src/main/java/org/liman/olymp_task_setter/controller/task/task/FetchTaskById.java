package org.liman.olymp_task_setter.controller.task.task;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.result.ResultTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "3. API для работы с задачами олимпиды", description = "Раздел содержит api для работы с задачами олимпиды")
@Validated
@FunctionalInterface
public interface FetchTaskById {

    @GetMapping("/fetch/{id}")
    ResponseEntity<ResultTaskDTO> fetchById(@PathVariable UUID id);
}
