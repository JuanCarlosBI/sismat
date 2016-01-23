package com.juancarlos.sismat.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.NivelDao;
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

	
	@SuppressWarnings("unchecked")
	public Nivel encontrarNivel(Short idNivel){
		List<Nivel> niveles;
		Nivel nivel = new Nivel();
		String sql="";
		try {
			sql = "from Pruebas where IdCurso='"+idNivel+"'";
			niveles = getHibernateTemplate().find(sql);
			
			if(!niveles.isEmpty()){
				if(niveles.size() == 1){
					nivel = niveles.get(0);
				}
			}
			else{
				nivel = null;
			}
			
		} catch (Exception e) {
			nivel = null;
		}
		
		return nivel;
	}
}
