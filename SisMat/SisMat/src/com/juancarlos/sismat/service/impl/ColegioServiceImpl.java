package com.juancarlos.sismat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.ColegioDao;
import com.juancarlos.sismat.dominio.Colegio;
import com.juancarlos.sismat.service.ColegioService;

@Service
public class ColegioServiceImpl implements ColegioService {

	@Autowired
	ColegioDao colegioDao;
	
	public boolean registroColegio(String razonSocial,String ruc,String correo ,String direccion,String telefono,String fax) {
		
		Colegio colegio = new Colegio();
		
		colegio.setCodigoColegio(ruc);
		colegio.setRazonSocial(razonSocial);
		colegio.setCorreo(correo);
		colegio.setDireccion(direccion);
		colegio.setTelefono(telefono);
		colegio.setFax(fax);
		
		return colegioDao.registroColegio(colegio);
	}

	public boolean actualizarRegistroColegio(String razonSocial,String ruc,String correo ,String direccion,String telefono,String fax) {
		
		Colegio colegio = new Colegio();
		
		colegio.setCodigoColegio(ruc);
		colegio.setRazonSocial(razonSocial);
		colegio.setCorreo(correo);
		colegio.setDireccion(direccion);
		colegio.setTelefono(telefono);
		colegio.setFax(fax);
		
		return colegioDao.actualizarRegistroColegio(colegio);
	}
}
