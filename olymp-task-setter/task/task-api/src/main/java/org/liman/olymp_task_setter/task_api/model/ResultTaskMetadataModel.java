package org.liman.olymp_task_setter.task_api.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record ResultTaskMetadataModel(UUID id,
                                      UUID olympiadId,
                                      int taskNumber,
                                      int classNumber,
                                      LocalDateTime createdAt) {
}
