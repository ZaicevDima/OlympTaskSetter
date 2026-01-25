package org.liman.olymp_task_setter.olympiad_task_core_shared;

import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadId;
import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadName;
import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadView;
import org.liman.olymp_task_setter.olympiad_task_core_internal.Year;

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
