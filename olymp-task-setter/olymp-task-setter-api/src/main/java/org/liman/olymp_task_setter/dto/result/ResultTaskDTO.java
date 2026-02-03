package org.liman.olymp_task_setter.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResultTaskDTO(
        @Schema(title = "Идентификатор метаданных задачи")
        UUID id,

        @Schema(title = "Идентификатор метаданных задачи")
        UUID taskMetadataId,

        @Schema(title = "Идентификатор сдающего")
        UUID studentId,

        @Schema(title = "Идентификатор принимающего")
        UUID acceptorId,

        @Schema(title = "Статус задачи")
        String status,

        @Schema(title = "Номер попытки сдать задачу")
        Integer attempt,

        @Schema(title = "Дата и время ответа задачи")
        LocalDateTime createdAt) {
}
