package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import com.juancarlos.sismat.dao.HorarioDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Horarios;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

@Repository
public class HorarioDaoImpl extends HibernateDaoSupport implements HorarioDao {

	@Autowired
	public HorarioDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<Seccion> listaSeccion(String codigoColegio, String grado,
			String nivelAcademico) {
		logger.info("en listaSeccion");

		String sql = "";
		List<Seccion> seccion = new ArrayList<Seccion>();

		try {
			sql = "from Seccion where codigoColegio = '" + codigoColegio.trim()
					+ "' AND grado='" + grado + "' AND nivelAcademico='"
					+ nivelAcademico + "'";

			seccion = getHibernateTemplate().find(sql);

			if (seccion.isEmpty()) {
				seccion = new ArrayList<Seccion>();
			}

		} catch (Exception e) {
			seccion = null;
		}

		return seccion;
	}

	@SuppressWarnings("unchecked")
	public List<Nivel> listaNivel(String codigoColegio) {
		logger.info("en listaNivel");

		String sql = "";
		List<Nivel> nivel = new ArrayList<Nivel>();

		try {
			sql = "from Nivel where codigoColegio = '" + codigoColegio.trim()
					+ "'";

			nivel = getHibernateTemplate().find(sql);

			if (nivel.isEmpty()) {
				nivel = new ArrayList<Nivel>();
			}

		} catch (Exception e) {
			nivel = null;
		}

		return nivel;
	}

	@SuppressWarnings("unchecked")
	public List<Cursos> listaCurso(String codigoColegio, String grado,
			String nivelAcademico) {
		logger.info("en listaCurso");
		String sql = "";
		List<Cursos> curso = new ArrayList<Cursos>();

		try {
			sql = "from Cursos where codigoColegio = '" + codigoColegio.trim()
					+ "' AND grado='" + grado + "' AND nivelAcademico='"
					+ nivelAcademico + "'";

			curso = getHibernateTemplate().find(sql);

			if (curso.isEmpty()) {
				curso = new ArrayList<Cursos>();
			}

		} catch (Exception e) {
			curso = null;
		}

		return curso;
	}

	public List<Empleado> listaProfesores(String codigoColegio) {

		logger.info("en listaEmpleado");

		String sql = "";
		List<Empleado> empleado = new ArrayList<Empleado>();

		try {
			sql = "from Empleado where codigoColegio = '"
					+ codigoColegio.trim() + "'";

			empleado = getHibernateTemplate().find(sql);

			if (empleado.isEmpty()) {
				empleado = new ArrayList<Empleado>();
			}

		} catch (Exception e) {
			empleado = null;
		}

		return empleado;

	}

	@Override
	public boolean registroHorario(Horarios horario) {
		boolean resultado;

		try {
			getHibernateTemplate().save(horario);
			getHibernateTemplate().flush();
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Horarios> horarios(String codigoColegio, String nombreSeccion,
			String grado, String nivelAcademico, String dia) {
		logger.info("en listaSeccion");

		String sql = "";
		List<Horarios> horario = new ArrayList<Horarios>();

		try {
			if (nombreSeccion.length() == 0 && grado.length() == 0
					&& nivelAcademico.length() == 0 && dia.length() == 0) {
				sql = "from Horarios where codigoColegio = '" + "'";

			}
			if (nombreSeccion.length() != 0 && grado.length() != 0
					&& nivelAcademico.length() != 0 && dia.length() != 0) {
				sql = "from Horarios where codigoColegio = '"
						+ codigoColegio.trim() + "' AND seccion='"
						+ nombreSeccion + "' AND grado='" + grado
						+ "' AND nivelAcademico='" + nivelAcademico
						+ "' AND dia='" + dia + "'";
			}
			if (nombreSeccion.length() != 0 && grado.length() != 0
					&& nivelAcademico.length() != 0 && dia.length() == 0) {
				sql = "from Horarios where codigoColegio = '"
						+ codigoColegio.trim() + "' AND seccion='"
						+ nombreSeccion + "' AND grado='" + grado
						+ "' AND nivelAcademico='" + nivelAcademico
						+  "'";
			}
			if (nombreSeccion.length() == 0 && grado.length() != 0
					&& nivelAcademico.length() == 0 && dia.length() == 0) {
				sql = "from Horarios where codigoColegio = '"
						+ codigoColegio.trim() +  "' AND grado='" + grado
						+ "'";
			}

			if (nombreSeccion.length() == 0 && grado.length() == 0
					&& nivelAcademico.length() != 0 && dia.length() != 0) {
				sql = "from Horarios where codigoColegio = '"
						+ codigoColegio.trim()
						+ "' AND nivelAcademico='" + nivelAcademico
						+ "' AND dia='" + dia + "'";
			}
			if (nombreSeccion.length() == 0 && grado.length() == 0
					&& nivelAcademico.length() == 0 && dia.length() != 0) {
				sql = "from Horarios where codigoColegio = '"
						+ codigoColegio.trim() 
						+ "' AND dia='" + dia + "'";
			}
			if (nombreSeccion.length() == 0 && grado.length() == 0
					&& nivelAcademico.length() != 0 && dia.length() == 0) {
				sql = "from Horarios where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nivelAcademico='" + nivelAcademico
						 + "'";
			}
			if (nombreSeccion.length() == 0 && grado.length() != 0
					&& nivelAcademico.length() != 0 && dia.length() == 0) {
				sql = "from Horarios where codigoColegio = '"
						+ codigoColegio.trim() +  "' AND grado='" + grado+ "' AND nivelAcademico='" + nivelAcademico
						 + "'";
			}
			
			horario = getHibernateTemplate().find(sql);

			if (horario.isEmpty()) {
				horario = new ArrayList<Horarios>();
			}

		} catch (Exception e) {
			horario = null;
		}

		return horario;
	}

}
