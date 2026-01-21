package org.liman.olymp_task_setter.olympiad_task_adapter_web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.liman.olymp_task_setter.controller.AddNewOlympiad;
import org.liman.olymp_task_setter.dto.internal.IncomingOlympiadDTO;
import org.liman.olymp_task_setter.swagger.OpenAPIExample;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/olympiads")
public class OlympiadController implements AddNewOlympiad {

    @Operation(
            operationId = "olympiads-controller-add-new-olympiad",
            summary = "Добавление новой олимпиады",
            description = "Информация об олимпиаде предоставляется в виде записи с информацией об олимпиаде",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody( // Используйте полное имя
                    required = true,
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "1. Валидный запрос на добавление олимпиады",
                                                    description = "Пример добавления олимпиады с валидными данными",
                                                    value = OpenAPIExample.SAVE_OLYMPIAD
                                            )
                                    }
                            )
                    }
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат добавления олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при добавлении олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<UUID> execute(@RequestBody IncomingOlympiadDTO olympiadDTO) {
        return ResponseEntity.accepted().body(UUID.randomUUID());
    }
}