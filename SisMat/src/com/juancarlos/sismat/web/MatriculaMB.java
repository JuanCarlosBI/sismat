package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.MatriculaService;

@SuppressWarnings("serial")
@ManagedBean(name = "matriculaMB")
@RequestScoped
@Component
public class MatriculaMB implements Serializable {

	private String dni;
	private String estado;
	private String nombreAlumno;
	private String codigoColegio;
	private List<Matriculas> matriculas;
	private List<Alumnos> alumnos;
	private List<Seccion> seccion;
	private String nombreSeccion;
	private String nivel;
	private int idSeccion;
	@Autowired
	private MainMB mainMB;
	@Autowired
	MatriculaService matriculaService;

	public void listaMatricula() {
		System.out.println("listaMatricula()");

		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();

		matriculas = matriculaService
				.listaMatricula(codigoColegio, dni, estado);

		if (matriculas == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Hubo un problema en la búsqueda", ""));
		} else if (matriculas.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"No se ecnontro alumnos", ""));

		} else {
			Matriculas matricula = matriculas.get(0);
			idSeccion = matricula.getIdSeccion();
			alumnos = matriculaService.listaAlumnos(codigoColegio, dni);

			if (alumnos == null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Hubo un problema en la búsqueda", ""));

			} else if (alumnos.isEmpty()) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"No se encontro alumnos", ""));

			} else {
				Alumnos alumno = alumnos.get(0);
				nombreAlumno = alumno.getNombreCompleto();
				seccion=matriculaService.nombreSeccion(codigoColegio, idSeccion);
				if (seccion == null) {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Hubo un problema en la búsqueda", ""));

				} else if (seccion.isEmpty()) {

					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"No se encontro seccion", ""));

				} else { Seccion nseccion = seccion.get(0);
				nombreSeccion = nseccion.getSeccion();
				nivel=nseccion.getNivelAcademico();
				}
			}

		}
	}

	public void reset() {
		this.dni = null;
		matriculas = null;

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Matriculas> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matriculas> matriculas) {
		this.matriculas = matriculas;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public List<Alumnos> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List<Alumnos> alumnos) {
		this.alumnos = alumnos;
	}

	public MainMB getMainMB() {
		return mainMB;
	}

	public void setMainMB(MainMB mainMB) {
		this.mainMB = mainMB;
	}

	public MatriculaService getMatriculaService() {
		return matriculaService;
	}

	public void setMatriculaService(MatriculaService matriculaService) {
		this.matriculaService = matriculaService;
	}

	public List<Seccion> getSeccion() {
		return seccion;
	}

	public void setSeccion(List<Seccion> seccion) {
		this.seccion = seccion;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public int getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(int idSeccion) {
		this.idSeccion = idSeccion;
	}

}
