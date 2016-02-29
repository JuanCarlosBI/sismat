package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Usuario;
import com.juancarlos.sismat.service.AlumnoService;



@SuppressWarnings("serial")
@ManagedBean(name="alumnosMB")
@RequestScoped
@Component
public class AlumnosMB implements Serializable {

	@Autowired
	AlumnoService alumnoService;
	private String codigoColegio;
	private List<Alumnos> alumnos;	
	private String dni;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private char estado;
	
	private String eDni;
	private String eNombres;
	private String eApellidoPaterno;
	private String eApellidoMaterno;
	private char eEstado;
	
	public AlumnosMB(){

	}
	
	public void listaAlumnos(){if(!(estado=='A'||estado=='I')){
			estado = ' ';
		}
		alumnos = alumnoService.listaAlumnos(codigoColegio, dni, nombres,  apellidoPaterno,apellidoMaterno, estado);
		
		if(alumnos == null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hubo un problema en la búsqueda",""));
		}
		else{
			if(alumnos.isEmpty()){
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"No se ecnontro alumnos",""));
			}	
		}
	}
	
	public void limpia(){
		alumnos = new ArrayList<Alumnos>();
		dni="";
		nombres="";
		apellidoPaterno="";
		apellidoMaterno="";
		
	}
	

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public AlumnoService getAlumnoService() {
		return alumnoService;
	}

	public void setAlumnoService(AlumnoService alumnoService) {
		this.alumnoService = alumnoService;
	}

	public List<Alumnos> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumnos> alumnos) {
		this.alumnos = alumnos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public char getEstado() {
		return estado;
	}

	public void setEstado(char estado) {
		this.estado = estado;
	}

	public String geteDni() {
		return eDni;
	}

	public void seteDni(String eDni) {
		this.eDni = eDni;
	}

	public String geteNombres() {
		return eNombres;
	}

	public void seteNombres(String eNombres) {
		this.eNombres = eNombres;
	}

	public String geteApellidoPaterno() {
		return eApellidoPaterno;
	}

	public void seteApellidoPaterno(String eApellidoPaterno) {
		this.eApellidoPaterno = eApellidoPaterno;
	}

	public String geteApellidoMaterno() {
		return eApellidoMaterno;
	}

	public void seteApellidoMaterno(String eApellidoMaterno) {
		this.eApellidoMaterno = eApellidoMaterno;
	}

	public char geteEstado() {
		return eEstado;
	}

	public void seteEstado(char eEstado) {
		this.eEstado = eEstado;
	}
	
}
