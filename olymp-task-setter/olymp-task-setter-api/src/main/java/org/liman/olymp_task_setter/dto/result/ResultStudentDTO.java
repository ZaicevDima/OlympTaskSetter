package org.liman.olymp_task_setter.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record ResultStudentDTO(@Schema(title = "Идентификатор ученика")
                               UUID id,
                               @Schema(title = "Имя ученика")
                               String name,
                               @Schema(title = "Фамилия ученика")
                               String surname,
                               @Schema(title = "Отчество ученика")
                               String patronymic,
                               @Schema(title = "Учебное заведение ученика")
                               String school,
                               @Schema(title = "Номер класса ученика")
                               int classNumber) implements ResultPersonDTO {
}
