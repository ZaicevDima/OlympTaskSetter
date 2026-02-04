package org.liman.olymp_task_setter.task_use_cases;

import org.liman.olymp_task_setter.task_api.model.ResultTaskMetadataModel;
import org.liman.olymp_task_setter.task_api.model.TaskMetadataModel;
import org.liman.olymp_task_setter.task_api.task_metadata.*;
import org.liman.olymp_task_setter.task_repository.entities.TaskMetadataEntity;
import org.liman.olymp_task_setter.task_repository.repositories.TaskMetadataRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Service
public class TaskMetadataUseCase implements
        AddTaskMetadataAPI,
        AddAllTasksMetadataAPI,
        DeleteTaskMetadataAPI,
        FetchTaskMetadataByIdAPI,
        UpdateTaskMetadataAPI {

    private final TaskMetadataRepository taskMetadataRepository;

    public TaskMetadataUseCase(TaskMetadataRepository taskMetadataRepository) {
        this.taskMetadataRepository = taskMetadataRepository;
    }

    @Override
    @Transactional
    public UUID add(TaskMetadataModel taskMetadata) {
        // TODO добавить проверку на существование в рамках задачи #55
        TaskMetadataEntity taskMetadataEntity = mapToEntity(taskMetadata);
        taskMetadataRepository.save(taskMetadataEntity);

        return taskMetadataEntity.getId();
    }

    @Override
    public void addAll(Collection<TaskMetadataModel> tasksMetadata) {
        // TODO добавить проверку на существование в рамках задачи #55
        List<TaskMetadataEntity> taskMetadataEntities = tasksMetadata.stream()
                .map(this::mapToEntity)
                .toList();
        taskMetadataRepository.saveAll(taskMetadataEntities);
    }

    @Override
    public void delete(UUID id) {
        // TODO добавить проверку на существование в рамках задачи #55
        taskMetadataRepository.deleteById(id);
    }

    @Override
    public ResultTaskMetadataModel fetchById(UUID id) {
        // TODO добавить описание ошибки в рамках задачи #55
        TaskMetadataEntity taskMetadataEntity = taskMetadataRepository.findById(id)
                .orElseThrow();
        return mapToModel(taskMetadataEntity);
    }

    @Override
    public ResultTaskMetadataModel update(UUID id, TaskMetadataModel taskMetadata) {
        int taskNumber = taskMetadata.taskNumber();
        int classNumber = taskMetadata.classNumber();

        TaskMetadataEntity taskMetadataEntity = taskMetadataRepository.findById(id)
                .orElseThrow();

        taskMetadataEntity.setTaskNumber(taskNumber);
        taskMetadataEntity.setClassNumber(classNumber);

        taskMetadataRepository.save(taskMetadataEntity);

        return mapToModel(taskMetadataEntity);
    }

    private TaskMetadataEntity mapToEntity(TaskMetadataModel taskMetadata) {
        UUID olympiadId = taskMetadata.olympiadId();
        int taskNumber = taskMetadata.taskNumber();
        int classNumber = taskMetadata.classNumber();

        TaskMetadataEntity taskMetadataEntity = new TaskMetadataEntity();
        taskMetadataEntity.setOlympiadId(olympiadId);
        taskMetadataEntity.setTaskNumber(taskNumber);
        taskMetadataEntity.setClassNumber(classNumber);

        return taskMetadataEntity;
    }

    private ResultTaskMetadataModel mapToModel(TaskMetadataEntity taskMetadataEntity) {
        UUID id = taskMetadataEntity.getId();
        UUID olympiadId = taskMetadataEntity.getOlympiadId();
        int taskNumber = taskMetadataEntity.getTaskNumber();
        int classNumber = taskMetadataEntity.getClassNumber();
        LocalDateTime createdAt = taskMetadataEntity.getCreatedAt();

        return new ResultTaskMetadataModel(id, olympiadId, taskNumber, classNumber, createdAt);
    }
}
