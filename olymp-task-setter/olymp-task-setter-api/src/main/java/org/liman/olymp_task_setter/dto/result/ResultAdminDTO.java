package org.liman.olymp_task_setter.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record ResultAdminDTO(@Schema(title = "Идентификатор администратора")
                             UUID id,
                             @Schema(title = "Имя администратора")
                             String name,
                             @Schema(title = "Фамилия администратора")
                             String surname,
                             @Schema(title = "Отчество администратора")
                             String patronymic) implements ResultPersonDTO {
}
