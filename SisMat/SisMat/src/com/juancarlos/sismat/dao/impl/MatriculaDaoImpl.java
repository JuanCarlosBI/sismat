package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.MatriculaDao;

import com.juancarlos.sismat.dominio.Alumnos;

@Repository
public class MatriculaDaoImpl extends HibernateDaoSupport implements MatriculaDao {

	@Autowired
	public MatriculaDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<Alumnos> nombreAlumno(String nombres) {
		List<Alumnos> alumnos = null;

		String sql = "from Alumnos where nombreCompleto like '%" + nombres + "%'";
		try {

			alumnos = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			alumnos = null;
		}

		return alumnos;
	}
	@SuppressWarnings("unchecked")
	public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno) {
		logger.info("en listaAlumnos");
		
		String sql = "";
		List<Alumnos> alumnos = new ArrayList<Alumnos>();

		try {
			sql = "from Alumnos where codigoColegio = '" + codigoColegio.trim()
					+ "' AND idAlumno='" + idAlumno.trim() + "'";

			alumnos = getHibernateTemplate().find(sql);
			

			if (alumnos.isEmpty()) {
				alumnos = new ArrayList<Alumnos>();
			}

		} catch (Exception e) {
			
			alumnos = null;
		}

		return alumnos;
	}

}
