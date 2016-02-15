package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.NivelDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;

@Repository
public class NivelDaoImpl extends HibernateDaoSupport implements NivelDao {

	
	@Autowired
	public NivelDaoImpl(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}

	@Override
	public Nivel datosNivel(Short idNivel) {
		logger.info("en datosCurso()");
		
		return getHibernateTemplate().get(Nivel.class, idNivel);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean registroNivel(Nivel nivel) {
		boolean resultado;
		
		try {
			getHibernateTemplate().save(nivel);	
			getHibernateTemplate().flush();
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}

	public List<Nivel> listaNivel(String codigoColegio, String nivel,String estado){
		logger.info("en listaNivel");
		System.out.println("en listaNivel dao");
	
		String sql = "";
		List<Nivel> listnivel = new ArrayList<Nivel>();

		try {
			if(nivel.length()==0){
				sql = "from Nivel where codigoColegio = '" + codigoColegio.trim()
						 + "' AND estado='"+estado  + "'";

			}else{
				sql = "from Nivel where codigoColegio = '" + codigoColegio.trim()
						 + "' AND nivel='"+nivel + "' AND estado='"+estado  + "'";

			}
			
			listnivel = getHibernateTemplate().find(sql);
			System.out.println("listcurso tamanio " + listnivel.size());

			if (listnivel.isEmpty()) {
				listnivel = new ArrayList<Nivel>();
			}

		} catch (Exception e) {
			System.out.println(e);
			listnivel = null;
		}

		return listnivel;
	
	
	}
	
	
	@Override
	public boolean eliminar(Nivel nivel) {
		boolean resultado;
		
		try {
			getHibernateTemplate().delete(nivel);
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}    
	
	@Override
	public boolean editar(Nivel editarnivel) {
		boolean resultado;
		
		try {
			getHibernateTemplate().update(editarnivel);
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}  
	
}
