package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

public interface CursoService {

	public boolean registroCurso(String nombre, String grado,
			String nivelAcademico, String area, String estado,
			String codigoColegio);

	public List<Nivel> listaNivel(String codigoColegio);

	public List<Cursos> nombreCurso(String nombcurso);

	public List<Cursos> listaCurso(String codigoColegio, String nombcurso,
			String nivelAcademico, String estado);

	public boolean eliminar(Cursos curso);

	public boolean editar(Cursos editarcurso);

}
