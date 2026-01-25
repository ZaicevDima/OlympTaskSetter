package org.liman.olymp_task_setter.olympiad_task_adapter_web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.liman.olymp_task_setter.controller.*;
import org.liman.olymp_task_setter.dto.internal.IncomingOlympiadDTO;
import org.liman.olymp_task_setter.dto.result.ResultOlympiadDTO;
import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadView;
import org.liman.olymp_task_setter.olympiad_task_use_cases.UpsertOlympiadUseCase;
import org.liman.olymp_task_setter.swagger.OpenAPIExample;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/olympiads")
public class OlympiadController implements
        AddNewOlympiad,
        UpdateOlympiad,
        DeleteOlympiad,
        FetchOlympiadByNameAndYear,
        FetchOlympiadById {

    private final UpsertOlympiadUseCase upsertOlympiadUseCase;

    public OlympiadController(UpsertOlympiadUseCase upsertOlympiadUseCase) {
        this.upsertOlympiadUseCase = upsertOlympiadUseCase;
    }

    @Operation(
            operationId = "olympiads-controller-add-new-olympiad",
            summary = "Добавление новой олимпиады",
            description = "Информация об олимпиаде предоставляется в виде записи с информацией об олимпиаде",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
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
    public ResponseEntity<UUID> add(@RequestBody IncomingOlympiadDTO olympiadDTO) {
        OlympiadView olympiadView = mapToOlympiadView(olympiadDTO);
        upsertOlympiadUseCase.saveNewOlympiad(olympiadView);

        return ResponseEntity.accepted().body(olympiadView.id());
    }

    @Operation(
            operationId = "olympiads-controller-add-new-olympiad",
            summary = "Обновление олимпиады",
            description = "Информация об олимпиаде предоставляется в виде записи с информацией об олимпиаде",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "1. Валидный запрос на обновление олимпиады",
                                                    description = "Пример обновления олимпиады с валидными данными",
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
                            description = "Результат обновления олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Олимпиада не зарегистрирована"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при обновлении олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<ResultOlympiadDTO> update(UUID id, IncomingOlympiadDTO olympiadDTO) {
        OlympiadView olympiadView = mapToOlympiadView(id, olympiadDTO);
        upsertOlympiadUseCase.updateOlympiad(olympiadView);
        ResultOlympiadDTO result = new ResultOlympiadDTO(id, olympiadDTO.name(), olympiadDTO.year());

        return ResponseEntity.accepted().body(result);
    }

    @Operation(
            operationId = "olympiads-controller-add-new-olympiad",
            summary = "Удаление олимпиады",
            description = "Информация об олимпиаде предоставляется в виде идентификатора олимпиады"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат обновления олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Олимпиада не зарегистрирована"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при обновлении олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<Void> delete(UUID id) {
        upsertOlympiadUseCase.deleteOlympiad(id);

        return ResponseEntity.accepted().build();
    }

    @Operation(
            operationId = "olympiads-controller-add-new-olympiad",
            summary = "Получение информации об олимпиаде по имени и году проведения",
            description = "Информация об олимпиаде предоставляется в виде записи с информацией об олимпиаде"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат получения олимпиады по названию и году проведения"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Олимпиада не найдена"
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
    public ResponseEntity<ResultOlympiadDTO> fetchByNameAndYear(String name, Integer year) {
        OlympiadView olympiad = upsertOlympiadUseCase.fetchOlympiad(name, year);
        ResultOlympiadDTO result = new ResultOlympiadDTO(olympiad.id(), olympiad.name(), olympiad.year());

        return ResponseEntity.accepted().body(result);
    }


    @Operation(
            operationId = "olympiads-controller-add-new-olympiad",
            summary = "Получение информации об олимпиаде по идентификатору олимпиады",
            description = "Информация об олимпиаде предоставляется в виде записи с информацией об олимпиаде"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат получения олимпиады по идентификатору"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Олимпиада не найдена"
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
    public ResponseEntity<ResultOlympiadDTO> fetchById(UUID id) {
        OlympiadView olympiad = upsertOlympiadUseCase.fetchOlympiad(id);
        ResultOlympiadDTO result = new ResultOlympiadDTO(olympiad.id(), olympiad.name(), olympiad.year());

        return ResponseEntity.accepted().body(result);
    }

    private OlympiadView mapToOlympiadView(IncomingOlympiadDTO incomingOlympiadDTO) {
        UUID id = UUID.randomUUID();
        return new OlympiadView(id, incomingOlympiadDTO.name(), incomingOlympiadDTO.year());
    }

    private OlympiadView mapToOlympiadView(UUID id, IncomingOlympiadDTO incomingOlympiadDTO) {
        return new OlympiadView(id, incomingOlympiadDTO.name(), incomingOlympiadDTO.year());
    }
}