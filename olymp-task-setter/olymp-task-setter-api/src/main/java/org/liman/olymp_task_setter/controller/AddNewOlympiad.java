package org.liman.olymp_task_setter.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.internal.IncomingOlympiadDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "1. API для работы с олимпиадами", description = "Раздел содержит api для работы с олимпиадами")
@Validated
@FunctionalInterface
public interface AddNewOlympiad {

    @PostMapping("/add")
    ResponseEntity<UUID> execute(@RequestBody IncomingOlympiadDTO olympiadDTO);
}
