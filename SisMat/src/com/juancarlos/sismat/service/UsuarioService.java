package com.juancarlos.sismat.service;

import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Usuario;

public interface UsuarioService {
	
	public boolean iniciaSession(String nombreUsuario,String clave);
	public Empleado datosUsuario(String nombreUsuario,String clave);

}
