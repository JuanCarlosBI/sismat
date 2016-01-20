package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.service.MatriculaService;
import com.juancarlos.sismat.service.PagoService;

@SuppressWarnings("serial")
@ManagedBean(name="matriculaNormalMB")
@SessionScoped
@Component
public class MatriculaNormalMB implements Serializable{
	
	public String idAlumno;
	public String nombres;
	private List<Alumnos> alumnos;
	private String codigoColegio;
	private String responsable;
	private String direccion;
	private String edad;
	private char sexo;

	@Autowired
	MatriculaService  matriculaService;
	public List<String> autoCompletadoAlumno(String query) {
		
		System.out.println("autoCompletadoProducto");
		System.out.println("query "+query);
		
		List<String> results = new ArrayList<String>();
		List<Alumnos> listaNombresAlumnos = new ArrayList<Alumnos>();		
		
		listaNombresAlumnos = matriculaService.nombreAlumno(query.toUpperCase());


		
		if (query.length() >= 3) {
			for (Alumnos elemento : listaNombresAlumnos) {
				results.add(elemento.getNombreCompleto()+"-"+elemento.getIdAlumno());	
			}
		}


		return results;

	}
	

	
	public void listaAlumnos(){

		System.out.println("listaAlumnos()");
		idAlumno= nombres.replaceAll("[^0-9.]", "");

		codigoColegio = "1041701524";//de manera temporal, luego se eliminara ese dato vendra de sesion
		System.out.println("codigoColegio "+codigoColegio);
		System.out.println("idAlumno "+idAlumno);
		alumnos = matriculaService.listaAlumnos(codigoColegio, idAlumno);
		
		if(alumnos == null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hubo un problema en la búsqueda",""));
			this.responsable=null;
			this.direccion=null;
			this.edad=null;
			this.sexo=(Character) null;
		}
		else if(alumnos.isEmpty()){
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"No se encontro alumnos",""));
				this.responsable=null;
				this.direccion=null;
				this.edad=null;
				this.sexo=(Character) null;
		}else{
			Alumnos alumno=alumnos.get(0); 
			responsable=alumno.getResponsable();
			direccion=alumno.getDireccion();
			edad=alumno.getEdad();
			sexo=alumno.getSexo();
			
		}
		return;
	}

	
	
	public String getIdAlumno() {
		return idAlumno;
	}
	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}
	public MatriculaService getMatriculaService() {
		return matriculaService;
	}
	public void setMatriculaService(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}



	public List<Alumnos> getAlumnos() {
		return alumnos;
	}



	public void setAlumnos(List<Alumnos> alumnos) {
		this.alumnos = alumnos;
	}



	public String getCodigoColegio() {
		return codigoColegio;
	}



	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}



	public String getResponsable() {
		return responsable;
	}



	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getEdad() {
		return edad;
	}



	public void setEdad(String edad) {
		this.edad = edad;
	}



	public char getSexo() {
		return sexo;
	}



	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

}
