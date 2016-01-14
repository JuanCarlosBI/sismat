package com.juancarlos.sismat.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.service.ColegioService;

@SuppressWarnings("serial")
@ManagedBean(name="registroColegioMB")
@SessionScoped
@Component
public class RegistroColegioMB implements Serializable {
	
	private String razonSocial;
	private String ruc;
	private String correo;
	private String direccion;
	private String telefono;
	private String fax;
	@Autowired
	ColegioService colegioService;
	
	
	public void registrarColegio(){
		System.out.println("registroColegio");
		
		boolean resultado = colegioService.registroColegio(razonSocial,ruc,correo,direccion,telefono,fax);
		
		if(resultado){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Se registro correctamente",""));
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hubo un error en guardar la información",""));
		}		
	}

	public void actualizarRegistrarColegio(){
		System.out.println("actualizarRegistrarColegio");
		
		boolean resultado = colegioService.registroColegio(razonSocial,ruc,correo,direccion,telefono,fax);
		
		if(resultado){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Se actualizo correctamente",""));
		}
		else{
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hubo un error en actualizar la información",""));
		}		
	}

	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}


	public String getRuc() {
		return ruc;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}


	public ColegioService getColegioService() {
		return colegioService;
	}

	public void setColegioService(ColegioService colegioService) {
		this.colegioService = colegioService;
	}
	
}
