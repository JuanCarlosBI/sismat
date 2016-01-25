package com.juancarlos.sismat.web;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
 
public class OrderBean implements Serializable {
 
    private static final long serialVersionUID = 1L;
    private String nombrecursoexo;
    private String motivo;
 
    public OrderBean(String nombrecursoexo, String motivo) {
        this.nombrecursoexo = nombrecursoexo;
        this.motivo = motivo;
    }

   
	public String getNombrecursoexo() {
		return nombrecursoexo;
	}

	public void setNombrecursoexo(String nombrecursoexo) {
		this.nombrecursoexo = nombrecursoexo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}    
 
    
    
}