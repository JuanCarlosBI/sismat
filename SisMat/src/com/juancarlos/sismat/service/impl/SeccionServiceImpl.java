package com.juancarlos.sismat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.SeccionDao;

import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.service.SeccionService;

@Service
public class SeccionServiceImpl implements SeccionService {
	@Autowired
	SeccionDao seccionDao;

	public List<Empleado> nombreEmpleado(String nombres) {
		// TODO Auto-generated method stub
		return seccionDao.nombreEmpleado(nombres);
	}

	public boolean registroSeccion(String idTutor, String idCoTutor,
			String grado, String nivelAcademico, String seccion,
			String nroVacantes, String nroAula, String periodo,
			String codigoColegio) {

		Seccion secciones = new Seccion();
		secciones.setIdTutor(idTutor);
		secciones.setIdCoTutor(idCoTutor);
		secciones.setGrado(grado);
		secciones.setNivelAcademico(nivelAcademico);
		secciones.setSeccion(seccion);
		secciones.setNroVacantes(nroVacantes);
		secciones.setNroAula(nroAula);
		secciones.setPeriodo(periodo);
		secciones.setCodigoColegio(codigoColegio);

		return seccionDao.registroSeccion(secciones);

	}

	public List<Nivel> listaNivel(String codigoColegio) {
		List<Nivel> nivel = seccionDao.listaNivel(codigoColegio);
		return nivel;
	}

	public List<Seccion> listaSeccion(String codigoColegio, String grado,
			String nivelAcademico) {
		List<Seccion> seccion = seccionDao.listaSeccion(codigoColegio, grado,nivelAcademico);
		return seccion;
	}

	public boolean eliminar(Seccion seccion) {
		return seccionDao.eliminar(seccion);
	}

	public boolean editar(Seccion editarseccion) {
		return seccionDao.editar(editarseccion);
	}

	public String nombreTutor(String idtutor) {
		String tutor = seccionDao.nombreTutor(idtutor);
		return tutor;
	}

	public List<Empleado> listaProfesores(String codigoColegio) {

		List<Empleado> empleados = seccionDao.listaProfesores(codigoColegio);

		return empleados;
	}
}
