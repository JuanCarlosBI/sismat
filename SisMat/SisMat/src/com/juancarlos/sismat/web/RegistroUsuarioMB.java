package com.juancarlos.sismat.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.service.UsuarioService;


@SuppressWarnings("serial")
@ManagedBean(name="registroUsuarioMB")
@SessionScoped
@Component
public class RegistroUsuarioMB implements Serializable{
	private String nombreUsuario;
    private String clave;
    private String tipo;
    private String contrasenia2;
    @Autowired
	UsuarioService usuarioService;

    public void registrarUsuario() {
		
			boolean resultado = usuarioService.registroUsuario(nombreUsuario,
					clave, tipo );
			if (resultado) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Se registro correctamente", ""));
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Hubo un error en guardar la información", ""));
			}
		
		
		

		

	}

	 public void resetFail() {
	        this.nombreUsuario = null;
	        this.clave = null;
	        this.tipo = null;
	        
	        
	        
	         
	        FacesMessage msg = new FacesMessage("Datos limpios");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContrasenia2() {
		return contrasenia2;
	}

	public void setContrasenia2(String contrasenia2) {
		this.contrasenia2 = contrasenia2;
	}


}
