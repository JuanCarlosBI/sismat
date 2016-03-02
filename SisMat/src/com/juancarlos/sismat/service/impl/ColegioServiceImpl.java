package com.juancarlos.sismat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.ColegioDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Colegio;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.ColegioService;

@Service
public class ColegioServiceImpl implements ColegioService {

	@Autowired
	ColegioDao colegioDao;
	
	public boolean registroColegio(String razonSocial,String ruc,String correo ,String direccion,String telefono,String fax,byte[] logo) {
		
		Colegio colegio = new Colegio();
		
		colegio.setCodigoColegio(ruc);
		colegio.setRazonSocial(razonSocial);
		colegio.setCorreo(correo);
		colegio.setDireccion(direccion);
		colegio.setTelefono(telefono);
		colegio.setFax(fax);
		colegio.setLogo(logo);
		
		return colegioDao.registroColegio(colegio);
	}


	public List<Colegio> nombreColegio(String nombres) {
		// TODO Auto-generated method stub
		return colegioDao.nombreColegio(nombres);
	}
	public List<Colegio> listaColegio(String nombreColegio) {
		
		List<Colegio> colegios = colegioDao.listaColegio(nombreColegio);

		return colegios;
	}

	public byte[] getProductImage(String codigoColegio){
		byte[] productImage =colegioDao.getProductImage(codigoColegio);
		return productImage ;
	}
	
	public boolean editar(Colegio editarColegio){
		return colegioDao.editar(editarColegio);
	}
}
