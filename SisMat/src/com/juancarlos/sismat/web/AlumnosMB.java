package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Usuario;
import com.juancarlos.sismat.service.AlumnoService;

@SuppressWarnings("serial")
@ManagedBean(name = "alumnosMB")
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
	private String estado;

	@Autowired
	private MainMB mainMB;



	public void listaAlumnos() {

		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();
		// codigoColegio = "1041701524";//de manera temporal, luego se eliminara
		// ese dato vendra de sesion

		alumnos = alumnoService.listaAlumnos(codigoColegio, dni, nombres,
				apellidoPaterno, apellidoMaterno, estado);

		if (alumnos == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Hubo un problema en la búsqueda", ""));
		} else {
			if (alumnos.isEmpty()) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"No se ecnontro alumnos", ""));
			}
		}
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Alumno Editado",
				((Alumnos) event.getObject()).getNombreCompleto());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		boolean resultado = alumnoService.editar((Alumnos) event.getObject());

	}

	public void darBaja(Alumnos lista) {
		estado = "Inactivo";
		lista.setEstado(getEstado());

		alumnoService.editar(lista);
	}
	

	public void darAlta(Alumnos lista) {
		estado = "Activo";
		lista.setEstado(getEstado());

		alumnoService.editar(lista);
	}
	
	public void reset() {
		this.dni = null;
		this.nombres = null;

		this.apellidoPaterno = null;

		this.apellidoMaterno = null;
		alumnos=null;

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
