package com.juancarlos.sismat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.NivelDao;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.service.NivelService;

@Service
public class NivelServiceImpl implements NivelService {
	@Autowired
	NivelDao nivelDao;
	public boolean registroNivel(String tipo,String grado,String orden, String nroVacantes, char estado, String codigoColegio){
		Nivel nivel = new Nivel();
		System.out.println(tipo);
		System.out.println(grado);
		System.out.println(orden);
		System.out.println(nroVacantes);
		System.out.println(estado);
		nivel.setTipo(tipo);
		nivel.setGrado(grado);
		nivel.setOrden(orden);
		nivel.setNroVacantes(nroVacantes);
		nivel.setEstado(estado);
		nivel.setCodigoColegio(codigoColegio);

		return nivelDao.registroNivel(nivel);
		
		
	}
}
