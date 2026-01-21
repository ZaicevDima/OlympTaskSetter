package org.liman.olymp_task_setter.dto.result;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.UUID;

public record ResultOlympiadDTO(@Schema(title = "Идентификатор олимпиады")
                                UUID id,
                                @Schema(title = "Название олимпиады")
                                String name,
                                @Schema(title = "Год проведения олимпиады")
                                Integer year) {
}
