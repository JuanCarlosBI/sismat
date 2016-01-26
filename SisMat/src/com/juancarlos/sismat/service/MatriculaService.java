package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.MatriculaCurso;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

public interface MatriculaService {
	 public List<Alumnos> nombreAlumno(String nombres);
	 public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno);
		public List<Seccion> listaSeccion(String codigoColegio, String grado,String nivelAcademico);
		public List<Empleado> nombreCoTutor(String idcotutor);
		public List<Empleado> nombreTutor(String idtutor);
		public List<Cursos> listaCurso(String codigoColegio, String grado,String nivelAcademico);
		public List<Seccion> nombreSec(String codigoColegio, String nombreSeccion, String grado,String nivelAcademico);
		public List<Nivel> listaNivel(String codigoColegio);
		public boolean registroMatricula(String idAlumno, Integer idSeccion,
				String periodo, String situacion, String antColegio,String codigoColegio);
		public List<Matriculas> idMatricula(String idAlumno);
		public boolean registroMatriculaCurso(Integer idMatricula,String idCurso,String tipo,String motivo,String codigoColegio);
			
		
}
