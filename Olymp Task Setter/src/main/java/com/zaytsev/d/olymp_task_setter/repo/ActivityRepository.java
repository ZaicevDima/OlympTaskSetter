package com.zaytsev.d.olymp_task_setter.repo;

import com.zaytsev.d.olymp_task_setter.models.Activity;
import com.zaytsev.d.olymp_task_setter.models.Grades;
import org.springframework.data.repository.CrudRepository;

public interface ActivityRepository extends CrudRepository<Activity, Long> {
}
