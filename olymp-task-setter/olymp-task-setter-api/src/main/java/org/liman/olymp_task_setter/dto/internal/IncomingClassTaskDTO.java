package org.liman.olymp_task_setter.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.List;

public record IncomingClassTaskDTO(
        @Schema(title = "Идентификатор олимпиады")
        String olympiadId,

        @Schema(title = "Информация о задачах соответсвющего класса")
        List<ClassTaskInfoDTO> classTaskInfo) {
}
