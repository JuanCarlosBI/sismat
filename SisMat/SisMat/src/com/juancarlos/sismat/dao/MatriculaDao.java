package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;

public interface MatriculaDao {
	public  List<Alumnos> nombreAlumno(String nombres);
	public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno);

}
