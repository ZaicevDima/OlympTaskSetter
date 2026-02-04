package org.liman.olymp_task_setter.controller.olympiad;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.liman.olymp_task_setter.dto.internal.IncomingClassTaskDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "1. API для работы с олимпиадами", description = "Раздел содержит api для работы с олимпиадами")
@Validated
@FunctionalInterface
public interface CreateTasksByClass {

    @PostMapping("/create_tasks")
    ResponseEntity<String> createTasks(@Valid @RequestBody IncomingClassTaskDTO incomingClassTaskDTO);
}
