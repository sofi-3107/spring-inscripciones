package com.eet3107.inscripciones.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eet3107.inscripciones.entidades.Usuario;
import com.eet3107.inscripciones.repositorios.UsuarioRepository;
import com.eet3107.inscripciones.services.interfaces.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository rep;

	@Override
	public Usuario crearUsuario(Usuario user) throws Exception {
		return rep.save(user);
	}


	@Override
	public List<Usuario> getUsuarios()  {
		return (List<Usuario>) rep.findAll();
	}

	@Override
	public Usuario findUsuarioByuserName(String userName) throws Exception {
				return rep.findByUserName(userName);
	}

	@Override
	public Usuario findUsuarioById(int id) {
		return rep.findById(id);
	}


}
