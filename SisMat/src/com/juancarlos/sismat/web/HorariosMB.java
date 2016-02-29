package com.juancarlos.sismat.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import java.io.Serializable;
import org.primefaces.context.RequestContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Horarios;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.HorarioService;

@SuppressWarnings("serial")
@ManagedBean(name = "horariosMB")
@SessionScoped
@Component
public class HorariosMB implements Serializable {

	private List<Seccion> seccion;
	private List<Seccion> nombrseccion;
	private String codigoColegio;
	private String nivelAcademico;
	private String grado;
	private List<Nivel> nivel;
	private String dia;

	private List<Empleado> profesor;
	private String[] listanivel;

	private String[] listacurso;
	private String[] listaseccion;
	private List<Horarios> horario;
	private String[] listadocente;
	private Integer idSeccion;
	private List<Cursos> curso;
	private String nombreSeccion;
	private String registroDia;
	private String registroGrado;
	private String registroNivel;
	private String registroSeccion;
	private String registroCurso;
	private String registroProfesor;
	private String registroAula;
	private String registroHoraIni;
	private String registroHoraFin;
	private String idCurso;
	private String idEmpleado;
	@Autowired
	HorarioService horariosService;
	private LoginMB loginMB;

	@Autowired
	private MainMB mainMB;

	public void listaNivel() {
		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();
		nivel = horariosService.listaNivel(codigoColegio);
		listanivel = new String[nivel.size()];
		for (int i = 0; i < nivel.size(); i++) {
			Nivel niveles = nivel.get(i);
			listanivel[i] = niveles.getNivelAcademico();
		}
		return;
	}

	public void listaNivelRegistro() {
		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();
		nivel = horariosService.listaNivel(codigoColegio);
		listanivel = new String[nivel.size()];
		for (int i = 0; i < nivel.size(); i++) {
			Nivel niveles = nivel.get(i);
			listanivel[i] = niveles.getNivelAcademico();
		}
		return;
	}

	public void listaDocente() {
		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();
		profesor = horariosService.listaProfesores(codigoColegio);
		listadocente = new String[profesor.size()];
		for (int i = 0; i < profesor.size(); i++) {
			Empleado profesores = profesor.get(i);
			listadocente[i] = profesores.getNombreCompleto();
		}
		return;
	}

	public void horarios() {
		horario = horariosService.horarios(codigoColegio, nombreSeccion, grado,
				nivelAcademico, dia);

		return;
	}

	public void listaCurso() {
		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();
		grado = registroGrado;
		nivelAcademico = registroNivel;

		curso = horariosService
				.listaCurso(codigoColegio, grado, nivelAcademico);
		listacurso = new String[curso.size()];

		for (int i = 0; i < curso.size(); i++) {
			Cursos cursos = curso.get(i);
			listacurso[i] = cursos.getNombre();
		}
		return;
	}

	public void listaSeccion() {
		seccion = horariosService.listaSeccion(codigoColegio, grado,
				nivelAcademico);
		listaseccion = new String[seccion.size()];
		for (int i = 0; i < seccion.size(); i++) {
			Seccion seciones = seccion.get(i);
			listaseccion[i] = seciones.getSeccion();
		}
		
		return;
	}

	public void listaSeccionRegistro() {

		seccion = horariosService.listaSeccion(codigoColegio, registroGrado,
				registroNivel);
		listaseccion = new String[seccion.size()];
		for (int i = 0; i < seccion.size(); i++) {
			Seccion seciones = seccion.get(i);
			listaseccion[i] = seciones.getSeccion();
		}

		return;
	}

	public void registrarHorario() {

		boolean resultado = horariosService.registroHorario(registroCurso,
				registroProfesor, registroHoraIni, registroHoraFin,
				registroSeccion, registroAula, registroDia, registroGrado,
				registroNivel, codigoColegio);

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

	public void reset() {
		this.registroDia = null;
		this.registroGrado = null;
		this.registroNivel = null;
		this.registroSeccion = null;
		this.registroCurso = null;
		this.registroProfesor = null;
		this.registroAula = null;
		this.registroHoraIni = null;
		this.registroHoraFin = null;

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public List<Seccion> getSeccion() {
		return seccion;
	}

	public void setSeccion(List<Seccion> seccion) {
		this.seccion = seccion;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String getGrado() {
		return grado;
	}

	public void setGrado(String grado) {
		this.grado = grado;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	public String[] getListaseccion() {
		return listaseccion;
	}

	public void setListaseccion(String[] listaseccion) {
		this.listaseccion = listaseccion;
	}

	public List<Seccion> getNombrseccion() {
		return nombrseccion;
	}

	public void setNombrseccion(List<Seccion> nombrseccion) {
		this.nombrseccion = nombrseccion;
	}

	public List<Nivel> getNivel() {
		return nivel;
	}

	public void setNivel(List<Nivel> nivel) {
		this.nivel = nivel;
	}

	public String[] getListanivel() {
		return mainMB.getListanivel();
	}

	public void setListanivel(String[] listanivel) {
		this.listanivel = listanivel;
	}

	public Integer getIdSeccion() {
		return idSeccion;
	}

	public void setIdSeccion(Integer idSeccion) {
		this.idSeccion = idSeccion;
	}

	public LoginMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(LoginMB loginMB) {
		this.loginMB = loginMB;
	}

	public MainMB getMainMB() {
		return mainMB;
	}

	public void setMainMB(MainMB mainMB) {
		this.mainMB = mainMB;
	}

	public HorarioService getHorariosService() {
		return horariosService;
	}

	public void setHorariosService(HorarioService horariosService) {
		this.horariosService = horariosService;
	}

	public String[] getListacurso() {
		return listacurso;
	}

	public void setListacurso(String[] listacurso) {
		this.listacurso = listacurso;
	}

	public List<Cursos> getCurso() {
		return curso;
	}

	public void setCurso(List<Cursos> curso) {
		this.curso = curso;
	}

	public List<Empleado> getProfesor() {
		return profesor;
	}

	public void setProfesor(List<Empleado> profesor) {
		this.profesor = profesor;
	}

	public String[] getListadocente() {
		return listadocente;
	}

	public void setListadocente(String[] listadocente) {
		this.listadocente = listadocente;
	}

	public String getRegistroDia() {
		return registroDia;
	}

	public void setRegistroDia(String registroDia) {
		this.registroDia = registroDia;
	}

	public String getRegistroGrado() {
		return registroGrado;
	}

	public void setRegistroGrado(String registroGrado) {
		this.registroGrado = registroGrado;
	}

	public String getRegistroNivel() {
		return registroNivel;
	}

	public void setRegistroNivel(String registroNivel) {
		this.registroNivel = registroNivel;
	}

	public String getRegistroSeccion() {
		return registroSeccion;
	}

	public void setRegistroSeccion(String registroSeccion) {
		this.registroSeccion = registroSeccion;
	}

	public String getRegistroCurso() {
		return registroCurso;
	}

	public void setRegistroCurso(String registroCurso) {
		this.registroCurso = registroCurso;
	}

	public String getRegistroProfesor() {
		return registroProfesor;
	}

	public void setRegistroProfesor(String registroProfesor) {
		this.registroProfesor = registroProfesor;
	}

	public String getRegistroAula() {
		return registroAula;
	}

	public void setRegistroAula(String registroAula) {
		this.registroAula = registroAula;
	}

	public String getRegistroHoraIni() {
		return registroHoraIni;
	}

	public void setRegistroHoraIni(String registroHoraIni) {
		this.registroHoraIni = registroHoraIni;
	}

	public String getRegistroHoraFin() {
		return registroHoraFin;
	}

	public void setRegistroHoraFin(String registroHoraFin) {
		this.registroHoraFin = registroHoraFin;
	}

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public List<Horarios> getHorario() {
		return horario;
	}

	public void setHorario(List<Horarios> horario) {
		this.horario = horario;
	}

}
