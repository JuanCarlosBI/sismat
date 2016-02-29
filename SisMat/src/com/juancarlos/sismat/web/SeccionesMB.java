package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.component.api.UIData;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.SeccionService;

@SuppressWarnings("serial")
@ManagedBean(name = "seccionesMB")
@SessionScoped
@Component
public class SeccionesMB implements Serializable {

	private String codigoColegio;
	private List<Nivel> nivel;
	private List<Empleado> empleado;
	private String grado;
	private List<Seccion> seccion;
	private String nivelAcademico;
	private String[] listanivel;
	private String[] listaEmpleado;
	private String[] tutor;
	private String[] listaidTutor;
	private String idTutor;
	@Autowired
	private MainMB mainMB;
	@Autowired
	SeccionService seccionService;

	public void listaNivel() {
	//	codigoColegio = "1041701524";

		mainMB.datosUsuario();
		codigoColegio=mainMB.getCodigoColegio();
		
		nivel = seccionService.listaNivel(codigoColegio);
		listanivel = new String[nivel.size()];
		for (int i = 0; i < nivel.size(); i++) {
			Nivel niveles = nivel.get(i);
			listanivel[i] = niveles.getNivelAcademico();
		}
		empleado=seccionService.listaProfesores(codigoColegio);
		listaEmpleado=new String[empleado.size()];
		for(int j=0;j<empleado.size();j++){
			Empleado empleados=empleado.get(j);
			listaEmpleado[j]=empleados.getNombreCompleto()+"-"+empleados.getIdEmpleado();
			
		}
		return;
	}
	

	public void listaSeccion() {
		seccion = seccionService.listaSeccion(codigoColegio, grado,
				nivelAcademico);
		
		 
		 if (seccion == null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Hubo un problema en la búsqueda", ""));
			} else if (seccion.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"No se encontro Seccion", ""));

			} else {
				listaidTutor = new String[seccion.size()];
				tutor=new String [seccion.size()];
				for (int i = 0; i < seccion.size(); i++) {
					Seccion secciones = seccion.get(i);
					listaidTutor[i] = secciones.getIdTutor();
					tutor[i] = seccionService.nombreTutor(listaidTutor[i])+"-"+listaidTutor[i];
					
					
					
				}
				
				
			}
		 return;
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Seccion Editado",
				((Seccion) event.getObject()).getSeccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
		  UIData data = (UIData) event.getComponent().findComponent("myDataTable");
		  int rowIndex = data.getRowIndex();
		
		 idTutor = tutor[rowIndex].replaceAll("[^0-9.]", "");
		((Seccion) event.getObject()).setIdTutor(idTutor);
		
		boolean resultado = seccionService.editar((Seccion) event.getObject());
		
	}


	
	public void eliminar(Seccion lista) {
		seccion.remove(lista);
		boolean resultado = seccionService.eliminar(lista);
		FacesMessage msg = new FacesMessage("Curso Eliminado",
				lista.getSeccion());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

	public void reset() {
		this.grado = null;
		this.nivelAcademico = null;
		seccion = null;

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String[] getListanivel() {
		return mainMB.getListanivel();
	}

	public void setListanivel(String[] listanivel) {
		this.listanivel = listanivel;
	}

	public SeccionService getSeccionService() {
		return seccionService;
	}

	public void setSeccionService(SeccionService seccionService) {
		this.seccionService = seccionService;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public List<Seccion> getSeccion() {
		return seccion;
	}

	public void setSeccion(List<Seccion> seccion) {
		this.seccion = seccion;
	}


	public String[] getTutor() {
		return tutor;
	}


	public void setTutor(String[] tutor) {
		this.tutor = tutor;
	}


	public String[] getListaidTutor() {
		return listaidTutor;
	}


	public void setListaidTutor(String[] listaidTutor) {
		this.listaidTutor = listaidTutor;
	}


	public MainMB getMainMB() {
		return mainMB;
	}


	public void setMainMB(MainMB mainMB) {
		this.mainMB = mainMB;
	}


	public List<Empleado> getEmpleado() {
		return empleado;
	}


	public void setEmpleado(List<Empleado> empleado) {
		this.empleado = empleado;
	}


	public String[] getListaEmpleado() {
		return listaEmpleado;
	}


	public void setListaEmpleado(String[] listaEmpleado) {
		this.listaEmpleado = listaEmpleado;
	}


	public String getIdTutor() {
		return idTutor;
	}


	public void setIdTutor(String idTutor) {
		this.idTutor = idTutor;
	}


	
	

}
