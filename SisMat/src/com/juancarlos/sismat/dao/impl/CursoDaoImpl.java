package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.CursoDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

@Repository
public class CursoDaoImpl extends HibernateDaoSupport implements CursoDao {

	@Autowired
	public CursoDaoImpl(SessionFactory sessionFactory) {
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
	public List<Nivel> listaNivel(String codigoColegio) {
		logger.info("en listaSeccion");

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
	public List<Cursos> nombreCurso(String nombcurso) {
		List<Cursos> cursos = null;

		String sql = "from Cursos where nombre like '%" + nombcurso + "%'";
		try {

			cursos = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			cursos = null;
		}

		return cursos;
	}

	public List<Cursos> listaCurso(String codigoColegio, String nombcurso,
			String nivelAcademico, String estado) {
		logger.info("en listaCursos");

		String sql = "";
		List<Cursos> listcurso = new ArrayList<Cursos>();

		try {
			if (nombcurso.length() == 0 && nivelAcademico.length() == 0
					&& estado.length() == 0) {
				sql = "from Cursos where codigoColegio = '"
						+ codigoColegio.trim() + "'";

			}
			if (nombcurso.length() != 0 && nivelAcademico.length() == 0
					&& estado.length() == 0) {
				sql = "from Cursos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nombre='" + nombcurso
						+ "'";

			}
			if (nombcurso.length() == 0 && nivelAcademico.length() != 0
					&& estado.length() != 0) {
				sql = "from Cursos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nivelAcademico='"
						+ nivelAcademico + "' AND estado='" + estado + "'";

			}
			if (nombcurso.length() == 0 && nivelAcademico.length() == 0
					&& estado.length() != 0) {
				sql = "from Cursos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND estado='" + estado
						+ "'";

			}
			if (nombcurso.length() != 0 && nivelAcademico.length() != 0
					&& estado.length() != 0) {
				sql = "from Cursos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nombre='" + nombcurso
						+ "' AND nivelAcademico='" + nivelAcademico
						+ "' AND estado='" + estado + "'";

			}
			if (nombcurso.length() == 0 && nivelAcademico.length() != 0
					&& estado.length() == 0) {
				
				sql = "from Cursos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nivelAcademico='"
						+ nivelAcademico + "'";

			}

			listcurso = getHibernateTemplate().find(sql);

			if (listcurso.isEmpty()) {
				listcurso = new ArrayList<Cursos>();
			}

		} catch (Exception e) {
			listcurso = null;
		}

		return listcurso;

	}

	@Override
	public boolean eliminar(Cursos curso) {
		boolean resultado;

		try {
			getHibernateTemplate().delete(curso);
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

	@Override
	public boolean editar(Cursos editarcurso) {
		boolean resultado;

		try {
			getHibernateTemplate().update(editarcurso);
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

}
