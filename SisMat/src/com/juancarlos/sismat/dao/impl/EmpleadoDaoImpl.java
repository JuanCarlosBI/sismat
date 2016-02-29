package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.EmpleadoDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Colegio;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;

@Repository
public class EmpleadoDaoImpl extends HibernateDaoSupport implements EmpleadoDao {

	@Autowired
	public EmpleadoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public Empleado datosEmpleado(String idEmpleado) {
		logger.info("en datosEmpleado()");

		return getHibernateTemplate().get(Empleado.class, idEmpleado);
	}

	public List<Empleado> listaProfesores(String codigoColegio, String dni,
			String nombre, String apellidos, String estado) {

		logger.info("en listaEmpleado");

		String sql = "";
		List<Empleado> empleado = new ArrayList<Empleado>();

		try {
			if (dni.length() == 0 && nombre.length() == 0
					&& apellidos.length() == 0 && estado.length() == 0) {
				
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "'";
			}
			if (dni.length() != 0 && nombre.length() != 0
					&& apellidos.length() != 0 && estado.length() != 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND idEmpleado='" + dni
						+ "' AND nombres='" + nombre + "' AND apellidos='"
						+ apellidos + "' AND estado='" + estado + "'";
			}
			if (dni.length() != 0 && nombre.length() == 0
					&& apellidos.length() == 0 && estado.length() == 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND idEmpleado='" + dni
						+ "'";
			}
			if (dni.length() == 0 && nombre.length() != 0
					&& apellidos.length() == 0 && estado.length() == 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nombres='" + nombre
						+ "'";
			}
			if (dni.length() == 0 && nombre.length() == 0
					&& apellidos.length() != 0 && estado.length() == 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND apellidos='"
						+ apellidos + "'";
			}
			if (dni.length() == 0 && nombre.length() == 0
					&& apellidos.length() == 0 && estado.length() != 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND estado='" + estado
						+ "'";
			}
			if (dni.length() == 0 && nombre.length() != 0
					&& apellidos.length() != 0 && estado.length() != 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nombres='" + nombre
						+ "' AND apellidos='" + apellidos + "' AND estado='"
						+ estado + "'";
			}
			if (dni.length() == 0 && nombre.length() != 0
					&& apellidos.length() != 0 && estado.length() == 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nombres='" + nombre
						+ "' AND apellidos='" + apellidos + "'";
			}
			if (dni.length() != 0 && nombre.length() != 0
					&& apellidos.length() != 0 && estado.length() == 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND idEmpleado='" + dni
						+ "' AND nombres='" + nombre + "' AND apellidos='"
						+ apellidos + "'";
			}
			if (dni.length() == 0 && nombre.length() != 0
					&& apellidos.length() == 0 && estado.length() != 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nombres='" + nombre
						+ "' AND estado='" + estado + "'";
			}
			if (dni.length() == 0 && nombre.length() == 0
					&& apellidos.length() != 0 && estado.length() != 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND apellidos='"
						+ apellidos + "' AND estado='" + estado + "'";
			}
			if (dni.length() != 0 && nombre.length() == 0
					&& apellidos.length() == 0 && estado.length() != 0) {
				sql = "from Empleado where codigoColegio = '"
						+ codigoColegio.trim() + "' AND idEmpleado='" + dni
						+ "' AND estado='" + estado + "'";
			}

			empleado = getHibernateTemplate().find(sql);

			if (empleado.isEmpty()) {
				empleado = new ArrayList<Empleado>();
			}

		} catch (Exception e) {
			empleado = null;
		}

		return empleado;

	}

	public boolean registroEmpleado(Empleado empleado) {
		boolean resultado;

		try {
			getHibernateTemplate().save(empleado);
			getHibernateTemplate().flush();
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

	@Override
	public boolean editar(Empleado editarEmpleado) {
		boolean resultado;

		try {
			getHibernateTemplate().update(editarEmpleado);
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

}
