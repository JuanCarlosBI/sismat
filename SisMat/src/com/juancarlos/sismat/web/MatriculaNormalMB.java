package com.juancarlos.sismat.web;

import java.io.Serializable;
import org.primefaces.context.RequestContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.MatriculaService;
import com.juancarlos.sismat.service.PagoService;

@SuppressWarnings("serial")
@ManagedBean(name = "matriculaNormalMB")
@SessionScoped
@Component
public class MatriculaNormalMB implements Serializable {

	public String idAlumno;
	public String nombres;
	private List<Alumnos> alumnos;
	private List<Seccion> seccion;
	private List<Seccion> nombrseccion;
	private List<Matriculas> matricula;
	private String codigoColegio;
	private String responsable;
	private String direccion;
	private String edad;
	private char sexo;
	private String situacion;
	private String antColegio;
	private String periodo;
	private String nivelAcademico;
	private String grado;
	private String aula = null;
	private String vacantes = null;
	private List<Empleado> tutor;
	private List<Empleado> cotutor;
	private String idCurso;
	private List<Nivel> nivel;
	private String[] listanivel;
	private String idtutor;
	private String idcotutor;
	private String nombretutor = null;
	private String nombrecotutor = null;
	private String[] listacurso;
	private String[] nombrecurso;
	private String[] listaseccion;
	private List<Cursos> curso;
	private String motivo;
	private String nombrecursoexo;
	private Integer idSeccion;
	private Integer idMatricula;
	OrderBean order;

	private String nombreSeccion;
	@Autowired
	MatriculaService matriculaService;
	@Autowired
	private LoginMB loginMB;

	@Autowired
	private MainMB mainMB;

	public List<String> autoCompletadoAlumno(String query) {

		System.out.println("autoCompletadoProducto");
		System.out.println("query " + query);

		List<String> results = new ArrayList<String>();
		List<Alumnos> listaNombresAlumnos = new ArrayList<Alumnos>();

		listaNombresAlumnos = matriculaService
				.nombreAlumno(query.toUpperCase());

		if (query.length() >= 3) {
			for (Alumnos elemento : listaNombresAlumnos) {
				results.add(elemento.getNombreCompleto() + "-"
						+ elemento.getIdAlumno());
			}
		}

		return results;

	}

	public void listaAlumnos() {

		System.out.println("listaAlumnos()");
		idAlumno = nombres.replaceAll("[^0-9.]", "");
		// loginMB.datosUsuario();
		// loginMB.getCodigoColegio();
	//	codigoColegio = "1041701524";// de manera temporal, luego se eliminara
										// ese dato vendra de sesion

		codigoColegio=mainMB.getCodigoColegio();

		alumnos = matriculaService.listaAlumnos(codigoColegio, idAlumno);

		if (alumnos == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Hubo un problema en la búsqueda", ""));

		} else if (alumnos.isEmpty()) {
			this.responsable = null;
			this.direccion = null;
			this.edad = null;
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"No se encontro alumnos", ""));

		} else {
			Alumnos alumno = alumnos.get(0);
			responsable = alumno.getResponsable();
			direccion = alumno.getDireccion();
			edad = alumno.getEdad();
			sexo = alumno.getSexo();

		}
		return;
	}

	public void agregar() {
		System.out.println(nombrecurso);
		return;
	}

	public String addAction() {
		OrderBean orderitem = new OrderBean(this.nombrecursoexo, this.motivo);
		orderList.add(orderitem);
		nombrecursoexo = "";
		motivo = "";

		return null;

	}

	public OrderBean getOrder() {
		return order;
	}

	public void setOrder(OrderBean order) {
		this.order = order;
	}

	private static ArrayList<OrderBean> orderList = new ArrayList<OrderBean>();

	public ArrayList<OrderBean> getOrderList() {
		return orderList;
	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Curso Editado",
				((OrderBean) event.getObject()).getMotivo());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Curso cancelado");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		orderList.remove((OrderBean) event.getObject());
	}

	public void nombSeccion() {
		nombrseccion = matriculaService.nombreSec(codigoColegio, nombreSeccion,
				grado, nivelAcademico);
		Seccion secciones = nombrseccion.get(0);
		idtutor = secciones.getIdTutor();
		idcotutor = secciones.getIdCoTutor();
		aula = secciones.getNroAula();
		vacantes = secciones.getNroVacantes();
		idSeccion = secciones.getIdSeccion();
		tutor = matriculaService.nombreTutor(idtutor);
		cotutor = matriculaService.nombreCoTutor(idcotutor);
		System.out.println("La id es: " + idSeccion);
		Empleado tutores = tutor.get(0);
		Empleado cotutores = cotutor.get(0);
		nombretutor = tutores.getNombreCompleto();
		nombrecotutor = cotutores.getNombreCompleto();

		if (nombrseccion == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Hubo un problema en la búsqueda", ""));
			this.nombretutor = null;
			this.nombrecotutor = null;
			this.aula = null;
			this.vacantes = null;
		} else if (nombrseccion.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"No se encontro seccion", ""));
			this.nombretutor = null;
			this.nombrecotutor = null;
			this.aula = null;
			this.vacantes = null;

		}

		return;
	}

	public void listaNivel() {
		nivel = matriculaService.listaNivel(codigoColegio);
		listanivel = new String[nivel.size()];
		for (int i = 0; i < nivel.size(); i++) {
			Nivel niveles = nivel.get(i);
			listanivel[i] = niveles.getNivelAcademico();
		}
		return;
	}

	public void listaSeccion() {
		seccion = matriculaService.listaSeccion(codigoColegio, grado,
				nivelAcademico);
		listaseccion = new String[seccion.size()];
		for (int i = 0; i < seccion.size(); i++) {
			Seccion seciones = seccion.get(i);
			listaseccion[i] = seciones.getSeccion();
		}

		curso = matriculaService.listaCurso(codigoColegio, grado,
				nivelAcademico);
		listacurso = new String[curso.size()];

		for (int i = 0; i < curso.size(); i++) {
			Cursos cursos = curso.get(i);
			listacurso[i] = cursos.getNombre() + "-" + cursos.getIdCurso();
		}

		return;
	}

	public void registrarMatricula() {
		boolean resultado = matriculaService.registroMatricula(idAlumno,
				idSeccion, periodo, situacion, antColegio, codigoColegio);

		if (resultado) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Se registro correctamente", ""));
			matricula = matriculaService.idMatricula(idAlumno);
			Matriculas listaMatricula = matricula.get(0);
			idMatricula = listaMatricula.getIdMatricula();
			System.out.println(idMatricula);

			for (int i = 0; i < orderList.size(); i++) {
				idCurso = orderList.get(i).getNombrecursoexo()
						.replaceAll("[^0-9.]", "");
				String regmotivo = orderList.get(i).getMotivo();
				String tipo = "Exonerado";
				boolean registrar = matriculaService.registroMatriculaCurso(
						idMatricula, idCurso, tipo, regmotivo, codigoColegio);

			}
			for (int i = 0; i < nombrecurso.length; i++) {
				idCurso = nombrecurso[i].replaceAll("[^0-9.]", "");
				System.out.println(idCurso);
				String tipo = "Matriculado";
				motivo = "";
				boolean registrar = matriculaService.registroMatriculaCurso(
						idMatricula, idCurso, tipo, motivo, codigoColegio);
			}

		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Hubo un error en guardar la información", ""));
		}

	}

	public void resetFail() {
		this.nombrecurso = null;

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void reset() {
		this.nombres = null;
		this.responsable = null;
		this.direccion = null;
		this.edad = null;
		this.antColegio = null;
		this.situacion = null;
		this.periodo = null;
		this.grado = null;
		this.nivelAcademico = null;
		this.nombreSeccion = null;
		this.vacantes = null;
		this.nombretutor = null;
		this.nombrecotutor = null;
		this.aula = null;
		this.nombrecurso = null;
		this.nombrecursoexo = null;
		this.motivo = null;
		MatriculaNormalMB.orderList.clear();

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
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

	public String getSituacion() {
		return situacion;
	}

	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	public String getAntColegio() {
		return antColegio;
	}

	public void setAntColegio(String antColegio) {
		this.antColegio = antColegio;
	}

	public String getPeriodo() {
		return periodo;
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

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getNombreSeccion() {
		return nombreSeccion;
	}

	public void setNombreSeccion(String nombreSeccion) {
		this.nombreSeccion = nombreSeccion;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}

	public String getVacantes() {
		return vacantes;
	}

	public void setVacantes(String vacantes) {
		this.vacantes = vacantes;
	}

	public String getIdtutor() {
		return idtutor;
	}

	public void setIdtutor(String idtutor) {
		this.idtutor = idtutor;
	}

	public String getIdcotutor() {
		return idcotutor;
	}

	public void setIdcotutor(String idcotutor) {
		this.idcotutor = idcotutor;
	}

	public List<Empleado> getTutor() {
		return tutor;
	}

	public void setTutor(List<Empleado> tutor) {
		this.tutor = tutor;
	}

	public List<Empleado> getCotutor() {
		return cotutor;
	}

	public void setCotutor(List<Empleado> cotutor) {
		this.cotutor = cotutor;
	}

	public String getNombretutor() {
		return nombretutor;
	}

	public void setNombretutor(String nombretutor) {
		this.nombretutor = nombretutor;
	}

	public String getNombrecotutor() {
		return nombrecotutor;
	}

	public void setNombrecotutor(String nombrecotutor) {
		this.nombrecotutor = nombrecotutor;
	}

	public List<Cursos> getCurso() {
		return curso;
	}

	public void setCurso(List<Cursos> curso) {
		this.curso = curso;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String[] getListacurso() {
		return listacurso;
	}

	public void setListacurso(String[] listacurso) {
		this.listacurso = listacurso;
	}

	public String[] getNombrecurso() {
		return nombrecurso;
	}

	public void setNombrecurso(String[] nombrecurso) {
		this.nombrecurso = nombrecurso;
	}

	public String getNombrecursoexo() {
		return nombrecursoexo;
	}

	public void setNombrecursoexo(String nombrecursoexo) {
		this.nombrecursoexo = nombrecursoexo;
	}

	public String[] getListaseccion() {
		return listaseccion;
	}

	public void setListaseccion(String[] listaseccion) {
		this.listaseccion = listaseccion;
	}

	public static void setOrderList(ArrayList<OrderBean> orderList) {
		MatriculaNormalMB.orderList = orderList;
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
		return listanivel;
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

	public String getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(String idCurso) {
		this.idCurso = idCurso;
	}

	public List<Matriculas> getMatricula() {
		return matricula;
	}

	public void setMatricula(List<Matriculas> matricula) {
		this.matricula = matricula;
	}

	public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}

}
