

package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Colegio;

public interface ColegioDao {

	public boolean registroColegio(Colegio colegio);
	public boolean actualizarRegistroColegio(Colegio colegio);
	public List<Colegio> nombreColegio(String nombres);
	public List<Colegio> listaColegio(String nombreColegio) ;
	public boolean editar(Colegio editarColegio);
	public byte[] getProductImage(String codigoColegio);
}
