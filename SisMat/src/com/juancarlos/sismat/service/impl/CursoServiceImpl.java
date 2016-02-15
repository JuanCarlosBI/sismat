package com.juancarlos.sismat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.CursoDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {
	@Autowired
	CursoDao cursoDao;
	public boolean registroCurso(String nombre, String grado,
			String nivelAcademico, String area, String estado,String codigoColegio){
		Cursos curso = new Cursos();
		curso.setArea(area);
		curso.setEstado(estado);
		curso.setGrado(grado);
		curso.setNivelAcademico(nivelAcademico);
		curso.setNombre(nombre);
		curso.setCodigoColegio(codigoColegio);
		
		
		return cursoDao.registroCurso(curso);
		

	}
	public List<Nivel> listaNivel(String codigoColegio) {
		List<Nivel> nivel = cursoDao.listaNivel(codigoColegio);
		return nivel;
	}
	
	 public List<Cursos> nombreCurso(String nombcurso){
		 
		 return cursoDao.nombreCurso(nombcurso);
	 }
		public List<Cursos> listaCurso(String codigoColegio, String nombcurso,String nivelAcademico,String estado){
			
			List<Cursos> curso = cursoDao.listaCurso(codigoColegio,
					nombcurso,nivelAcademico,estado);
			return curso;
		}

		public boolean eliminar(Cursos curso){
			return cursoDao.eliminar(curso);
		}
		public boolean editar(Cursos editarcurso){
			return cursoDao.editar(editarcurso);
		}
}

