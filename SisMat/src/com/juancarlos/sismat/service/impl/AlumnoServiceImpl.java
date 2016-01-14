package com.juancarlos.sismat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.AlumnoDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.service.AlumnoService;


@Service
public class AlumnoServiceImpl implements AlumnoService {

	@Autowired
	AlumnoDao alumnoDao;
	
	public List<Alumnos> listaAlumnos(String codigoColegio, String dni, String nombre, String apellidoPaterno,String apellidoMaterno, char estado) {
		System.out.println("en listaAlumnos service");
		
		List<Alumnos> alumnos = alumnoDao.listaAlumnos(codigoColegio, dni, nombre,  apellidoPaterno,apellidoMaterno, estado);
		
//		if(!(alumnos==null)){
//			int fila = 0;
//			while(fila < alumnos.size()){
//				alumnos.get(fila).setId(fila+1);
//			}
//		}
//	
		return alumnos;
	}

}
