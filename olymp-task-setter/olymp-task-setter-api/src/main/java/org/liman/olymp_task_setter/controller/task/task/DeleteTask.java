package org.liman.olymp_task_setter.controller.task.task;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Tag(name = "3. API для работы с задачами олимпиды", description = "Раздел содержит api для работы с задачами олимпиды")
@FunctionalInterface
public interface DeleteTask {

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);
}
