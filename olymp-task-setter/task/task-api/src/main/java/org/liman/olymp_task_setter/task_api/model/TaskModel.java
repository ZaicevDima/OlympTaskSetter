package org.liman.olymp_task_setter.task_api.model;

import java.util.UUID;

public record TaskModel(UUID taskMetadataId,
                        UUID studentId,
                        UUID acceptorId,
                        String status,
                        Integer attempt) {
}
