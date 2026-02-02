package org.liman.olymp_task_setter.olympiad_api;

import org.liman.olymp_task_setter.olympiad_core_shared.OlympiadView;

@FunctionalInterface
public interface UpdateOlympiadAPI {
    void updateOlympiad(OlympiadView olympiadView);
}
