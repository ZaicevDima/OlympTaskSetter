package org.liman.olymp_task_setter.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.internal.IncomingOlympiadDTO;
import org.liman.olymp_task_setter.dto.result.ResultOlympiadDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "1. API для работы с олимпиадами", description = "Раздел содержит api для работы с олимпиадами")
@Validated
@FunctionalInterface
public interface UpdateOlympiad {

    @PostMapping("/update/{id}")
    ResponseEntity<ResultOlympiadDTO> update(@PathVariable UUID id, @RequestBody IncomingOlympiadDTO olympiadDTO);
}
