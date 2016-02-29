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
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.dominio.Usuario;
import com.juancarlos.sismat.service.CursoService;
import com.juancarlos.sismat.service.UsuarioService;

@SuppressWarnings("serial")
@ManagedBean(name = "mainMB")
@SessionScoped
@Component
public class MainMB implements Serializable {

	@Autowired
	private LoginMB loginMB;
	@Autowired
	private UsuarioService usuarioService;
	private String nombre;
	private List<Usuario> usuarios;
	private String nombreUsuario;
	private String codigoColegio;
	private List<Nivel> nivel;
	private String[] listanivel;
	@Autowired
	CursoService cursoService;

	public void datosUsuario() {

		String usuario = loginMB.getUsuario();
		String clave = loginMB.getPassword();

		usuarios = usuarioService.datosUsuario(usuario, clave);
		Usuario empleado = usuarios.get(0);

		nombre = empleado.getNombreCompleto();
		nombreUsuario = empleado.getNombreUsuario();
		codigoColegio = empleado.getCodigoColegio();
		

		nivel = cursoService.listaNivel(codigoColegio);
		listanivel = new String[nivel.size()];
		for (int i = 0; i < nivel.size(); i++) {
			Nivel niveles = nivel.get(i);
			listanivel[i] = niveles.getNivelAcademico();
		}
		return;

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

	public List<Nivel> getNivel() {
		return nivel;
	}

	public void setNivel(List<Nivel> nivel) {
		this.nivel = nivel;
	}

	public String[] getListanivel() {
		return listanivel;
	}

	public void setListanivel(String[] listanivel) {
		this.listanivel = listanivel;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}
