package org.liman.olymp_task_setter.controller.person;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.internal.IncomingPersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Tag(name = "2. API для работы с участниками олимпиад", description = "Раздел содержит api для работы с участниками олимпиад")
@Validated
@FunctionalInterface
public interface AddNewPerson {

    @PostMapping("/add")
    ResponseEntity<UUID> add(@RequestBody IncomingPersonDTO personDTO);
}
