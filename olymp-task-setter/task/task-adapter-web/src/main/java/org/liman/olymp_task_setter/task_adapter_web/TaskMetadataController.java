package org.liman.olymp_task_setter.task_adapter_web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.liman.olymp_task_setter.controller.task.task_metadata.AddTaskMetadata;
import org.liman.olymp_task_setter.controller.task.task_metadata.DeleteTaskMetadata;
import org.liman.olymp_task_setter.controller.task.task_metadata.FetchTaskMetadataById;
import org.liman.olymp_task_setter.controller.task.task_metadata.UpdateTaskMetadata;
import org.liman.olymp_task_setter.dto.internal.IncomingTaskMetadataDTO;
import org.liman.olymp_task_setter.dto.result.ResultTaskMetadataDTO;
import org.liman.olymp_task_setter.task_api.model.ResultTaskMetadataModel;
import org.liman.olymp_task_setter.task_api.model.TaskMetadataModel;
import org.liman.olymp_task_setter.task_use_cases.TaskMetadataUseCase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController
@RequestMapping("/v1/task-metadata")
public class TaskMetadataController implements AddTaskMetadata, DeleteTaskMetadata, UpdateTaskMetadata, FetchTaskMetadataById {

    private final TaskMetadataUseCase taskMetadataUseCase;

    public TaskMetadataController(TaskMetadataUseCase taskMetadataUseCase) {
        this.taskMetadataUseCase = taskMetadataUseCase;
    }

    @Operation(
            operationId = "task-controller-add-task-metadata",
            summary = "Добавление информации о задаче олимпиады",
            description = "Информация о задаче предоставляется в виде записи с информацией о задаче",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
//                                            @ExampleObject(
//                                                    name = "1. Валидный запрос на добавление информации об ответе",
//                                                    description = "Пример добавления информации об ответа",
//                                                    value = OpenAPIExample.REGISTRATION_ADMIN
//                                            )
                                    }
                            )
                    }
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат добавления задачи олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при добавлении информации ответа участника олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<UUID> add(IncomingTaskMetadataDTO taskMetadataDTO) {
        TaskMetadataModel taskMetadataModel = mapToModel(taskMetadataDTO);
        UUID newTaskId = taskMetadataUseCase.add(taskMetadataModel);

        return ResponseEntity.accepted().body(newTaskId);
    }

    @Operation(
            operationId = "task-controller-add-task-metadata",
            summary = "Удаление информации о задаче олимпиады",
            description = "Информация о задаче предоставляется в виде записи с информацией о задаче"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат добавления задачи олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Задача не найдена"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при добавлении информации ответа участника олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<Void> delete(UUID id) {
        taskMetadataUseCase.delete(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(
            operationId = "task-controller-fetch-task-metadata",
            summary = "Получение информации о задаче олимпиады по идентификатору",
            description = "Информация о задаче предоставляется в виде записи с информацией о задаче"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат добавления задачи олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Задача не найдена"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при добавлении информации ответа участника олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<ResultTaskMetadataDTO> fetchById(UUID id) {
        ResultTaskMetadataModel resultTaskMetadataModel = taskMetadataUseCase.fetchById(id);
        ResultTaskMetadataDTO resultTaskMetadataDTO = mapToResultDTO(resultTaskMetadataModel);

        return ResponseEntity.accepted().body(resultTaskMetadataDTO);
    }

    @Operation(
            operationId = "task-controller-update-task-metadata",
            summary = "Обновление информации о задаче олимпиады",
            description = "Информация о задаче предоставляется в виде записи с информацией о задаче",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
//                                            @ExampleObject(
//                                                    name = "1. Валидный запрос на добавление информации об ответе",
//                                                    description = "Пример добавления информации об ответа",
//                                                    value = OpenAPIExample.REGISTRATION_ADMIN
//                                            )
                                    }
                            )
                    }
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат добавления задачи олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Задача не найдена"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при добавлении информации ответа участника олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<ResultTaskMetadataDTO> update(UUID id, IncomingTaskMetadataDTO taskMetadataDTO) {
        TaskMetadataModel taskMetadataModel = mapToModel(taskMetadataDTO);
        ResultTaskMetadataModel resultTaskMetadataModel = taskMetadataUseCase.update(id, taskMetadataModel);
        ResultTaskMetadataDTO resultTaskMetadataDTO = mapToResultDTO(resultTaskMetadataModel);

        return ResponseEntity.accepted().body(resultTaskMetadataDTO);
    }

    private TaskMetadataModel mapToModel(IncomingTaskMetadataDTO taskMetadataDTO) {
        UUID olympiadId = taskMetadataDTO.olympiadId();
        Integer taskNumber = taskMetadataDTO.taskNumber();
        Integer classNumber = taskMetadataDTO.classNumber();

        return new TaskMetadataModel(olympiadId, taskNumber, classNumber);
    }

    private ResultTaskMetadataDTO mapToResultDTO(ResultTaskMetadataModel resultTaskMetadataModel) {
        UUID id = resultTaskMetadataModel.id();
        UUID olympiadId = resultTaskMetadataModel.olympiadId();
        int taskNumber = resultTaskMetadataModel.taskNumber();
        int classNumber = resultTaskMetadataModel.classNumber();
        LocalDateTime createdAt = resultTaskMetadataModel.createdAt();

        return new ResultTaskMetadataDTO(id, olympiadId, taskNumber, classNumber, createdAt);
    }
}
