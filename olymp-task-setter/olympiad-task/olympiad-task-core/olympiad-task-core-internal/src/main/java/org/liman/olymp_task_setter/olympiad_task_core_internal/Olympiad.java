package org.liman.olymp_task_setter.olympiad_task_core_internal;

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
