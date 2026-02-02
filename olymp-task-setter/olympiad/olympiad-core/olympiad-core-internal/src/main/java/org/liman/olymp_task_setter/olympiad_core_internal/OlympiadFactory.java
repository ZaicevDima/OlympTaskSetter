package org.liman.olymp_task_setter.olympiad_core_internal;

import org.liman.olymp_task_setter.olympiad_core_shared.OlympiadId;
import org.liman.olymp_task_setter.olympiad_core_shared.OlympiadName;
import org.liman.olymp_task_setter.olympiad_core_shared.Year;
import org.springframework.stereotype.Service;

@Service
public class OlympiadFactory {

    public Olympiad createOlympiad(OlympiadId id,
                                   OlympiadName name,
                                   Year year) {
        return new Olympiad(id, name, year);
    }
}
