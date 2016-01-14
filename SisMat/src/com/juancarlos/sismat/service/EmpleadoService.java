package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Empleado;

public interface EmpleadoService {
	public List<Empleado> listaProfesores(String codigoColegio, String dni, String nombre, String apellidos, char estado, char cargo);
}
