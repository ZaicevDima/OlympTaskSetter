package org.liman.olymp_task_setter.olympiad_task_use_cases;

import org.liman.olymp_task_setter.controller.SaveOlympiadAPI;
import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadTask;
import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadView;
import org.liman.olymp_task_setter.olympiad_task_core_internal.TaskStatus;
import org.liman.olymp_task_setter.olympiad_task_repository.entities.olympiads.OlympiadEntity;
import org.liman.olymp_task_setter.olympiad_task_repository.repositories.OlympiadRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Service
public class UpsertOlympiadUseCase implements SaveOlympiadAPI {

    private final OlympiadRepository olympiadRepository;

    public UpsertOlympiadUseCase(OlympiadRepository olympiadRepository) {
        this.olympiadRepository = olympiadRepository;
    }


    @Override
    public void saveNewOlympiad(OlympiadView olympiadView, int tasksNumber) {
        UUID id = UUID.randomUUID();
        List<OlympiadTask> olympiadTasks = Collections.nCopies(tasksNumber, new OlympiadTask(TaskStatus.NO_STATUS));

        OlympiadEntity olympiadEntity = getOlympiadEntity(id, olympiadView, olympiadTasks);

        olympiadRepository.save(olympiadEntity);
    }

    private OlympiadEntity getOlympiadEntity(UUID id, OlympiadView olympiadView, List<OlympiadTask> olympiadTasks) {
        OlympiadEntity olympiad = new OlympiadEntity();
        olympiad.setId(id);
        olympiad.setName(olympiadView.name());
        olympiad.setYear(olympiadView.year());

        return olympiad;
    }
}
