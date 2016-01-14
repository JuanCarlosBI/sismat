package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;

public interface AlumnoService {

	public List<Alumnos> listaAlumnos(String codigoColegio, String dni, String nombre, String apellidoPaterno,String apellidoMaterno, char estado);
}
