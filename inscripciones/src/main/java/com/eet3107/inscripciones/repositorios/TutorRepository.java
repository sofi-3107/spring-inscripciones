package com.eet3107.inscripciones.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entidades.Tutor;

@Repository
public interface TutorRepository extends CrudRepository<Tutor,Integer> {

}
