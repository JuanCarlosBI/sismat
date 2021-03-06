package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.CursoService;

@SuppressWarnings("serial")
@ManagedBean(name = "cursosMB")
@SessionScoped
@Component
public class CursosMB implements Serializable {

	private String codigoColegio;
	private List<Nivel> nivel;
	private String[] listanivel;
	private String nivelAcademico;
	private String nombcurso;

	private List<Cursos> curso;
    private String estado;

	@Autowired
	private MainMB mainMB;
	@Autowired
	CursoService cursoService;

	public List<String> autoCompletadoCurso(String query) {

		
		

		List<String> results = new ArrayList<String>();
		List<Cursos> listaNombresCursos = new ArrayList<Cursos>();

		listaNombresCursos = cursoService.nombreCurso(query.toUpperCase());
	//	codigoColegio = "1041701524";

		mainMB.datosUsuario();
		codigoColegio=mainMB.getCodigoColegio();
		
		
		
		if (query.length() >= 3) {
			for (Cursos elemento : listaNombresCursos) {
				results.add(elemento.getNombre());
			}
		}

		return results;

	}

	public void listaNivel() {
		mainMB.datosUsuario();
		codigoColegio=mainMB.getCodigoColegio();
		
		nivel = cursoService.listaNivel(codigoColegio);
		listanivel = new String[nivel.size()];
		for (int i = 0; i < nivel.size(); i++) {
			Nivel niveles = nivel.get(i);
			listanivel[i] = niveles.getNivelAcademico();
		}
		return;
	}
	
	public void listaCurso() {
		mainMB.datosUsuario();
		codigoColegio=mainMB.getCodigoColegio();
		
		 curso = cursoService.listaCurso(codigoColegio, nombcurso,
				nivelAcademico,estado);
		 int resultado=curso.size();
		 if (resultado==0) {
			 FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Curso no encontrado", ""));
			} 
	
		 return;
	}
	
	
	

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Curso Editado",
				((Cursos) event.getObject()).getNombre());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		boolean resultado = cursoService.editar((Cursos) event.getObject());

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

	public String[] getListanivel() {
		return mainMB.getListanivel();
	}

	public void setListanivel(String[] listanivel) {
		this.listanivel = listanivel;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public String getNivelAcademico() {
		return nivelAcademico;
	}

	public void setNivelAcademico(String nivelAcademico) {
		this.nivelAcademico = nivelAcademico;
	}

	public String getNombcurso() {
		return nombcurso;
	}

	public void setNombcurso(String nombcurso) {
		this.nombcurso = nombcurso;
	}

	public List<Cursos> getCurso() {
		return curso;
	}

	public void setCurso(List<Cursos> curso) {
		this.curso = curso;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	

	
	
}
