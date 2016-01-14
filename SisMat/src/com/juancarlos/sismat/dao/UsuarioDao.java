package com.juancarlos.sismat.dao;

import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Usuario;


public interface UsuarioDao {
	public boolean iniciaSession(String nombreUsuario,String clave);
	public Empleado datosUsuario(String nombreUsuario,String clave);
	public boolean registroUsuario(Usuario usuario);
}
