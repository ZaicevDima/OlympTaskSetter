package org.liman.olymp_task_setter.controller;

import org.liman.olymp_task_setter.olympiad_task_core_internal.OlympiadView;

import java.util.UUID;

@FunctionalInterface
public interface FetchOlympiadByIdAPI {
    OlympiadView fetchOlympiad(UUID id);
}
