package org.liman.olymp_task_setter.controller.person;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.liman.olymp_task_setter.dto.result.ResultPersonDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "2. API для работы с участниками олимпиад", description = "Раздел содержит api для работы с участниками олимпиад")
@Validated
@FunctionalInterface
public interface FetchPersonByUsername {

    @GetMapping("/fetch/")
    ResponseEntity<ResultPersonDTO> fetchByUsername(@RequestParam String name,
                                                    @RequestParam String surname,
                                                    @RequestParam String patronymic);
}
