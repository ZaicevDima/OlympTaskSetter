package org.liman.olymp_task_setter.task_adapter_web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.liman.olymp_task_setter.controller.task.task.AddTask;
import org.liman.olymp_task_setter.controller.task.task.DeleteTask;
import org.liman.olymp_task_setter.controller.task.task.FetchTaskById;
import org.liman.olymp_task_setter.controller.task.task.UpdateTask;
import org.liman.olymp_task_setter.dto.internal.IncomingTaskDTO;
import org.liman.olymp_task_setter.dto.result.ResultTaskDTO;
import org.liman.olymp_task_setter.task_api.model.ResultTaskModel;
import org.liman.olymp_task_setter.task_api.model.TaskModel;
import org.liman.olymp_task_setter.task_use_cases.TaskUseCase;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

@RestController("/v1/tasks/")
public class TaskController implements AddTask, DeleteTask, FetchTaskById, UpdateTask {

    private final TaskUseCase taskUseCase;

    public TaskController(TaskUseCase taskUseCase) {
        this.taskUseCase = taskUseCase;
    }

    @Operation(
            operationId = "task-controller-add-task",
            summary = "Добавление информации об ответе ученика по задаче олимпиады",
            description = "Информация об информации предоставляется в виде записи с информацией об ответе",
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
                            description = "Результат добавления информации ответа участника олимпиады"
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
    public ResponseEntity<UUID> add(IncomingTaskDTO taskDTO) {
        TaskModel taskModel = mapToModel(taskDTO);
        UUID newTaskId = taskUseCase.add(taskModel);

        return ResponseEntity.accepted().body(newTaskId);
    }

    @Operation(
            operationId = "task-controller-delete-task",
            summary = "Удаление информации об ответе ученика по задаче олимпиады",
            description = "Информация об информации предоставляется в виде записи с информацией об ответе"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат удаления информации ответа участника олимпиады"
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
    public ResponseEntity<Void> delete(UUID id) {
        taskUseCase.delete(id);

        return ResponseEntity.accepted().build();
    }

    @Operation(
            operationId = "task-controller-fetch-task",
            summary = "Получение информации об ответе ученика по id по задаче олимпиады",
            description = "Информация об информации предоставляется в виде записи с информацией об ответе"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат добавления информации ответа участника олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Информация не найдена"
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
    public ResponseEntity<ResultTaskDTO> fetchById(UUID id) {
        ResultTaskModel resultTaskModel = taskUseCase.fetchById(id);
        ResultTaskDTO resultTaskDTO = mapToResultDTO(resultTaskModel);

        return ResponseEntity.accepted().body(resultTaskDTO);
    }

    @Operation(
            operationId = "task-controller-update-task",
            summary = "Обновление информации об ответе ученика по id по задаче олимпиады",
            description = "Информация об информации предоставляется в виде записи с информацией об ответе",
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
                            description = "Результат обновления информации ответа участника олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Информация не найдена"
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
    public ResponseEntity<ResultTaskDTO> update(UUID id, IncomingTaskDTO taskDTO) {
        TaskModel taskModel = mapToModel(taskDTO);
        ResultTaskModel resultTaskModel = taskUseCase.update(id, taskModel);
        ResultTaskDTO resultTaskDTO = mapToResultDTO(resultTaskModel);

        return ResponseEntity.accepted().body(resultTaskDTO);
    }

    private TaskModel mapToModel(IncomingTaskDTO taskDTO) {
        UUID taskMetadataId = taskDTO.taskMetadataId();
        UUID studentId = taskDTO.studentId();
        UUID acceptorId = taskDTO.acceptorId();
        String status = taskDTO.status();
        Integer attempt = taskDTO.attempt();

        return new TaskModel(taskMetadataId, studentId, acceptorId, status, attempt);
    }

    private ResultTaskDTO mapToResultDTO(ResultTaskModel resultTaskModel) {
        UUID id = resultTaskModel.id();
        UUID taskMetadataId = resultTaskModel.taskMetadataId();
        UUID studentId = resultTaskModel.studentId();
        UUID acceptorId = resultTaskModel.acceptorId();
        String status = resultTaskModel.status();
        Integer attempt = resultTaskModel.attempt();
        LocalDateTime createdAt = resultTaskModel.createdAt();

        return new ResultTaskDTO(id, taskMetadataId, studentId, acceptorId, status, attempt, createdAt);
    }
}
