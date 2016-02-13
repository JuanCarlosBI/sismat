package com.juancarlos.sismat.web;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Pagos;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.PagoService;
@SuppressWarnings("serial")
@ManagedBean(name="consultaDeudoresMB")
@RequestScoped
@Component
public class ConsultaDeudoresMB {
	private String dni;
	private String nombreSeccion;
	private String nivel;
	private String nombreAlumno;
	private String codigoColegio;
	private List<Pagos> pagos;
	private List<Matriculas> matriculas;
	private List<Alumnos> alumnos;
	private List<Seccion> seccion;
	
	@Autowired
	private MainMB mainMB;
	@Autowired
	PagoService pagoService;
	
	
	public void listaDeuda() {
		System.out.println("listaMatricula()");

		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();

		matriculas = pagoService.listaMatricula(codigoColegio, dni);

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
			Integer idMatricula = matricula.getIdMatricula();
			pagos =pagoService.listaPago(idMatricula);

			if (pagos == null) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Hubo un problema en la búsqueda", ""));

			} else if (pagos.isEmpty()) {

				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"No se encontro alumnos", ""));

			
			}else{
				
				Integer idSeccion=matricula.getIdSeccion();
				seccion=pagoService.listaSeccion(idSeccion);
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
				 alumnos=pagoService.listaAlumnos(codigoColegio,  dni);
				 Alumnos alumno = alumnos.get(0);
					nombreAlumno = alumno.getNombreCompleto();
				}
			}

		}
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
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


	public List<Pagos> getPagos() {
		return pagos;
	}


	public void setPagos(List<Pagos> pagos) {
		this.pagos = pagos;
	}


	public List<Matriculas> getMatriculas() {
		return matriculas;
	}


	public void setMatriculas(List<Matriculas> matriculas) {
		this.matriculas = matriculas;
	}


	public List<Alumnos> getAlumnos() {
		return alumnos;
	}


	public void setAlumnos(List<Alumnos> alumnos) {
		this.alumnos = alumnos;
	}


	public List<Seccion> getSeccion() {
		return seccion;
	}


	public void setSeccion(List<Seccion> seccion) {
		this.seccion = seccion;
	}


	public MainMB getMainMB() {
		return mainMB;
	}


	public void setMainMB(MainMB mainMB) {
		this.mainMB = mainMB;
	}


	public PagoService getPagoService() {
		return pagoService;
	}


	public void setPagoService(PagoService pagoService) {
		this.pagoService = pagoService;
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
	
	
	
}
