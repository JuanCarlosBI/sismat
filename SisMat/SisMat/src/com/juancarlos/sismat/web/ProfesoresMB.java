package com.juancarlos.sismat.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.service.EmpleadoService;

@SuppressWarnings("serial")
@ManagedBean(name="profesoresMB")
@Component
public class ProfesoresMB implements Serializable {
	
	private String dni;
	private String nombres;
	private String apellidos;
	private char cargo;
	private char estado;
	@Autowired
	private EmpleadoService empleadoService;
	private String codigoColegio;
	private List<Empleado> listaProfesores = new ArrayList<Empleado>();
	
	public void listaProfesores(){
		
		codigoColegio = "1041701524";//de manera temporal, luego se eliminara ese dato vendra de sesion
				
		if(!(estado=='A'||estado=='I')){
			estado = ' ';
		}
		
		if(!(cargo=='T'||cargo=='P')){
			cargo = ' ';
		}	
		
		listaProfesores = empleadoService.listaProfesores(codigoColegio, dni, nombres,  apellidos, estado, cargo);
		
		if(listaProfesores == null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hubo un problema en la búsqueda",""));
		}
		else{
			if(listaProfesores.isEmpty()){
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"No se ecnontro alumnos",""));
			}	
		}
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
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public char getCargo() {
		return cargo;
	}
	public void setCargo(char cargo) {
		this.cargo = cargo;
	}
	public char getEstado() {
		return estado;
	}
	public void setEstado(char estado) {
		this.estado = estado;
	}
	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}
	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

}
