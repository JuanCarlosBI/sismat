package com.juancarlos.sismat.dao;

import com.juancarlos.sismat.dominio.Colegio;

public interface ColegioDao {

	public boolean registroColegio(Colegio colegio);
	public boolean actualizarRegistroColegio(Colegio colegio);
}
