package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;

public interface CursoDao {

	public Cursos datosCurso(Short idCurso);
	public boolean registroCurso(Cursos curso);

	public List<Nivel> listaNivel(String codigoColegio);
	 public List<Cursos> nombreCurso(String nombcurso);
	 public List<Cursos> listaCurso(String codigoColegio, String nombcurso,String nivelAcademico,char estado);
		public boolean eliminar(Cursos curso);
		public boolean editar(Cursos editarcurso);

	
}
