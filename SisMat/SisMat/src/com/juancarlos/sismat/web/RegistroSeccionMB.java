package com.juancarlos.sismat.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.service.SeccionService;

import java.io.Serializable;
import java.util.List;

import java.util.ArrayList;

@SuppressWarnings("serial")
@ManagedBean(name="registroSeccionMB")
@SessionScoped
@Component
public class RegistroSeccionMB implements Serializable {

	
	private String idTutor;
	private String idCoTutor;

	private String nombres;
	private String nombresco;
	private String grado;
    private String seccion;
    private String nivelAcademico;
    private String nroVacantes;
    private String nroAula;
    private String periodo;
    
	@Autowired
	SeccionService seccionService;
	
	public List<String> autoCompletadoProducto(String query) {
		
		
		List<String> results = new ArrayList<String>();
		List<Empleado> listaNombresProductos = new ArrayList<Empleado>();		
		
		listaNombresProductos = seccionService.nombreEmpleado(query.toUpperCase());
		
		
		if (query.length() >= 3) {
			for (Empleado elemento : listaNombresProductos) {
				results.add(elemento.getNombreCompleto()+"-"+elemento.getIdEmpleado());	
			}
		}

		return results;

	}


	public void registrarSeccion() {

		idTutor= nombres.replaceAll("[^0-9.]", "");
		idCoTutor=nombresco.replaceAll("[^0-9.]", "");
		
		boolean resultado = seccionService.registroSeccion(idTutor,idCoTutor,
				grado, nivelAcademico, seccion, nroVacantes,nroAula,periodo );

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
	        this.nombres = null;
	        this.grado = null;
	        this.nivelAcademico = null;
	        this.seccion = null;
	        this.nroVacantes = null;
	        this.nroAula = null;
	        this.periodo = null;
	        this.nombresco = null;
	        
	        
	        FacesMessage msg = new FacesMessage("Datos limpios");
	        FacesContext.getCurrentInstance().addMessage(null, msg);
	    }

	
	
	
	public SeccionService getSeccionService() {
		return seccionService;
	}
	public void setSeccionService(SeccionService seccionService) {
		this.seccionService = seccionService;
	}



	public String getIdTutor() {
		return idTutor;
	}


	public void setIdTutor(String idTutor) {
		this.idTutor = idTutor;
	}


	public String getIdCoTutor() {
		return idCoTutor;
	}


	public void setIdCoTutor(String idCoTutor) {
		this.idCoTutor = idCoTutor;
	}


	public String getGrado() {
		return grado;
	}


	public void setGrado(String grado) {
		this.grado = grado;
	}


	public String getSeccion() {
		return seccion;
	}


	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}


	public String getNivelAcademico() {
		return nivelAcademico;
	}


	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}


	public String getNroVacantes() {
		return nroVacantes;
	}


	public void setNroVacantes(String nroVacantes) {
		this.nroVacantes = nroVacantes;
	}


	public String getNroAula() {
		return nroAula;
	}


	public void setNroAula(String nroAula) {
		this.nroAula = nroAula;
	}


	public String getPeriodo() {
		return periodo;
	}


	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getNombresco() {
		return nombresco;
	}


	public void setNombresco(String nombresco) {
		this.nombresco = nombresco;
	}



	
}
