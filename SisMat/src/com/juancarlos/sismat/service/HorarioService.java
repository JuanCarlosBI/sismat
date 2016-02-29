package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Horarios;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

public interface HorarioService {
	public List<Nivel> listaNivel(String codigoColegio);
	public List<Seccion> listaSeccion(String codigoColegio, String grado,String nivelAcademico);
	public List<Cursos> listaCurso(String codigoColegio, String grado,String nivelAcademico);
	public List<Empleado> listaProfesores(String codigoColegio);
	public boolean registroHorario(String curso, String empleado,
			String horaIni, String horaFin, String seccion,String nroAula,String dia,String grado,String nivel,String codigoColegio);
	public List<Horarios> horarios(String codigoColegio, String nombreSeccion, String grado,String nivelAcademico,String dia);
		
}
