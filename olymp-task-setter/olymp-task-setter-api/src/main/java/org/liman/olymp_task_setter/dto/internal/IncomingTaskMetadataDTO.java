package org.liman.olymp_task_setter.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.UUID;

public record IncomingTaskMetadataDTO(
        @Schema(title = "Идентификатор олимпиады")
        UUID olympiadId,

        @Schema(title = "Номер задачи")
        @Min(value = 1)
        Integer taskNumber,

        @Schema(title = "Номер класса")
        @Min(value = 1)
        @Max(value = 11)
        Integer classNumber) {
}
