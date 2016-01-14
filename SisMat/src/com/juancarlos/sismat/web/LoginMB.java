package com.juancarlos.sismat.web;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.juancarlos.sismat.service.UsuarioService;


@SuppressWarnings("serial")
@ManagedBean(name="loginMB")
@SessionScoped
@Component
public class LoginMB implements Serializable{
	
	private String usuario = "";
	private String password = "";
	String retorno = "";
	@Autowired
	private UsuarioService usuarioServicio;
	@Autowired
	private MainMB mainMB;
	
	
	public String login(){
		System.out.println("probando :P");
		boolean acceso = true;				
		
		acceso = usuarioServicio.iniciaSession(usuario, password);
					
		System.out.println("acceso "+acceso);
		
		if(acceso){
			System.out.println("en acceso "+acceso);
//			retorno = NavigationDestiny.MAIN;
			retorno = "main";
			System.out.println("retorno "+retorno);
			mainMB.datosUsuario();
			
		}
		else{
			System.out.println("sin acceso");
			retorno = "";
		}	
		
		return retorno;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public UsuarioService getUsuarioServicio() {
		return usuarioServicio;
	}

	public void setUsuarioServicio(UsuarioService usuarioServicio) {
		this.usuarioServicio = usuarioServicio;
	}

	public MainMB getMainMB() {
		return mainMB;
	}

	public void setMainMB(MainMB mainMB) {
		this.mainMB = mainMB;
	}	

}
