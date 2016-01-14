package com.juancarlos.sismat.dao;

import com.juancarlos.sismat.dominio.Nivel;

public interface NivelDao {

	public Nivel datosNivel(Short idNivel);
	public boolean registroNivel(Nivel nivel);
}
