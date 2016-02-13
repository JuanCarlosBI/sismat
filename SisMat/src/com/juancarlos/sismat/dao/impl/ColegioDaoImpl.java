package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.ColegioDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Colegio;
import com.juancarlos.sismat.dominio.Seccion;

@Repository
public class ColegioDaoImpl extends HibernateDaoSupport implements ColegioDao {

	@Autowired
	public ColegioDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public boolean registroColegio(Colegio colegio) {
		boolean resultado;

		try {
			getHibernateTemplate().save(colegio);
			getHibernateTemplate().flush();
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

	public boolean actualizarRegistroColegio(Colegio colegio) {
		boolean resultado;
		boolean eliminado;

		try {
			eliminado = eliminaColegio(colegio.getCodigoColegio());

			if (eliminado) {
				getHibernateTemplate().update(colegio);
				getHibernateTemplate().flush();
				resultado = true;
			} else {
				resultado = false;
			}
		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

	public boolean eliminaColegio(String codigo) {
		boolean resultado;

		Colegio colegio = encontrarColegio(codigo);

		if (!(colegio == null)) {
			try {
				getHibernateTemplate().delete(colegio);
				resultado = true;
			} catch (Exception e) {
				resultado = false;
			}
		} else {
			resultado = false;
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public Colegio encontrarColegio(String codigo) {
		List<Colegio> colegios;
		Colegio colegio = new Colegio();
		String sql = "";
		try {
			sql = "from Colegio where codigoColegio='" + codigo + "'";
			colegios = getHibernateTemplate().find(sql);

			if (!colegios.isEmpty()) {
				if (colegios.size() == 1) {
					colegio = colegios.get(0);
				}
			} else {
				colegio = null;
			}

		} catch (Exception e) {
			colegio = null;
		}

		return colegio;
	}

	@SuppressWarnings("unchecked")
	public List<Colegio> nombreColegio(String nombres) {
		List<Colegio> colegios = null;

		String sql = "from Colegio where razonSocial like '%" + nombres + "%'";
		try {

			colegios = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			System.out.println(e);
			colegios = null;
		}

		return colegios;
	}

	@SuppressWarnings("unchecked")
	public List<Colegio> listaColegio(String codigoColegio) {
		logger.info("en listaAlumnos");
		System.out.println("en listaAlumnos dao");
		String sql = "";
		List<Colegio> listacolegio = new ArrayList<Colegio>();

		try {
			sql = "from Colegio where codigoColegio = '" + codigoColegio.trim()
					+ "'";

			listacolegio = getHibernateTemplate().find(sql);
			System.out.println("listacolegio tamanio " + listacolegio.size());

			if (listacolegio.isEmpty()) {
				listacolegio = new ArrayList<Colegio>();
			}

		} catch (Exception e) {
			System.out.println(e);
			listacolegio = null;
		}

		return listacolegio;
	}

	
	@Override
	public boolean editar(Colegio editarColegio) {
		boolean resultado;
		
		try {
			getHibernateTemplate().update(editarColegio);
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}  
}
