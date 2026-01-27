package org.liman.olymp_task_setter.controller.olympiad;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.result.ResultOlympiadDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "1. API для работы с олимпиадами", description = "Раздел содержит api для работы с олимпиадами")
@Validated
@FunctionalInterface
public interface FetchOlympiadById {

    @GetMapping("/fetch/{id}")
    ResponseEntity<ResultOlympiadDTO> fetchById(@PathVariable UUID id);
}
