package org.liman.olymp_task_setter.task_api.task_metadata;

import java.util.UUID;

@FunctionalInterface
public interface DeleteTaskMetadataAPI {

    void delete(UUID id);
}
