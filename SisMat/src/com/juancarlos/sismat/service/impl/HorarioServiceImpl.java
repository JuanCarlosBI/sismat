package com.juancarlos.sismat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.juancarlos.sismat.dao.HorarioDao;
import com.juancarlos.sismat.dao.MatriculaDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Horarios;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {
	@Autowired
	HorarioDao horarioDao;

	public List<Seccion> listaSeccion(String codigoColegio, 
			String grado,String nivelAcademico) {
		List<Seccion> seccion = horarioDao.listaSeccion(codigoColegio,
				grado,nivelAcademico);
		return seccion;
	}
	public List<Nivel> listaNivel(String codigoColegio) {
		List<Nivel> nivel = horarioDao.listaNivel(codigoColegio);
		return nivel;
	}
	public List<Cursos> listaCurso(String codigoColegio,String grado,String nivelAcademico) {
		List<Cursos> curso = horarioDao.listaCurso(codigoColegio,grado,nivelAcademico);
		return curso;
	}
	public List<Empleado> listaProfesores(String codigoColegio) {
		
		List<Empleado> empleados=horarioDao.listaProfesores(codigoColegio);
		
		return empleados;
	}
	
	
	public boolean registroHorario(String curso, String empleado,
			String horaIni, String horaFin, String seccion,String nroAula,String dia,String grado,String nivel,String codigoColegio){
		Horarios horario = new Horarios();
		horario.setCodigoColegio(codigoColegio);
		horario.setDia(dia);
		horario.setGrado(grado);
		horario.setHoraFin(horaFin);
		horario.setHoraIni(horaIni);
		horario.setCurso(curso);
		horario.setEmpleado(empleado);
		horario.setNivelAcademico(nivel);
		horario.setNroAula(nroAula);
		horario.setSeccion(seccion);
		return horarioDao.registroHorario(horario);
		

	}
	public List<Horarios> horarios(String codigoColegio, String nombreSeccion, String grado,String nivelAcademico,String dia) {
		List<Horarios> horario = horarioDao.horarios(codigoColegio, nombreSeccion, grado, nivelAcademico,dia);
		return horario;
	}	
}
