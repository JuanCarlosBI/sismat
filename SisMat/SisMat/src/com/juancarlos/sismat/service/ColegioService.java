package com.juancarlos.sismat.service;

public interface ColegioService {
	
	public boolean registroColegio(String razonSocial,String ruc,String correoString ,String direccion,String telefono,String fax);
	public boolean actualizarRegistroColegio(String razonSocial,String ruc,String correoString ,String direccion,String telefono,String fax);

}
