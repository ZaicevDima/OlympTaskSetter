package org.liman.olymp_task_setter.olympiad_use_cases;

import org.liman.olymp_task_setter.olympiad_api.CreateTasksByClassAPI;
import org.liman.olymp_task_setter.olympiad_repository.repositories.OlympiadRepository;
import org.liman.olymp_task_setter.task_api.model.TaskMetadataModel;
import org.liman.olymp_task_setter.task_api.task_metadata.AddAllTasksMetadataAPI;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.IntStream;

@Service
public class CreateTasksByClassUseCase implements CreateTasksByClassAPI {

    private final AddAllTasksMetadataAPI addAllTasksMetadataAPI;
    private final OlympiadRepository olympiadRepository;

    public CreateTasksByClassUseCase(AddAllTasksMetadataAPI addAllTasksMetadataAPI,
                                     OlympiadRepository olympiadRepository) {
        this.addAllTasksMetadataAPI = addAllTasksMetadataAPI;
        this.olympiadRepository = olympiadRepository;
    }

    @Override
    @Transactional
    public void CreateTasksByClass(UUID olympiadId, Map<Integer, Integer> tasksByClass) {
        if (!olympiadRepository.existsById(olympiadId)) {
            throw new IllegalArgumentException("Olympiad with id %s not exist".formatted(olympiadId));
        }

        List<TaskMetadataModel> taskMetadataModels = tasksByClass.entrySet()
                .stream()
                .flatMap(entry ->
                        IntStream.rangeClosed(1, entry.getValue())
                                .mapToObj(taskNumber -> new TaskMetadataModel(olympiadId, taskNumber, entry.getKey()))
                )
                .toList();

        addAllTasksMetadataAPI.addAll(taskMetadataModels);
    }
}
