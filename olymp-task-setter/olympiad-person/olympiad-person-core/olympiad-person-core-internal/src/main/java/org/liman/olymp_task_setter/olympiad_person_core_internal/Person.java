package org.liman.olymp_task_setter.olympiad_person_core_internal;

import org.liman.olymp_task_setter.olympiad_person_core_shared.PersonView;

public sealed interface Person permits Admin, Acceptor, Student {
    PersonView view();
}
