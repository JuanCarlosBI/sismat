package com.juancarlos.sismat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.MatriculaDao;
import com.juancarlos.sismat.dao.PagoDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.service.MatriculaService;

@Service
public class MatriculaServiceImpl implements MatriculaService {
	@Autowired
	MatriculaDao matriculaDao;

	public List<Alumnos> nombreAlumno(String nombres) {
		// TODO Auto-generated method stub
		return matriculaDao.nombreAlumno(nombres);
	}
	public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno) {
		

		List<Alumnos> alumnos = matriculaDao.listaAlumnos(codigoColegio, idAlumno);

		return alumnos;
	}
}
