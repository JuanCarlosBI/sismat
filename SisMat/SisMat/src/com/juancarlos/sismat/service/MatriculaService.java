package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;

public interface MatriculaService {
	 public List<Alumnos> nombreAlumno(String nombres);
	 public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno);
		
}
