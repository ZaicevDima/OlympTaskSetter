package org.liman.olymp_task_setter.olympiad_use_cases;

import org.liman.olymp_task_setter.olympiad_api.*;
import org.liman.olymp_task_setter.olympiad_api.*;
import org.liman.olymp_task_setter.olympiad_core_shared.OlympiadView;
import org.liman.olymp_task_setter.olympiad_repository.entities.olympiads.OlympiadEntity;
import org.liman.olymp_task_setter.olympiad_repository.repositories.OlympiadRepository;
import org.liman.olymp_task_setter.olympiad_use_cases.exceptions.EntityAlreadyExistsException;
import org.liman.olymp_task_setter.olympiad_use_cases.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpsertOlympiadUseCase implements
        SaveOlympiadAPI,
        UpdateOlympiadAPI,
        DeleteOlympiadAPI,
        FetchOlympiadByNameAndYearAPI,
        FetchOlympiadByIdAPI {

    private final OlympiadRepository olympiadRepository;

    public UpsertOlympiadUseCase(OlympiadRepository olympiadRepository) {
        this.olympiadRepository = olympiadRepository;
    }


    @Override
    public void saveNewOlympiad(OlympiadView olympiadView) {
        OlympiadEntity olympiadEntity = mapToOlympiadEntity(olympiadView);
        UUID id = olympiadView.id();

        if (olympiadRepository.existsById(id)) {
            throw new EntityAlreadyExistsException("Olympiad with id: %s already exists".formatted(id));
        }
        olympiadRepository.save(olympiadEntity);
    }

    @Override
    public void updateOlympiad(OlympiadView olympiadView) {
        UUID id = olympiadView.id();
        OlympiadEntity olympiad = olympiadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Olympiad with id: %s not exists".formatted(id)));
        olympiad.setName(olympiadView.name());
        olympiad.setYear(olympiadView.year());

        olympiadRepository.save(olympiad);
    }

    @Override
    public void deleteOlympiad(UUID id) {
        olympiadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Olympiad with id: %s not exists".formatted(id)));

        olympiadRepository.deleteById(id);
    }

    @Override
    public OlympiadView fetchOlympiad(String name, int year) {
        OlympiadEntity olympiadEntity = olympiadRepository.findByNameAndYear(name, year)
                .orElseThrow(() -> {
                    String errorMessage = "Olympiad with name: %s and year: %s not exists".formatted(name, year);
                    return new EntityNotFoundException(errorMessage);
                });

        return mapToOlympiadView(olympiadEntity);
    }

    @Override
    public OlympiadView fetchOlympiad(UUID id) {
        OlympiadEntity olympiadEntity = olympiadRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Olympiad with id: %s not exists".formatted(id)));

        return mapToOlympiadView(olympiadEntity);
    }

    private OlympiadEntity mapToOlympiadEntity(OlympiadView olympiadView) {
        OlympiadEntity olympiad = new OlympiadEntity();
        olympiad.setId(olympiadView.id());
        olympiad.setName(olympiadView.name());
        olympiad.setYear(olympiadView.year());

        return olympiad;
    }

    private OlympiadView mapToOlympiadView(OlympiadEntity olympiad) {
        return new OlympiadView(
                olympiad.getId(),
                olympiad.getName(),
                olympiad.getYear()
        );
    }
}
