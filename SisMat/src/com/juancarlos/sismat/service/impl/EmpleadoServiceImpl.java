package com.juancarlos.sismat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.EmpleadoDao;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {
	
	@Autowired
	EmpleadoDao empleadoDao;

	public List<Empleado> listaProfesores(String codigoColegio, String dni,
			String nombre, String apellidos,
			char estado, char cargo) {
		
		empleadoDao.listaProfesores(codigoColegio, dni, nombre, apellidos, estado, cargo);
		
		return null;
	}
	
	public boolean registroEmpleado(String dni,String nombres,String apellidoPaterno,String apellidoMaterno, Date fechaNacimiento,char sexo,String direccion,String distrito,String celular,String cargo,String codigoColegio){
		Empleado empleado = new Empleado();
		String apellidos=apellidoPaterno+" "+apellidoMaterno;
		String nombreCompleto=nombres+" "+apellidos;
		empleado.setIdEmpleado(dni);
		empleado.setNombres(nombres);
		empleado.setApellidos(apellidos);
		empleado.setFechaNacimiento(fechaNacimiento);
		empleado.setSexo(sexo);
		empleado.setDireccion(direccion);
		empleado.setDistrito(distrito);
		empleado.setCelular(celular);
		empleado.setCargo(cargo);
		empleado.setNombreCompleto(nombreCompleto);
		empleado.setCodigoColegio(codigoColegio);
			
		return empleadoDao.registroEmpleado(empleado);
	}

	public boolean actualizarRegistroEmpleado(String dni,String nombres,String apellidoPaterno,String apellidoMaterno, Date fechaNacimiento,char sexo,String direccion,String distrito,String celular,String cargo,String codigoColegio){
		
		Empleado empleado = new Empleado();
		String apellidos=apellidoPaterno+" "+apellidoMaterno;
		empleado.setIdEmpleado(dni);
		empleado.setNombres(nombres);
		empleado.setApellidos(apellidos);
		empleado.setFechaNacimiento(fechaNacimiento);
		empleado.setSexo(sexo);
		empleado.setDireccion(direccion);
		empleado.setDistrito(distrito);
		empleado.setCelular(celular);
		empleado.setCargo(cargo);
		empleado.setCodigoColegio(codigoColegio);
		
			
		
		return empleadoDao.actualizarRegistroEmpleado(empleado);
	}


}
