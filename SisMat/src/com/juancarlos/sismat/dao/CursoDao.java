package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;

public interface CursoDao {

	public Cursos datosCurso(Short idCurso);
	public boolean registroCurso(Cursos curso);

	public List<Nivel> listaNivel(String codigoColegio);
}
