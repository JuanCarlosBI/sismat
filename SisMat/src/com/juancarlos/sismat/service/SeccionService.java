package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;
public interface SeccionService {
	 public List<Empleado> nombreEmpleado(String nombres);

		public boolean registroSeccion(String idTutor,String idCoTutor, String grado,
				String nivelAcademico, String seccion, String nroVacantes,
				String nroAula, String periodo,String codigoColegio);
		public List<Nivel> listaNivel(String codigoColegio);
		public List<Seccion> listaSeccion(String codigoColegio, String grado,String nivelAcademico);
		public boolean eliminar(Seccion seccion);
		public boolean editar(Seccion editarseccion);
		public String nombreTutor(String idtutor);
		List<Empleado> listaProfesores(String codigoColegio);
}
