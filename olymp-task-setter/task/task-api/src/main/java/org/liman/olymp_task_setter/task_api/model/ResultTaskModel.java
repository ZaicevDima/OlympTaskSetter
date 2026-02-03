package org.liman.olymp_task_setter.task_api.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResultTaskModel(UUID id,
                              UUID taskMetadataId,
                              UUID studentId,
                              UUID acceptorId,
                              String status,
                              Integer attempt,
                              LocalDateTime createdAt) {
}
