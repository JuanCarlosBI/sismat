package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Empleado;

public interface EmpleadoDao {

	public Empleado datosEmpleado(String idEmpleado);
	public boolean registroEmpleado(Empleado empleado);
	public boolean actualizarRegistroEmpleado(Empleado empleado);
	public boolean eliminaEmpleado(Empleado empleado);
	public List<Empleado> listaProfesores(String codigoColegio, String dni, String nombre, String apellidos, char estado, char cargo);

	public boolean guardarEmpleado(Empleado empleado);

	
}

