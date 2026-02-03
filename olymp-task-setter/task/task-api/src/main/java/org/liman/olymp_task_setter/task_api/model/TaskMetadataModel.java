package org.liman.olymp_task_setter.task_api.model;

import java.util.UUID;

public record TaskMetadataModel(UUID olympiadId,
                                int taskNumber,
                                int classNumber) {
}
