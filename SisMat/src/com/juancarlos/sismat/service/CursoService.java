package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Nivel;

public interface CursoService {

	public boolean registroCurso(String nombre, String grado,
			String nivelAcademico, String area, char estado,String codigoColegio);
	public List<Nivel> listaNivel(String codigoColegio);
}
