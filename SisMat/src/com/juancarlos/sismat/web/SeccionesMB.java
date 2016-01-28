package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.ArrayList;
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
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.SeccionService;

@SuppressWarnings("serial")
@ManagedBean(name = "seccionesMB")
@SessionScoped
@Component
public class SeccionesMB implements Serializable {

	private String codigoColegio;
	private List<Nivel> nivel;
	private String grado;
	private List<Seccion> seccion;
	private String nivelAcademico;
	private String[] listanivel;
	@Autowired
	SeccionService seccionService;

	public void listaNivel() {
		codigoColegio = "1041701524";
		nivel = seccionService.listaNivel(codigoColegio);
		listanivel = new String[nivel.size()];
		for (int i = 0; i < nivel.size(); i++) {
			Nivel niveles = nivel.get(i);
			listanivel[i] = niveles.getNivelAcademico();
		}
		return;
	}
	

	public void listaSeccion() {
		seccion = seccionService.listaSeccion(codigoColegio, grado,
				nivelAcademico);

		return;
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Curso Editado",
				((Seccion) event.getObject()).getSeccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		boolean resultado = seccionService.editar((Seccion) event.getObject());

	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Curso cancelado");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		seccion.remove((Seccion) event.getObject());
		boolean resultado = seccionService
				.eliminar((Seccion) event.getObject());

	}

	public void reset() {
		this.grado = null;
		this.nivelAcademico = null;
		seccion = null;

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public List<Nivel> getNivel() {
		return nivel;
	}

	public void setNivel(List<Nivel> nivel) {
		this.nivel = nivel;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String[] getListanivel() {
		return listanivel;
	}

	public void setListanivel(String[] listanivel) {
		this.listanivel = listanivel;
	}

	public SeccionService getSeccionService() {
		return seccionService;
	}

	public void setSeccionService(SeccionService seccionService) {
		this.seccionService = seccionService;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public List<Seccion> getSeccion() {
		return seccion;
	}

	public void setSeccion(List<Seccion> seccion) {
		this.seccion = seccion;
	}

}
