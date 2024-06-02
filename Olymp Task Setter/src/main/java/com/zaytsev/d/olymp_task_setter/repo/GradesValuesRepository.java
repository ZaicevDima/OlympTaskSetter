package com.zaytsev.d.olymp_task_setter.repo;

import com.zaytsev.d.olymp_task_setter.models.Grades;
import com.zaytsev.d.olymp_task_setter.models.GradesValues;
import org.springframework.data.repository.CrudRepository;

public interface GradesValuesRepository extends CrudRepository<GradesValues, String > {
}
