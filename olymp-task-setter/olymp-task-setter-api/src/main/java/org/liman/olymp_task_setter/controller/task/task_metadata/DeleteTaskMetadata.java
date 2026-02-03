package org.liman.olymp_task_setter.controller.task.task_metadata;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "4. API для работы с метаданными задач олимпиды",
        description = "Раздел содержит api для работы с метаданными задач олимпиды")
@Validated
@FunctionalInterface
public interface DeleteTaskMetadata {

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);
}
