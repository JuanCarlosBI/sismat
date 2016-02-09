package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Empleado;
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
	private String apellido;
	private Empleado empleado;
	private String nombreUsuario;
	private String codigoColegio;
	
	
	
	
	public void datosUsuario(){
		System.out.println("datosUsuario()");
		
		String usuario = loginMB.getUsuario();
		String  clave = loginMB.getPassword();
		System.out.println("usuario "+usuario);
		System.out.println("clave "+clave);
		
		empleado = usuarioService.datosUsuario(usuario,clave);
		nombre = empleado.getNombres();
		apellido = empleado.getApellidos();
		//codigoColegio = empleado.getCodigoColegio();
		codigoColegio = "1041701524";
		System.out.println("codigoColegio "+codigoColegio);
		System.out.println("nombre "+nombre);
		System.out.println("apellido "+apellido);
		nombreUsuario = nombre +" "+ apellido;	
		System.out.println("nombreUsuario "+nombreUsuario);
	
	}

	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

}
