package com.juancarlos.sismat.dao;

import com.juancarlos.sismat.dominio.Cursos;

public interface CursoDao {

	public Cursos datosCurso(Short idCurso);
	public boolean registroCurso(Cursos curso);
}
