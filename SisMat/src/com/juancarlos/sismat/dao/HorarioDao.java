package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Horarios;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

public interface HorarioDao {
	public List<Nivel> listaNivel(String codigoColegio);
	public List<Seccion> listaSeccion(String codigoColegio, String grado,String nivelAcademico);
	public List<Cursos> listaCurso(String codigoColegio,String grado,String nivelAcademico) ;
	public List<Empleado> listaProfesores(String codigoColegio);
	public boolean registroHorario(Horarios horario);
	public List<Horarios> horarios(String codigoColegio, String nombreSeccion, String grado,String nivelAcademico,String dia);
		
}
