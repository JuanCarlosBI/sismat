package com.juancarlos.sismat.dao;

import com.juancarlos.sismat.dominio.Empleado;


public interface UsuarioDao {
	public boolean iniciaSession(String nombreUsuario,String clave);
	public Empleado datosUsuario(String nombreUsuario,String clave);
}
