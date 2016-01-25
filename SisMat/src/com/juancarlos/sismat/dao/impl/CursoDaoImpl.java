package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.CursoDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;

@Repository
public class CursoDaoImpl extends HibernateDaoSupport implements CursoDao {

	@Autowired
	public CursoDaoImpl(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}

	@Override
	public Cursos datosCurso(Short idCurso) {
		logger.info("en datosCurso()");
		
		return getHibernateTemplate().get(Cursos.class, idCurso);
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean registroCurso(Cursos curso) {
		boolean resultado;
		
		try {
			getHibernateTemplate().save(curso);	
			getHibernateTemplate().flush();
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}

	
	@SuppressWarnings("unchecked")
	public Cursos encontrarCurso(Short idCurso){
		List<Cursos> cursos;
		Cursos curso = new Cursos();
		String sql="";
		try {
			sql = "from Pruebas where IdCurso='"+idCurso+"'";
			cursos = getHibernateTemplate().find(sql);
			
			if(!cursos.isEmpty()){
				if(cursos.size() == 1){
					curso = cursos.get(0);
				}
			}
			else{
				curso = null;
			}
			
		} catch (Exception e) {
			curso = null;
		}
		
		return curso;
	}

	@SuppressWarnings("unchecked")
	public List<Nivel> listaNivel(String codigoColegio) {
		logger.info("en listaSeccion");
		System.out.println("en listaSeccion dao");
	
		String sql = "";
		List<Nivel> nivel = new ArrayList<Nivel>();

		try {
			sql = "from Nivel where codigoColegio = '" + codigoColegio.trim()
					 +  "'";

			nivel = getHibernateTemplate().find(sql);
			System.out.println("seccion tamanio " + nivel.size());

			if (nivel.isEmpty()) {
				nivel = new ArrayList<Nivel>();
			}

		} catch (Exception e) {
			System.out.println(e);
			nivel = null;
		}

		return nivel;
	}


}
