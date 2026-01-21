package org.liman.olymp_task_setter.dto.internal;

import io.swagger.v3.oas.annotations.media.Schema;

public record IncomingOlympiadDTO(@Schema(title = "Название олимпиады")
                                  String name,
                                  @Schema(title = "Год проведения олимпиады")
                                  Integer year) {
}
