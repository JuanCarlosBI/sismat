package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;

public interface AlumnoDao {
	public List<Alumnos> listaAlumnos(String codigoColegio, String dni, String nombre, String apellidoPaterno,String apellidoMaterno, String estado);

	public Alumnos datosAlumno(String idAlumno);
	public boolean registroAlumno(Alumnos alumnno);
	public boolean editar(Alumnos editarAlumno);
}