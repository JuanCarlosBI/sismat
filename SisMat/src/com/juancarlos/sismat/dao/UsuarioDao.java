package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Usuario;
import com.juancarlos.sismat.dominio.Empleado;


public interface UsuarioDao {
	public boolean iniciaSession(String nombreUsuario,String clave);
	public List<Usuario>  datosUsuario(String nombreUsuario,String clave);
	public boolean registroUsuario(Usuario usuario);
	  public List<Usuario> nombreUsuario(String nombreUsuario);
	  public List<Usuario> listaUsuario(String codigoColegio, String idUsuario);
	  public boolean editar(Usuario editarUsuario);
	  
}

