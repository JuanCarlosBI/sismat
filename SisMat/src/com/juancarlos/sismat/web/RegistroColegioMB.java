package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Colegio;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.ColegioService;

@SuppressWarnings("serial")
@ManagedBean(name = "registroColegioMB")
@SessionScoped
@Component
public class RegistroColegioMB implements Serializable {

	private String razonSocial;
	private String ruc;
	private String correo;
	private String direccion;
	private String codigoColegio;
	private String telefono;
	private String fax;
	private byte[] logo;
	@Autowired
	ColegioService colegioService;
	@Autowired
	MainMB loginMB;

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Fichero "
				+ event.getFile().getFileName() + " subido correctamente."+logo);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		logo = event.getFile().getContents();
		String nombrefoto = event.getFile().getFileName();
	}

	public void registrarColegio() {
	

		boolean resultado = colegioService.registroColegio(razonSocial, ruc,
				correo, direccion, telefono, fax, logo);
		this.razonSocial=null;
		this.ruc=null;
		this.correo=null;
		this.direccion=null;
		this.telefono=null;
		this.fax=null;
		this.logo=null;
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
	public void reset(){
		this.razonSocial=null;
		this.ruc=null;
		this.correo=null;
		this.direccion=null;
		this.telefono=null;
		this.fax=null;
		this.logo=null;


		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}


	public MainMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(MainMB loginMB) {
		this.loginMB = loginMB;
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}


}
