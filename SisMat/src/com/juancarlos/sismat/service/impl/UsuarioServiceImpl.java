package com.juancarlos.sismat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.UsuarioDao;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Usuario;
import com.juancarlos.sismat.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	public boolean iniciaSession(String nombreUsuario, String clave) {
		
		return  usuarioDao.iniciaSession(nombreUsuario, clave);
		
	}
	
	public Empleado datosUsuario(String nombreUsuario, String clave) {
		
		return usuarioDao.datosUsuario(nombreUsuario, clave);
	}
	
	public boolean registroUsuario(String nombreUsuario,String clave,String tipo){
		Usuario usuario = new Usuario();
		
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setClave(clave);
		usuario.setTipo(tipo);

		return usuarioDao.registroUsuario(usuario);
	}

}
