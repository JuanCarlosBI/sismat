package com.juancarlos.sismat.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.service.NivelService;

@SuppressWarnings("serial")
@ManagedBean(name = "registroNivelesMB")
@SessionScoped
@Component
public class RegistroNivelesMB implements Serializable {

	private String tipo;
	private String nivel;
	private String codigoColegio;
	private String orden;
	private String nroVacantes;
	private String estado;
	@Autowired
	NivelService nivelService;
	@Autowired
	private MainMB mainMB;

	public void registrarNivel() {
		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();
		
		boolean resultado = nivelService.registroNivel(tipo, nivel, orden,
				nroVacantes, estado, codigoColegio);

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
		this.tipo = null;
		this.nivel = null;
		this.orden = null;
		this.nroVacantes = null;

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getOrden() {
		return orden;
	}

	public void setOrden(String orden) {
		this.orden = orden;
	}

	public String getNroVacantes() {
		return nroVacantes;
	}

	public void setNroVacantes(String nroVacantes) {
		this.nroVacantes = nroVacantes;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

}
