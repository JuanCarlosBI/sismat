package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import jxl.write.DateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.dominio.Usuario;
import com.juancarlos.sismat.service.UsuarioService;

@SuppressWarnings("serial")
@ManagedBean(name="mainMB")
@SessionScoped
@Component
public class MainMB  implements Serializable{

	@Autowired
	private LoginMB loginMB;
	@Autowired
	private UsuarioService usuarioService;
	private String nombre;
	private List<Usuario> usuarios;
	private String nombreUsuario;
	private String codigoColegio;
	
	
	
	
	public void datosUsuario(){
		System.out.println("datosUsuario()");
		
		String usuario = loginMB.getUsuario();
		String  clave = loginMB.getPassword();
		System.out.println("usuario "+usuario);
		System.out.println("clave "+clave);
		
		usuarios = usuarioService.datosUsuario(usuario,clave);
		Usuario empleado = usuarios.get(0);
		
		nombre = empleado.getNombreCompleto();
		nombreUsuario=empleado.getNombreUsuario();
		codigoColegio = empleado.getCodigoColegio();
		System.out.println("codigoColegio "+codigoColegio);
		System.out.println("nombre "+nombre);
		System.out.println("nombreUsuario "+nombreUsuario);
	
	}



	public List<Usuario> getUsuarios() {
		return usuarios;
	}



	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}



	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public LoginMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}


}
