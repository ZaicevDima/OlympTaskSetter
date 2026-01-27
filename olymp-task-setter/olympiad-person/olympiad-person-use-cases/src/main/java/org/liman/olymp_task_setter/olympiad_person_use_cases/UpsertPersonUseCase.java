package org.liman.olymp_task_setter.olympiad_person_use_cases;

import org.liman.olymp_task_setter.olympiad_person_api.*;
import org.liman.olymp_task_setter.olympiad_person_core_internal.*;
import org.liman.olymp_task_setter.olympiad_person_core_shared.AcceptorView;
import org.liman.olymp_task_setter.olympiad_person_core_shared.AdminView;
import org.liman.olymp_task_setter.olympiad_person_core_shared.PersonView;
import org.liman.olymp_task_setter.olympiad_person_core_shared.StudentView;
import org.liman.olymp_task_setter.olympiad_person_repository.entities.AcceptorsEntity;
import org.liman.olymp_task_setter.olympiad_person_repository.entities.AdminEntity;
import org.liman.olymp_task_setter.olympiad_person_repository.entities.BasePerson;
import org.liman.olymp_task_setter.olympiad_person_repository.entities.StudentsEntity;
import org.liman.olymp_task_setter.olympiad_person_repository.repositories.AcceptorsRepository;
import org.liman.olymp_task_setter.olympiad_person_repository.repositories.AdminRepository;
import org.liman.olymp_task_setter.olympiad_person_repository.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpsertPersonUseCase implements
        DeletePersonAPI, FetchPersonByIdAPI, FetchPersonByUsernameAPI, SavePersonAPI, UpdatePersonAPI {

    private final StudentRepository studentRepository;
    private final AdminRepository adminRepository;
    private final AcceptorsRepository acceptorsRepository;
    private final PersonFactory personFactory;

    public UpsertPersonUseCase(StudentRepository studentRepository,
                               AdminRepository adminRepository,
                               AcceptorsRepository acceptorsRepository,
                               PersonFactory personFactory) {
        this.studentRepository = studentRepository;
        this.adminRepository = adminRepository;
        this.acceptorsRepository = acceptorsRepository;
        this.personFactory = personFactory;
    }

    public UUID addPerson(PersonView personView) {
        // TODO переделать на стратегию в рамках задачи #42
        BasePerson personEntity = getBasePerson(personView);

        personEntity = switch (personEntity) {
            case AdminEntity adminEntity -> adminRepository.save(adminEntity);
            case AcceptorsEntity acceptorsEntity -> acceptorsRepository.save(acceptorsEntity);
            case StudentsEntity studentsEntity -> studentRepository.save(studentsEntity);
            // TODO Убрать default
            default -> throw new RuntimeException();
        };

        return personEntity.getId();
    }

    public BasePerson updatePerson(UUID id, PersonView upadteblePersonView) {
        BasePerson personEntity = getBasePerson(upadteblePersonView);

        return switch (personEntity) {
            case AdminEntity adminEntity -> adminRepository.save(adminEntity);
            case AcceptorsEntity acceptorsEntity -> acceptorsRepository.save(acceptorsEntity);
            case StudentsEntity studentsEntity -> studentRepository.save(studentsEntity);
            default -> throw new IllegalStateException("Unexpected value: " + personEntity);
        };
    }

    public void deletePerson(UUID id) {
        Person person = personFactory.existInstance(id);

        switch (person) {
            case Admin ignored -> adminRepository.deleteById(id);
            case Acceptor ignored -> acceptorsRepository.deleteById(id);
            case Student ignored -> studentRepository.deleteById(id);
        }
    }

    public BasePerson fetchById(UUID id) {
        Person person = personFactory.existInstance(id);

        return switch (person) {
            case Admin ignored -> adminRepository.getReferenceById(id);
            case Acceptor ignored -> acceptorsRepository.getReferenceById(id);
            case Student ignored -> studentRepository.getReferenceById(id);
        };
    }


    public BasePerson fetchByUsername(String name, String surname, String patronymic) {
        Person person = personFactory.existInstance(name, surname, patronymic);

        return switch (person) {
            case Admin ignored -> adminRepository.findFirstByNameAndSurnameAndPatronymic(name, surname, patronymic).get();
            case Acceptor ignored -> acceptorsRepository.findFirstByNameAndSurnameAndPatronymic(name, surname, patronymic).get();
            case Student ignored -> studentRepository.findFirstByNameAndSurnameAndPatronymic(name, surname, patronymic).get();
        };
    }

    private static BasePerson getBasePerson(PersonView personView) {
        String name = personView.name();
        String surname = personView.surname();
        String patronymic = personView.patronymic();


        return switch (personView) {
            case AdminView ignored -> {
                AdminEntity entity = new AdminEntity();
                entity.setName(name);
                entity.setSurname(surname);
                entity.setPatronymic(patronymic);

                yield entity;
            }
            case AcceptorView ignored -> {
                AcceptorsEntity entity = new AcceptorsEntity();
                entity.setName(name);
                entity.setSurname(surname);
                entity.setPatronymic(patronymic);

                yield entity;
            }
            case StudentView studentView -> {
                StudentsEntity entity = new StudentsEntity();
                entity.setName(name);
                entity.setSurname(surname);
                entity.setPatronymic(patronymic);
                entity.setSchool(studentView.school());
                entity.setClassNumber(studentView.classNumber());

                yield entity;
            }
        };
    }
}
