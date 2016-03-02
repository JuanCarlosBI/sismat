package com.juancarlos.sismat.service;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Colegio;
import com.juancarlos.sismat.dominio.Seccion;

public interface ColegioService {
	
	public boolean registroColegio(String razonSocial,String ruc,String correoString ,String direccion,String telefono,String fax,byte[] logo);
	 public List<Colegio> nombreColegio(String nombres);
	 public List<Colegio> listaColegio(String nombreColegio);

		public boolean editar(Colegio editarColegio);
		public byte[] getProductImage(String codigoColegio);
		
}
