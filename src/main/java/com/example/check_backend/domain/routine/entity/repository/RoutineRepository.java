package com.example.check_backend.domain.routine.entity.repository;

import com.example.check_backend.domain.routine.entity.Routine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineRepository extends CrudRepository<Routine, Long> {

}
