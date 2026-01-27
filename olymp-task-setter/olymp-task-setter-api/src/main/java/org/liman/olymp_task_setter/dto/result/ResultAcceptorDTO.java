package org.liman.olymp_task_setter.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record ResultAcceptorDTO(@Schema(title = "Идентификатор принимающего")
                                UUID id,
                                @Schema(title = "Имя принимающего")
                                String name,
                                @Schema(title = "Фамилия принимающего")
                                String surname,
                                @Schema(title = "Отчество принимающего")
                                String patronymic) implements ResultPersonDTO {
}
