package com.eet3107.inscripciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entity.PlanDeEstudios;

@Repository
public interface PlanDeEstudiosRepository extends CrudRepository<PlanDeEstudios,String> {

}
