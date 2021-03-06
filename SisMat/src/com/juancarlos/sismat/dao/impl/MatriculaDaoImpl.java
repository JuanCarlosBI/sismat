package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.MatriculaDao;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.MatriculaCurso;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

@Repository
public class MatriculaDaoImpl extends HibernateDaoSupport implements
		MatriculaDao {

	@Autowired
	public MatriculaDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	@SuppressWarnings("unchecked")
	public List<Alumnos> nombreAlumno(String nombres) {
		List<Alumnos> alumnos = null;

		String sql = "from Alumnos where nombreCompleto like '%" + nombres
				+ "%'";
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
					+ "' AND dni='" + idAlumno.trim() + "'";

			alumnos = getHibernateTemplate().find(sql);
			

			if (alumnos.isEmpty()) {
				alumnos = new ArrayList<Alumnos>();
			}

		} catch (Exception e) {
			
			alumnos = null;
		}

		return alumnos;
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
	public List<Seccion> nombreSec(String codigoColegio, String nombreSeccion,
			String grado, String nivelAcademico) {
		logger.info("en listaSeccion");
		

		String sql = "";
		List<Seccion> seccion = new ArrayList<Seccion>();

		try {
			sql = "from Seccion where codigoColegio = '" + codigoColegio.trim()
					+ "' AND seccion='" + nombreSeccion + "' AND grado='"
					+ grado + "' AND nivelAcademico='" + nivelAcademico + "'";

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
	public List<Empleado> nombreTutor(String idtutor) {
		List<Empleado> empleados = null;

		String sql = " from Empleado where idEmpleado like '%" + idtutor + "%'";
		try {

			empleados = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			
			empleados = null;
		}

		return empleados;
	}

	@SuppressWarnings("unchecked")
	public List<Empleado> nombreCoTutor(String idcotutor) {
		List<Empleado> empleados = null;

		String sql = "from Empleado where idEmpleado like '%" + idcotutor
				+ "%'";
		try {

			empleados = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			
			empleados = null;
		}

		return empleados;
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

	@Override
	public boolean registroMatricula(Matriculas matricula) {
		boolean resultado;

		try {
			getHibernateTemplate().save(matricula);
			getHibernateTemplate().flush();
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

	@Override
	public boolean registroMatriculaCurso(MatriculaCurso matriculacurso) {
		boolean resultado;

		try {
			getHibernateTemplate().save(matriculacurso);
			getHibernateTemplate().flush();
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public List<Matriculas> idMatricula(String idAlumno) {
		logger.info("en idMatricula");
		

		String sql = "";
		List<Matriculas> matriculas = new ArrayList<Matriculas>();

		try {
			sql = "from Matriculas where idAlumno = '" + idAlumno.trim() + "'";

			matriculas = getHibernateTemplate().find(sql);

			if (matriculas.isEmpty()) {
				matriculas = new ArrayList<Matriculas>();
			}

		} catch (Exception e) {
			
			matriculas = null;
		}

		return matriculas;
	}

	public List<Matriculas> listaMatricula(String codigoColegio, String dni,
			String estado) {
		logger.info("en listaMatricula");
		String sql = "";
		List<Matriculas> listaMatricula = new ArrayList<Matriculas>();

		try {
			if (dni.length() == 0 && estado.length() == 0) {
				sql = "from Matriculas where codigoColegio = '"
						+ codigoColegio.trim() + "'";

			}
			if (dni.length() != 0 && estado.length() == 0) {
				sql = "from Matriculas where codigoColegio = '"
						+ codigoColegio.trim() + "' AND idAlumno='" + dni + "'";

			}
			if (dni.length() == 0 && estado.length() != 0) {
				sql = "from Matriculas where codigoColegio = '"
						+ codigoColegio.trim() + "' AND estado='" + estado
						+ "'";

			}
			if (dni.length() != 0 && estado.length() != 0) {
				sql = "from Matriculas where codigoColegio = '"
						+ codigoColegio.trim() +"' AND idAlumno='" + dni + "' AND estado='" + estado
						+ "'";

			}

			listaMatricula = getHibernateTemplate().find(sql);
			

			if (listaMatricula.isEmpty()) {
				listaMatricula = new ArrayList<Matriculas>();
			}

		} catch (Exception e) {
			listaMatricula = null;
		}

		return listaMatricula;

	}

	@SuppressWarnings("unchecked")
	public List<Seccion> nombreSeccion(String codigoColegio, int idSeccion) {
		logger.info("en listaSeccion");

		String sql = "";
		List<Seccion> nombseccion = new ArrayList<Seccion>();

		try {
			sql = "from Seccion where codigoColegio = '" + codigoColegio.trim()
					+ "' AND idSeccion='" + idSeccion + "'";

			nombseccion = getHibernateTemplate().find(sql);

			if (nombseccion.isEmpty()) {
				nombseccion = new ArrayList<Seccion>();
			}

		} catch (Exception e) {
			nombseccion = null;
		}

		return nombseccion;
	}

}
