package com.eet3107.inscripciones.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entidades.Legajo;

@Repository
public interface LegajoRepository extends CrudRepository<Legajo,Integer>{

}
