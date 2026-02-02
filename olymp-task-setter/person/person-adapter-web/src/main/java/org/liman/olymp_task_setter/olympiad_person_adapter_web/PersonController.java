package org.liman.olymp_task_setter.olympiad_person_adapter_web;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.liman.olymp_task_setter.controller.person.*;
import org.liman.olymp_task_setter.dto.internal.IncomingPersonDTO;
import org.liman.olymp_task_setter.dto.result.ResultAcceptorDTO;
import org.liman.olymp_task_setter.dto.result.ResultAdminDTO;
import org.liman.olymp_task_setter.dto.result.ResultPersonDTO;
import org.liman.olymp_task_setter.dto.result.ResultStudentDTO;
import org.liman.olymp_task_setter.olympiad_person_core_shared.AcceptorView;
import org.liman.olymp_task_setter.olympiad_person_core_shared.AdminView;
import org.liman.olymp_task_setter.olympiad_person_core_shared.PersonView;
import org.liman.olymp_task_setter.olympiad_person_core_shared.StudentView;
import org.liman.olymp_task_setter.olympiad_person_repository.entities.AcceptorsEntity;
import org.liman.olymp_task_setter.olympiad_person_repository.entities.AdminEntity;
import org.liman.olymp_task_setter.olympiad_person_repository.entities.BasePerson;
import org.liman.olymp_task_setter.olympiad_person_repository.entities.StudentsEntity;
import org.liman.olymp_task_setter.olympiad_person_use_cases.UpsertPersonUseCase;
import org.liman.olymp_task_setter.swagger.OpenAPIExample;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/v1/persons")
public class PersonController implements
        AddNewPerson,
        DeletePerson,
        FetchPersonById,
        FetchPersonByUsername,
        UpdatePerson {

    private final UpsertPersonUseCase upsertPersonUseCase;

    public PersonController(UpsertPersonUseCase upsertPersonUseCase) {
        this.upsertPersonUseCase = upsertPersonUseCase;
    }

    @Operation(
            operationId = "person-controller-add-new-person",
            summary = "Добавление нового участника олимпиады",
            description = "Информация об участнике предоставляется в виде записи с информацией об участнике",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "1. Валидный запрос на добавление администратора",
                                                    description = "Пример добавления администратора с валидными данными",
                                                    value = OpenAPIExample.REGISTRATION_ADMIN
                                            ),
                                            @ExampleObject(
                                                    name = "2. Валидный запрос на добавление принимающего",
                                                    description = "Пример добавления принимающего с валидными данными",
                                                    value = OpenAPIExample.REGISTRATION_ACCEPTOR
                                            ),
                                            @ExampleObject(
                                                    name = "3. Валидный запрос на добавление ученика",
                                                    description = "Пример добавления ученика с валидными данными",
                                                    value = OpenAPIExample.REGISTRATION_STUDENT
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
                            description = "Результат добавления участника олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при добавлении участника олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<UUID> add(@RequestBody IncomingPersonDTO personDTO) {
        PersonView personView = mapToPersonView(personDTO);
        UUID personId = upsertPersonUseCase.addPerson(personView);

        return ResponseEntity.accepted().body(personId);
    }

    @Operation(
            operationId = "person-controller-update-person",
            summary = "Обновление участника олимпиады",
            description = "Информация об участнике олимпиады предоставляется в виде записи с информацией об участнике",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = {
                            @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    examples = {
                                            @ExampleObject(
                                                    name = "1. Валидный запрос на обновление администратора",
                                                    description = "Пример обновления администратора с валидными данными",
                                                    value = OpenAPIExample.REGISTRATION_ADMIN
                                            ),
                                            @ExampleObject(
                                                    name = "2. Валидный запрос на обновление принимающего",
                                                    description = "Пример обновления принимающего с валидными данными",
                                                    value = OpenAPIExample.REGISTRATION_ACCEPTOR
                                            ),
                                            @ExampleObject(
                                                    name = "3. Валидный запрос на обновление ученика",
                                                    description = "Пример обновления ученика с валидными данными",
                                                    value = OpenAPIExample.REGISTRATION_STUDENT
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
                            description = "Результат обновления участника олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Участник не зарегистрирован"
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
    public ResponseEntity<ResultPersonDTO> update(UUID id, IncomingPersonDTO personDTO) {
        PersonView personView = mapToPersonView(personDTO);
        BasePerson person = upsertPersonUseCase.updatePerson(id, personView);
        ResultPersonDTO resultPersonDTO = mapToResultPersonDTO(person);

        return ResponseEntity.accepted().body(resultPersonDTO);
    }

    @Operation(
            operationId = "person-controller-delete-person",
            summary = "Удаление участника олимпиады",
            description = "Информация об участнике олимпиаде предоставляется в виде идентификатора участника олимпиады"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат обновления участника олимпиады"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Участник олимпиада не зарегистрирован"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при удалении участника олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<Void> delete(UUID id) {
        upsertPersonUseCase.deletePerson(id);

        return ResponseEntity.accepted().build();
    }

    @Operation(
            operationId = "person-controller-fetch-person-by-username",
            summary = "Получение информации об участнике олимпиады по имени, фамилии и отчеству",
            description = "Информация об участнике олимпиады предоставляется в виде записи с информацией об участнике олимпиады"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат получения участника олимпиады по имени, фамилии и отчеству"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Участник олимпиады не найдена"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Серверная ошибка при получении участника олимпиады",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE
                            )
                    )
            }
    )
    @Override
    public ResponseEntity<ResultPersonDTO> fetchByUsername(String name, String surname, String patronymic) {
        BasePerson person = upsertPersonUseCase.fetchByUsername(name, surname, patronymic);
        ResultPersonDTO resultPersonDTO = mapToResultPersonDTO(person);

        return ResponseEntity.accepted().body(resultPersonDTO);
    }


    @Operation(
            operationId = "person-controller-fetch-person-by-id",
            summary = "Получение информации об участнике олимпиаде по идентификатору участника олимпиады",
            description = "Информация об участнике олимпиаде предоставляется в виде записи с информацией об участнике олимпиады"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Результат получения участника олимпиады по идентификатору"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Некорректная структура запроса"
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Участник олимпиады не найдена"
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
    public ResponseEntity<ResultPersonDTO> fetchById(UUID id) {
        BasePerson person = upsertPersonUseCase.fetchById(id);
        ResultPersonDTO resultPersonDTO = mapToResultPersonDTO(person);

        return ResponseEntity.accepted().body(resultPersonDTO);
    }

    private PersonView mapToPersonView(IncomingPersonDTO personDTO) {
        String name = personDTO.name();
        String surname = personDTO.surname();
        String patronymic = personDTO.patronymic();

        // TODO Переделать на автоматическое создание в рамках задачи #41
        return switch (personDTO.role()) {
            case "student" -> new StudentView(name, surname, patronymic, personDTO.school(), personDTO.classNumber());
            case "admin" -> new AdminView(name, surname, patronymic);
            case "acceptor" -> new AcceptorView(name, surname, patronymic);
            default -> throw new IllegalArgumentException("Invalid role name");
        };
    }

    private ResultPersonDTO mapToResultPersonDTO(BasePerson person) {
        UUID id = person.getId();
        String name = person.getName();
        String surname = person.getSurname();
        String patronymic = person.getPatronymic();

        return switch (person) {
            case AdminEntity ignore -> new ResultAdminDTO(id, name, surname, patronymic);
            case AcceptorsEntity ignore -> new ResultAcceptorDTO(id, name, surname, patronymic);
            case StudentsEntity studentsEntity -> new ResultStudentDTO(id, name, surname, patronymic, studentsEntity.getSchool(), studentsEntity.getClassNumber());
            default -> throw new IllegalStateException("Unexpected value: " + person);
        };
    }
}