package com.juancarlos.sismat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.CursoDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	CursoDao cursoDao;
	public boolean registroCurso(String nombre, String grado,
			String nivelAcademico, String area, char estado){
		Cursos curso = new Cursos();
		curso.setArea(area);
		curso.setEstado(estado);
		curso.setGrado(grado);
		curso.setNivelAcademico(nivelAcademico);
		curso.setNombre(nombre);
		
		
		return cursoDao.registroCurso(curso);
		

	}
}

