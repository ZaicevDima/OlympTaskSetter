package org.liman.olymp_task_setter.dto.result;

import java.util.UUID;

public sealed interface ResultPersonDTO permits ResultAdminDTO, ResultAcceptorDTO, ResultStudentDTO{
    UUID id();
    String name();
    String surname();
    String patronymic();
}
