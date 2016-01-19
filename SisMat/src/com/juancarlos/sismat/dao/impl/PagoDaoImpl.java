package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.PagoDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Pagos;

@Repository
public class PagoDaoImpl extends HibernateDaoSupport implements PagoDao {

	@Autowired
	public PagoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<Alumnos> idAlumno(String idAlumno) {
		List<Alumnos> alumnos = null;

		String sql = "from Alumnos where idAlumno like '%" + idAlumno + "%'";
		try {

			alumnos = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			System.out.println(e);
			alumnos = null;
		}

		return alumnos;
	}

	@SuppressWarnings("unchecked")
	public Pagos encontrarPago(Short idPago) {
		List<Pagos> pagos;
		Pagos pago = new Pagos();
		String sql = "";
		try {
			sql = "from Pagos where IdPago='" + idPago + "'";
			pagos = getHibernateTemplate().find(sql);

			if (!pagos.isEmpty()) {
				if (pagos.size() == 1) {
					pago = pagos.get(0);
				}
			} else {
				pago = null;
			}

		} catch (Exception e) {
			pago = null;
		}

		return pago;
	}

	@SuppressWarnings("unchecked")
	public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno) {
		logger.info("en listaAlumnos");
		System.out.println("en listaAlumnos dao");
		String sql = "";
		List<Alumnos> alumnos = new ArrayList<Alumnos>();

		try {
			sql = "from Alumnos where codigoColegio = '" + codigoColegio.trim()
					+ "' AND idAlumno='" + idAlumno.trim() + "'";

			alumnos = getHibernateTemplate().find(sql);
			System.out.println("alumnos tamanio " + alumnos.size());

			if (alumnos.isEmpty()) {
				alumnos = new ArrayList<Alumnos>();
			}

		} catch (Exception e) {
			System.out.println(e);
			alumnos = null;
		}

		return alumnos;
	}

	@SuppressWarnings("unchecked")
	public List<Matriculas> listaMatricula(String codigoColegio, String idAlumno) {
		logger.info("en listaMatricula");
		System.out.println("en listaMatricula dao");
		String sql = "";
		List<Matriculas> matriculas = new ArrayList<Matriculas>();

		try {
			sql = "from Matriculas where idAlumno='" + idAlumno.trim() + "'";

			matriculas = getHibernateTemplate().find(sql);
			System.out.println("matricula tamanio " + matriculas.size());

			if (matriculas.isEmpty()) {
				matriculas = new ArrayList<Matriculas>();
			}

		} catch (Exception e) {
			System.out.println(e);
			matriculas = null;
		}

		return matriculas;
	}

	@SuppressWarnings("unchecked")
	public List<Nivel> listaNivel(String idNivel) {
		logger.info("en listaMatricula");
		System.out.println("en listaMatricula dao");
		String sql = "";
		List<Nivel> nivel = new ArrayList<Nivel>();

		try {
			sql = "from Nivel where idNivel='" + idNivel.trim() + "'";

			nivel = getHibernateTemplate().find(sql);
			System.out.println("nivel tamanio " + nivel.size());

			if (nivel.isEmpty()) {
				nivel = new ArrayList<Nivel>();
			}

		} catch (Exception e) {
			System.out.println(e);
			nivel = null;
		}

		return nivel;
	}

	@SuppressWarnings("unchecked")
	public List<Pagos> listaPago(Integer idMatricula) {
		logger.info("en listaPago");
		System.out.println("en listaPagos dao");
		String sql = "";
		List<Pagos> pagos = new ArrayList<Pagos>();

		try {
			sql = "from Pagos where idMatricula='" + idMatricula + "'";

			pagos = getHibernateTemplate().find(sql);
			System.out.println("pagos tamanio " + pagos.size());

			if (pagos.isEmpty()) {
				pagos = new ArrayList<Pagos>();
			}

		} catch (Exception e) {
			System.out.println(e);
			pagos = null;
		}

		return pagos;
	}
	
	@Override
	public boolean registroPago(Pagos pago) {
		boolean resultado;
		
		try {
			getHibernateTemplate().save(pago);	
			getHibernateTemplate().flush();
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}
}
