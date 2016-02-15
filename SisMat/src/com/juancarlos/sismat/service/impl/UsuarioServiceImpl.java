package com.juancarlos.sismat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.UsuarioDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.dominio.Usuario;
import com.juancarlos.sismat.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	UsuarioDao usuarioDao;
	
	public boolean registroUsuario(String nombreUsuario,String clave,String tipo,String nombreCompleto,String estado, String codigoColegio,String fecha){
		Usuario usuario = new Usuario();
		
		usuario.setNombreUsuario(nombreUsuario);
		usuario.setClave(clave);
		usuario.setTipo(tipo);
		usuario.setNombreCompleto(nombreCompleto);
		usuario.setEstado(estado);
		usuario.setCodigoColegio(codigoColegio);
		usuario.setFecha(fecha);
		return usuarioDao.registroUsuario(usuario);
	}
	
	public boolean iniciaSession(String nombreUsuario, String clave) {
		
		return  usuarioDao.iniciaSession(nombreUsuario, clave);
		
	}
	
	public List<Usuario> datosUsuario(String nombreUsuario, String clave) {
		
		return usuarioDao.datosUsuario(nombreUsuario, clave);
	}
	
	public List<Usuario> nombreUsuario(String nombreUsuario) {
		// TODO Auto-generated method stub
		 return usuarioDao.nombreUsuario(nombreUsuario);
	}

	

	public List<Usuario> listaUsuario(String codigoColegio, String idUsuario){
		
		List<Usuario> listaUsuario=usuarioDao.listaUsuario(codigoColegio,idUsuario);
		return listaUsuario;
	}

	public boolean editar(Usuario editarUsuario){
		return usuarioDao.editar(editarUsuario);
	}
}
