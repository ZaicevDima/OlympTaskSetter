package org.liman.olymp_task_setter.controller.task.task_metadata;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.result.ResultTaskMetadataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "4. API для работы с метаданными задач олимпиды",
        description = "Раздел содержит api для работы с метаданными задач олимпиды")
@Validated
@FunctionalInterface
public interface FetchTaskMetadataById {

    @GetMapping("/fetch/{id}")
    ResponseEntity<ResultTaskMetadataDTO> fetchById(@PathVariable UUID id);
}
