package org.liman.olymp_task_setter.controller.person;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "2. API для работы с участниками олимпиад", description = "Раздел содержит api для работы с участниками олимпиад")
@Validated
@FunctionalInterface
public interface DeletePerson {

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);
}
