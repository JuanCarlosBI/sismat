package com.juancarlos.sismat.service.impl;

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

}
