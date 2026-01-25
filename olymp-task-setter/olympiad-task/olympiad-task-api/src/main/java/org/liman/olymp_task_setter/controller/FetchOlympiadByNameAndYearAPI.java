package org.liman.olymp_task_setter.controller;

import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadView;

@FunctionalInterface
public interface FetchOlympiadByNameAndYearAPI {
    OlympiadView fetchOlympiad(String name, int year);
}
