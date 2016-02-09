package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.service.NivelService;

@SuppressWarnings("serial")
@ManagedBean(name = "nivelesAcademicosMB")
@SessionScoped
@Component
public class NivelesAcademicosMB implements Serializable {

	private List<Nivel> listnivel;
	private String nivel;
	private String estado;
	private String codigoColegio;
	@Autowired
	NivelService nivelService;

	@Autowired
	private MainMB mainMB;

	public void listaNiveles() {
		//codigoColegio = "1041701524";

		codigoColegio=mainMB.getCodigoColegio();

		listnivel = nivelService.listaNivel(codigoColegio, nivel, estado);
		return;

	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Nivel Editado",
				((Nivel) event.getObject()).getNivelAcademico());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		boolean resultado = nivelService.editar((Nivel) event.getObject());

	}


	public void darBaja(Nivel lista) {
		estado="Inactivo";
		lista.setEstado(getEstado());
		
		nivelService.editar(lista);
		}
	
	public void darAlta(Nivel lista) {
		estado="Activo";
		lista.setEstado(getEstado());
		
		nivelService.editar(lista);
		}

	public List<Nivel> getListnivel() {
		return listnivel;
	}

	public void setListnivel(List<Nivel> listnivel) {
		this.listnivel = listnivel;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
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

	public NivelService getNivelService() {
		return nivelService;
	}

	public void setNivelService(NivelService nivelService) {
		this.nivelService = nivelService;
	}

}
