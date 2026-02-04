package org.liman.olymp_task_setter.olympiad_api;

import java.util.Map;
import java.util.UUID;

@FunctionalInterface
public interface CreateTasksByClassAPI {
    void CreateTasksByClass(UUID olympiadId, Map<Integer, Integer> tasksByClass);
}
