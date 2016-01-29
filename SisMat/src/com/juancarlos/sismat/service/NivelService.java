package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;

public interface NivelService {
	public boolean registroNivel(String tipo,String nivel, String orden, String nroVacantes, String estado,String codigoColegio);
	public List<Nivel> listaNivel(String codigoColegio, String nivel,String estado);
	public boolean eliminar(Nivel nivel);
	public boolean editar(Nivel editarnivel);

}
