package org.liman.olymp_task_setter.controller;

import java.util.UUID;

@FunctionalInterface
public interface DeleteOlympiadAPI {
    void deleteOlympiad(UUID id);
}
