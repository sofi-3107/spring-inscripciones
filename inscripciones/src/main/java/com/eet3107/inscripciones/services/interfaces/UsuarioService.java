package com.eet3107.inscripciones.services.interfaces;

import java.util.List;

import com.eet3107.inscripciones.entidades.Usuario;

public interface UsuarioService {

	public Usuario crearUsuario(Usuario user) throws Exception;
	
	public Usuario findUsuarioByuserName(String userName)throws Exception;
	
	public List<Usuario> getUsuarios() throws Exception;
	
	public Usuario findUsuarioById(int id);
}
