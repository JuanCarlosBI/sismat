package com.juancarlos.sismat.web;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.service.EmpleadoService;

@SuppressWarnings("serial")
@ManagedBean(name="profesoresMB")
@Component
public class ProfesoresMB implements Serializable {
	
	private String dni;
	private String nombres;
	private String apellidos;
	private String estado;

	@Autowired
	private MainMB mainMB;
	@Autowired
	private EmpleadoService empleadoService;
	private String codigoColegio;
	private List<Empleado> listaProfesores = new ArrayList<Empleado>();
	
	public void listaProfesores(){

		mainMB.datosUsuario();
		codigoColegio=mainMB.getCodigoColegio();

		
		listaProfesores = empleadoService.listaProfesores(codigoColegio, dni, nombres,  apellidos, estado);
		
		if(listaProfesores == null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hubo un problema en la búsqueda",""));
		}
		else{
			if(listaProfesores.isEmpty()){
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"No se encontro profesor",""));
			}	
		}
	}
	

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Alumno Editado",
				((Empleado) event.getObject()).getNombreCompleto());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		boolean resultado = empleadoService.editar((Empleado) event.getObject());

	}

	public void darBaja(Empleado lista) {
		estado = "Inactivo";
		lista.setEstado(getEstado());

		empleadoService.editar(lista);
	}
	

	public void darAlta(Empleado lista) {
		estado = "Activo";
		lista.setEstado(getEstado());

		empleadoService.editar(lista);
	}
	
	public void reset() {
		this.dni = null;
		this.nombres = null;

		this.apellidos = null;
		listaProfesores=null;

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}
	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}


	public String getCodigoColegio() {
		return codigoColegio;
	}


	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}


	public List<Empleado> getListaProfesores() {
		return listaProfesores;
	}


	public void setListaProfesores(List<Empleado> listaProfesores) {
		this.listaProfesores = listaProfesores;
	}

}
