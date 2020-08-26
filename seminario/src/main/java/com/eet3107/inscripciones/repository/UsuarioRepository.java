package com.eet3107.inscripciones.repository;

import org.springframework.data.repository.CrudRepository;

import com.eet3107.inscripciones.entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Integer>{
	
	public Usuario findByUserNameAndPassword(String userName,String password);

}
