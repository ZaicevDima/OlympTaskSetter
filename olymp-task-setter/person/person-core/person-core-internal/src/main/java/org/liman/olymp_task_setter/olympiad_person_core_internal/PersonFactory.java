package org.liman.olymp_task_setter.olympiad_person_core_internal;

import jakarta.persistence.EntityNotFoundException;
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

import java.util.Optional;
import java.util.UUID;

@Service
public class PersonFactory {

    private final AdminRepository adminRepository;
    private final AcceptorsRepository acceptorsRepository;
    private final StudentRepository studentRepository;

    public PersonFactory(AdminRepository adminRepository,
                         AcceptorsRepository acceptorsRepository,
                         StudentRepository studentRepository) {
        this.adminRepository = adminRepository;
        this.acceptorsRepository = acceptorsRepository;
        this.studentRepository = studentRepository;
    }

    public Person newInstance(PersonView personView) {
        return switch (personView) {
            case AdminView adminView -> new Admin(adminView.name(), adminView.surname(), adminView.patronymic());
            case AcceptorView acceptorView -> new Acceptor(acceptorView.name(), acceptorView.surname(), acceptorView.patronymic());
            case StudentView studentView -> {
                String name = studentView.name();
                String surname = studentView.surname();
                String patronymic = studentView.patronymic();
                String school = studentView.school();
                int classNumber = studentView.classNumber();

                yield new Student(name, surname, patronymic, school, classNumber);
            }
        };
    }

    public Person existInstance(UUID id) {
        BasePerson personEntity = getPersonEntity(id);
        String name = personEntity.getName();
        String surname = personEntity.getSurname();
        String patronymic = personEntity.getPatronymic();

        return switch (personEntity) {
            case AdminEntity ignored -> new Admin(name, surname, patronymic);
            case AcceptorsEntity ignored -> new Acceptor(name, surname, patronymic);
            case StudentsEntity studentsEntity -> {
                String school = studentsEntity.getSchool();
                int classNumber = studentsEntity.getClassNumber();

                yield new Student(name, surname, patronymic, school, classNumber);
            }
            default -> throw new IllegalStateException("Unexpected value: " + personEntity);
        };
    }

    public Person existInstance(String name, String surname, String patronymic) {
        BasePerson personEntity = getPersonEntity(name, surname, patronymic);

        return switch (personEntity) {
            case AdminEntity ignored -> new Admin(name, surname, patronymic);
            case AcceptorsEntity ignored -> new Acceptor(name, surname, patronymic);
            case StudentsEntity studentsEntity -> {
                String school = studentsEntity.getSchool();
                int classNumber = studentsEntity.getClassNumber();

                yield new Student(name, surname, patronymic, school, classNumber);
            }
            default -> throw new IllegalStateException("Unexpected value: " + personEntity);
        };
    }

    private BasePerson getPersonEntity(UUID id) {
        Optional<? extends BasePerson> person = adminRepository.findById(id)
                .map(p -> (BasePerson) p)
                .or(() -> acceptorsRepository.findById(id).map(p -> (BasePerson) p))
                .or(() -> studentRepository.findById(id).map(p -> (BasePerson) p));

        return person.orElseThrow(() ->
                new EntityNotFoundException("Person not found with id: " + id));
    }

    private BasePerson getPersonEntity(String name, String surname, String patronymic) {
        Optional<? extends BasePerson> person = adminRepository.findFirstByNameAndSurnameAndPatronymic(name, surname, patronymic).map(p -> (BasePerson) p)
                .or(() -> acceptorsRepository.findFirstByNameAndSurnameAndPatronymic(name, surname, patronymic).map(p -> (BasePerson) p))
                .or(() -> studentRepository.findFirstByNameAndSurnameAndPatronymic(name, surname, patronymic).map(p -> (BasePerson) p));

        return person.orElseThrow(() ->
                new EntityNotFoundException("Person not found with name: %s, surname: %s, patronymic: %s".formatted(name, surname, patronymic)));
    }

    private enum Role {
        ADMIN, ACCEPTOR, STUDENT
    }
}
