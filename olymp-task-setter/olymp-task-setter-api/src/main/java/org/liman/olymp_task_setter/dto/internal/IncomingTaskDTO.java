package org.liman.olymp_task_setter.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;

import java.util.UUID;

public record IncomingTaskDTO(@Schema(title = "Идентификатор метаданных задачи")
                              UUID taskMetadataId,

                              @Schema(title = "Идентификатор сдающего")
                              UUID studentId,

                              @Schema(title = "Идентификатор принимающего")
                              UUID acceptorId,

                              @Schema(title = "Статус задачи")
                              String status,

                              @Schema(title = "Номер попытки сдать задачу")
                              @Min(value = 1)
                              Integer attempt) {
}
