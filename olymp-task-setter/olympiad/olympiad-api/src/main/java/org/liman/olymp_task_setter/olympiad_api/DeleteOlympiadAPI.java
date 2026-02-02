package org.liman.olymp_task_setter.olympiad_api;

import java.util.UUID;

@FunctionalInterface
public interface DeleteOlympiadAPI {
    void deleteOlympiad(UUID id);
}
