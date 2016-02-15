package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Nivel;
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
    private String codigoColegio;
	private List<Nivel> nivel;
	 private String[] listanivel;
    private String area;
    private String estado;

	@Autowired
	private MainMB mainMB;
	@Autowired
	CursoService cursoService;

	public void listaNivel(){

		mainMB.datosUsuario();
		codigoColegio=mainMB.getCodigoColegio();
		
		//codigoColegio="1041701524";
		nivel = cursoService.listaNivel(codigoColegio);
		listanivel=new String[nivel.size()];
		for(int i=0;i<nivel.size();i++){
			Nivel niveles=nivel.get(i);
			listanivel[i]=niveles.getNivelAcademico();
		}
		return;
	}
	public void registrarCurso() {
		boolean resultado = cursoService.registroCurso(nombre,
				grado, nivelAcademico, area, estado,codigoColegio );

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
