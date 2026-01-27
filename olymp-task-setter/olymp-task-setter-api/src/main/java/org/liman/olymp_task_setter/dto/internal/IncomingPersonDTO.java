package org.liman.olymp_task_setter.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;

public record IncomingPersonDTO(@Schema(title = "Имя участника олимпиады")
                                String name,
                                @Schema(title = "Фамилия участника олимпиады")
                                String surname,
                                @Schema(title = "Отчество участника олимпиады")
                                String patronymic,
                                @Schema(title = "Роль на олимпиаде")
                                String role,
                                @Schema(title = "Школа участника олимпиады")
                                String school,
                                @Schema(title = "Класс участника олимпиады")
                                Integer classNumber) {
}
