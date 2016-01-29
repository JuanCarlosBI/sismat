package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Nivel;

public interface NivelDao {

	public Nivel datosNivel(Short idNivel);
	public boolean registroNivel(Nivel nivel);
	public List<Nivel> listaNivel(String codigoColegio, String nivel,String estado);
	public boolean eliminar(Nivel nivel);
	public boolean editar(Nivel editarnivel);

}
