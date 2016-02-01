package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.dominio.Usuario;

public interface UsuarioService {
	
	public boolean iniciaSession(String nombreUsuario,String clave);
	public Empleado datosUsuario(String nombreUsuario,String clave);
	public boolean registroUsuario(String nombreUsuario,String clave,String tipo,String nombreCompleto,String estado, String codigoColegio);
	 public List<Usuario> nombreUsuario(String nombreCompleto);
		public List<Usuario> listaUsuario(String codigoColegio, String idUsuario);

		public boolean editar(Usuario editarUsuario);
}
