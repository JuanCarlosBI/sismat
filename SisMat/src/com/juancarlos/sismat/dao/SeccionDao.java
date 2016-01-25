package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

public interface SeccionDao {
	public  List<Empleado> nombreEmpleado(String nombres);

	public Seccion datosSeccion(Short idSeccion);
	public boolean registroSeccion(Seccion seccion);
	public List<Nivel> listaNivel(String codigoColegio);
}
