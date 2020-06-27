package com.eet3107.inscripciones.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entity.TrayectoriaAcademica;

@Repository
public interface TrayectoriaAcademicaRepository extends CrudRepository<TrayectoriaAcademica,Date>{

}
