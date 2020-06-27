package com.eet3107.inscripciones.repositorios;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eet3107.inscripciones.entidades.Alumno;
import com.eet3107.inscripciones.entidades.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario,Integer>{

	public Usuario findByUserName(String userName);
	public Usuario findById(int id);
}
