package org.liman.olymp_task_setter.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public record ClassTaskInfoDTO(@Schema(title = "Номер класса")
                               @Min(value = 1)
                               @Max(value = 11)
                               Integer classNumber,

                               @Schema(title = "Количество задач")
                               @Min(1)
                               Integer tasksNumber) {
}
