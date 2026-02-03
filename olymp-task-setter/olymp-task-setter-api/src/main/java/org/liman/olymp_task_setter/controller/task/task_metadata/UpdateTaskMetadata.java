package org.liman.olymp_task_setter.controller.task.task_metadata;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.internal.IncomingTaskMetadataDTO;
import org.liman.olymp_task_setter.dto.result.ResultTaskMetadataDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "4. API для работы с метаданными задач олимпиды",
        description = "Раздел содержит api для работы с метаданными задач олимпиды")
@Validated
@FunctionalInterface
public interface UpdateTaskMetadata {

    @PostMapping("/update/{id}")
    ResponseEntity<ResultTaskMetadataDTO> update(@PathVariable UUID id, @RequestBody IncomingTaskMetadataDTO taskMetadataDTO);
}
