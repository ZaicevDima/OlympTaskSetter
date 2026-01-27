package org.liman.olymp_task_setter.olympiad_task_core_internal;

import org.springframework.stereotype.Service;

@Service
public class OlympiadFactory {

    public Olympiad createOlympiad(OlympiadId id,
                                   OlympiadName name,
                                   Year year) {
        return new Olympiad(id, name, year);
    }
}
