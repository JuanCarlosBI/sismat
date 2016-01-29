package com.juancarlos.sismat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.NivelDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.service.NivelService;

@Service
public class NivelServiceImpl implements NivelService {
	@Autowired
	NivelDao nivelDao;
	public boolean registroNivel(String tipo,String nivel,String orden, String nroVacantes, String estado, String codigoColegio){
		
		Nivel niveles = new Nivel();
		String nivelAcademico=tipo+"-"+orden+"°-"+nivel;
		System.out.println(tipo);
		System.out.println(nivelAcademico);
		System.out.println(orden);
		System.out.println(nroVacantes);
		System.out.println(estado);
		niveles.setTipo(tipo);
		niveles.setNivel(nivel);
		niveles.setNivelAcademico(nivelAcademico);
		niveles.setOrden(orden);
		niveles.setNroVacantes(nroVacantes);
		niveles.setEstado(estado);
		
		niveles.setCodigoColegio(codigoColegio);

		return nivelDao.registroNivel(niveles);
		
		
	}
	public List<Nivel> listaNivel(String codigoColegio, String nivel,String estado){
		
		List<Nivel> listanivel=nivelDao.listaNivel(codigoColegio,nivel,estado);
		return listanivel;
	}
	public boolean eliminar(Nivel nivel){
		return nivelDao.eliminar(nivel);
	}
	public boolean editar(Nivel editarnivel){
		return nivelDao.editar(editarnivel);
	}
}
