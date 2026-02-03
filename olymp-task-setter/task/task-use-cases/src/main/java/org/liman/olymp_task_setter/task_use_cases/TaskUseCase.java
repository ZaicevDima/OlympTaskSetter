package org.liman.olymp_task_setter.task_use_cases;

import org.liman.olymp_task_setter.task_api.model.ResultTaskModel;
import org.liman.olymp_task_setter.task_api.model.TaskModel;
import org.liman.olymp_task_setter.task_api.task.AddTaskAPI;
import org.liman.olymp_task_setter.task_api.task.DeleteTaskAPI;
import org.liman.olymp_task_setter.task_api.task.FetchTaskByIdAPI;
import org.liman.olymp_task_setter.task_api.task.UpdateTaskAPI;
import org.liman.olymp_task_setter.task_repository.entities.TaskEntity;
import org.liman.olymp_task_setter.task_repository.repositories.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class TaskUseCase implements AddTaskAPI, DeleteTaskAPI, FetchTaskByIdAPI, UpdateTaskAPI {

    private final TaskRepository taskRepository;

    public TaskUseCase(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    @Transactional
    public UUID add(TaskModel task) {
        // TODO добавить проверку на существование в рамках задачи #55
        TaskEntity taskEntity = mapToEntity(task);
        taskRepository.save(taskEntity);

        return taskEntity.getId();
    }

    @Override
    public void delete(UUID id) {
        // TODO добавить проверку на существование в рамках задачи #55
        taskRepository.deleteById(id);
    }

    @Override
    public ResultTaskModel fetchById(UUID id) {
        // TODO добавить описание ошибки в рамках задачи #55
        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow();
        return mapToModel(taskEntity);
    }

    @Override
    public ResultTaskModel update(UUID id, TaskModel task) {
        UUID taskMetadataId = task.taskMetadataId();
        UUID studentId = task.studentId();
        UUID acceptorId = task.acceptorId();
        String status = task.status();
        Integer attempt = task.attempt();

        TaskEntity taskEntity = taskRepository.findById(id)
                .orElseThrow();

        taskEntity.setTaskInformationId(taskMetadataId);
        taskEntity.setStudentId(studentId);
        taskEntity.setAcceptorId(acceptorId);
        taskEntity.setStatus(status);
        taskEntity.setAttempt(attempt);

        taskRepository.save(taskEntity);

        return mapToModel(taskEntity);
    }

    private TaskEntity mapToEntity(TaskModel task) {
        UUID taskMetadataId = task.taskMetadataId();
        UUID studentId = task.studentId();
        UUID acceptorId = task.acceptorId();
        String status = task.status();
        Integer attempt = task.attempt();

        TaskEntity taskEntity = new TaskEntity();
        taskEntity.setTaskInformationId(taskMetadataId);
        taskEntity.setStudentId(studentId);
        taskEntity.setAcceptorId(acceptorId);
        taskEntity.setStatus(status);
        taskEntity.setAttempt(attempt);

        return taskEntity;
    }

    private ResultTaskModel mapToModel(TaskEntity taskEntity) {
        UUID id = taskEntity.getId();
        UUID taskMetadataId = taskEntity.getTaskInformationId();
        UUID studentId = taskEntity.getStudentId();
        UUID acceptorId = taskEntity.getAcceptorId();
        String status = taskEntity.getStatus();
        Integer attempt = taskEntity.getAttempt();
        LocalDateTime createdAt = taskEntity.getCreatedAt();

        return new ResultTaskModel(id, taskMetadataId, studentId, acceptorId, status, attempt, createdAt);
    }
}
