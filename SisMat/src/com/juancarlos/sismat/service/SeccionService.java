package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Nivel;
public interface SeccionService {
	 public List<Empleado> nombreEmpleado(String nombres);

		public boolean registroSeccion(String idTutor,String idCoTutor, String grado,
				String nivelAcademico, String seccion, String nroVacantes,
				String nroAula, String periodo,String codigoColegio);
		public List<Nivel> listaNivel(String codigoColegio);
}
