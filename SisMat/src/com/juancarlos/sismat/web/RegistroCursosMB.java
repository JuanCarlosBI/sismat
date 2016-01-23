package com.juancarlos.sismat.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.service.AlumnoService;
import com.juancarlos.sismat.service.CursoService;
import org.primefaces.context.RequestContext;

import org.primefaces.event.CloseEvent;

@SuppressWarnings("serial")
@ManagedBean(name="registroCursosMB")
@SessionScoped
@Component
public class RegistroCursosMB implements Serializable{
	private String nombre;
    private String grado;
    private String nivelAcademico;
    private String area;
    private char estado;
   
	@Autowired
	CursoService cursoService;

	public void registrarCurso() {
		boolean resultado = cursoService.registroCurso(nombre,
				grado, nivelAcademico, area, estado );

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
	        this.nombre = null;
	        this.grado = null;
	        this.nivelAcademico = null;
	        this.area = null;
	        
	        
	        
	         
	        FacesMessage msg = new FacesMessage("Datos limpios");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}
	
}
