package org.liman.olymp_task_setter.olympiad_api;

import org.liman.olymp_task_setter.olympiad_core_shared.OlympiadView;

import java.util.UUID;

@FunctionalInterface
public interface FetchOlympiadByIdAPI {
    OlympiadView fetchOlympiad(UUID id);
}
