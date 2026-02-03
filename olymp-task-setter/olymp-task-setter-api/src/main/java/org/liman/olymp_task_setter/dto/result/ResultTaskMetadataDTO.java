package org.liman.olymp_task_setter.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResultTaskMetadataDTO(
        @Schema(title = "Идентификатор метаданных задачи")
        UUID id,

        @Schema(title = "Идентификатор олимпиады")
        UUID olympiadId,

        @Schema(title = "Номер задачи")
        int taskNumber,

        @Schema(title = "Номер класса")
        Integer classNumber,

        @Schema(title = "Дата создания")
        LocalDateTime createdAt) {
}
