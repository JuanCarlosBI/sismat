package com.juancarlos.sismat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.MatriculaDao;
import com.juancarlos.sismat.dao.PagoDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.MatriculaCurso;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	@Autowired
	MatriculaDao matriculaDao;

	public List<Alumnos> nombreAlumno(String nombres) {
		// TODO Auto-generated method stub
		return matriculaDao.nombreAlumno(nombres);
	}

	public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno) {
		

		List<Alumnos> alumnos = matriculaDao.listaAlumnos(codigoColegio,
				idAlumno);

		return alumnos;
	}

	public List<Seccion> listaSeccion(String codigoColegio, 
			String grado,String nivelAcademico) {
		List<Seccion> seccion = matriculaDao.listaSeccion(codigoColegio,
				grado,nivelAcademico);
		return seccion;
	}
	public List<Seccion> nombreSec(String codigoColegio, String nombreSeccion, String grado,String nivelAcademico) {
		List<Seccion> nombseccion = matriculaDao.nombreSec(codigoColegio, nombreSeccion,grado,nivelAcademico);
		return nombseccion;
	}

	public List<Empleado> nombreCoTutor(String idcotutor) {
		List<Empleado> cotutor = matriculaDao.nombreCoTutor(idcotutor);
		return cotutor;
	}

	public List<Empleado> nombreTutor(String idtutor) {
		List<Empleado> tutor = matriculaDao.nombreTutor(idtutor);
		return tutor;
	}

	public List<Cursos> listaCurso(String codigoColegio,String grado,String nivelAcademico) {
		List<Cursos> curso = matriculaDao.listaCurso(codigoColegio,grado,nivelAcademico);
		return curso;
	}
	public List<Nivel> listaNivel(String codigoColegio) {
		List<Nivel> nivel = matriculaDao.listaNivel(codigoColegio);
		return nivel;
	}

	public boolean registroMatricula(String idAlumno, Integer idSeccion,
			String periodo, String situacion, String antColegio,String codigoColegio,String fecha,String hora){
		Matriculas matricula = new Matriculas();
		
		String estado="Activo";
		matricula.setIdAlumno(idAlumno);
		matricula.setIdSeccion(idSeccion);
		matricula.setPeriodo(periodo);
		matricula.setSituacion(situacion);
		matricula.setAntcolegio(antColegio);
		matricula.setCodigoColegio(codigoColegio);
		matricula.setFecha(fecha);
		matricula.setHora(hora);
		matricula.setEstado(estado);
		
		return matriculaDao.registroMatricula(matricula);
		

	}


	public List<Matriculas> idMatricula(String idAlumno) {
		List<Matriculas> idMatricula = matriculaDao.idMatricula(idAlumno);
		return idMatricula;
	}

	public boolean registroMatriculaCurso(Integer idMatricula,String idCurso,String tipo,String motivo,String codigoColegio){
		
		MatriculaCurso matriculacurso=new MatriculaCurso();
		matriculacurso.setIdCurso(idCurso);
		matriculacurso.setIdMatricula(idMatricula);
		matriculacurso.setMotivo(motivo);
		matriculacurso.setTipo(tipo);
		matriculacurso.setCodigoColegio(codigoColegio);
		return matriculaDao.registroMatriculaCurso(matriculacurso);
	}
	public List<Matriculas> listaMatricula(String codigoColegio, String dni,String estado){
		List<Matriculas> matriculas = matriculaDao.listaMatricula(codigoColegio,
				dni,estado);
		return matriculas;
	
	}
	
	public List<Seccion> nombreSeccion(String codigoColegio, int idSeccion) {
		List<Seccion> nseccion = matriculaDao.nombreSeccion(codigoColegio, idSeccion);
		return nseccion;
	}
}
