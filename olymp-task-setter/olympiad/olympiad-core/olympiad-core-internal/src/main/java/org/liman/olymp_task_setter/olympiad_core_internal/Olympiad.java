package org.liman.olymp_task_setter.olympiad_core_internal;

import org.liman.olymp_task_setter.olympiad_core_shared.OlympiadId;
import org.liman.olymp_task_setter.olympiad_core_shared.OlympiadName;
import org.liman.olymp_task_setter.olympiad_core_shared.OlympiadView;
import org.liman.olymp_task_setter.olympiad_core_shared.Year;

public class Olympiad {

    private final OlympiadId id;
    private final OlympiadName name;
    private final Year year;

    Olympiad(OlympiadId id,
             OlympiadName name,
             Year year) {
        this.id = id;
        this.name = name;
        this.year = year;
    }

    public OlympiadView view() {
        return new OlympiadView(id.value(), name.value(), year.value());
    }
}
