package org.liman.olymp_task_setter.olympiad_task_api;

import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadView;

@FunctionalInterface
public interface SaveOlympiadAPI {
    void saveNewOlympiad(OlympiadView olympiadView);
}
