package com.zaytsev.d.olymp_task_setter.repo;

import com.zaytsev.d.olymp_task_setter.models.Students;
import org.springframework.data.repository.CrudRepository;

public interface StudentsRepository extends CrudRepository<Students, Long> {
}
