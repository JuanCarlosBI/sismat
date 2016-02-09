package com.juancarlos.sismat.service;

import java.util.Date;
import java.util.List;

import com.juancarlos.sismat.dominio.Empleado;

public interface EmpleadoService {
	public List<Empleado> listaProfesores(String codigoColegio, String dni, String nombre, String apellidos, char estado, char cargo);

	public boolean registroEmpleado(String dni, String nombres,
			String apellidoPaterno, String apellidoMaterno,
			Date fechaNacimiento, char sexo, String direccion, String distrito,
			String celular, String cargo,String codigoColegio);

	public boolean actualizarRegistroEmpleado(String dni, String nombres,
			String apellidoPaterno, String apellidoMaterno,
			Date fechaNacimiento, char sexo, String direccion, String distrito,
			String celular, String cargo,String codigoColegio);
}
