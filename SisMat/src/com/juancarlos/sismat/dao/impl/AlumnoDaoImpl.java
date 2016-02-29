package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.AlumnoDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Nivel;

@Repository
public class AlumnoDaoImpl extends HibernateDaoSupport implements AlumnoDao {

	@Autowired
	public AlumnoDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	public Alumnos datosAlumno(String idAlumno) {
		logger.info("en datosAlumno()");

		return getHibernateTemplate().get(Alumnos.class, idAlumno);
	}

	public boolean registroAlumno(Alumnos alumno) {
		boolean resultado;

		try {
			getHibernateTemplate().save(alumno);
			getHibernateTemplate().flush();
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

	@SuppressWarnings("unchecked")
	public Alumnos encontrarAlumno(String string) {
		List<Alumnos> alumnos;
		Alumnos alumno = new Alumnos();
		String sql = "";
		try {
			sql = "from Alumnos where IdAlumno='" + string + "'";
			alumnos = getHibernateTemplate().find(sql);

			if (!alumnos.isEmpty()) {
				if (alumnos.size() == 1) {
					alumno = alumnos.get(0);
				}
			} else {
				alumno = null;
			}

		} catch (Exception e) {
			alumno = null;
		}

		return alumno;
	}

	@SuppressWarnings("unchecked")
	public List<Alumnos> listaAlumnos(String codigoColegio, String dni,
			String nombre, String apellidoPaterno, String apellidoMaterno,
			String estado) {
		logger.info("en listaAlumnos");
		String sql = "";
		List<Alumnos> alumnos = new ArrayList<Alumnos>();

		try {

			// sql =
			// "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'";

			if (dni.length() == 0 && nombre.length() == 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() == 0 && estado.length() == 0) {
				System.out.println("1");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'";
			}
			if (dni.length() != 0 && nombre.length() == 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() == 0 && estado.length() == 0) {
				System.out.println("2");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND dni='" + dni.trim()
						+ "'";
			}
			if (dni.length() == 0 && nombre.length() == 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() == 0 && estado.length() != 0) {
				System.out.println("3");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND estado='"
						+ estado.trim() + "'";
			}
			if (dni.length() == 0 && nombre.length() != 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() == 0 && estado.length() == 0) {
				System.out.println("4");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND nombres='"
						+ nombre.trim() + "'";
			}
			if (dni.length() == 0 && nombre.length() == 0
					&& apellidoPaterno.length() != 0
					&& apellidoMaterno.length() == 0 && estado.length() == 0) {
				System.out.println("5");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND apellidoPaterno='"
						+ apellidoPaterno.trim() + "'";
			}
			if (dni.length() == 0 && nombre.length() == 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() != 0 && estado.length() == 0) {
				System.out.println("6");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND apellidoMaterno='"
						+ apellidoMaterno.trim() + "'";
			}

			if (dni.length() != 0 && nombre.length() != 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() == 0 && estado.length() == 0) {
				System.out.println("7");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND nombres='"
						+ nombre.trim() + "'AND dni='" + dni.trim() + "'";
			}
			if (dni.length() != 0 && nombre.length() == 0
					&& apellidoPaterno.length() != 0
					&& apellidoMaterno.length() == 0 && estado.length() == 0) {
				System.out.println("8");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND apellidoPaterno='"
						+ apellidoPaterno.trim() + "' AND dni='" + dni.trim()
						+ "'";
			}
			if (dni.length() != 0 && nombre.length() == 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() != 0 && estado.length() == 0) {
				System.out.println("9");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND apellidoMaterno='"
						+ apellidoMaterno.trim() + "' AND dni='" + dni.trim()
						+ "'";
			}

			if (dni.length() != 0 && nombre.length() != 0
					&& apellidoPaterno.length() != 0
					&& apellidoMaterno.length() == 0 && estado.length() == 0) {
				System.out.println("11");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND nombres='"
						+ nombre.trim() + "' AND apellidoPaterno='"
						+ apellidoPaterno.trim() + "' AND dni='" + dni.trim()
						+ "'";
			}
			if (dni.length() != 0 && nombre.length() != 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() != 0 && estado.length() == 0) {
				System.out.println("12");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND nombres='"
						+ nombre.trim() + "' AND apellidoMaterno='"
						+ apellidoMaterno.trim() + "' AND dni='" + dni.trim()
						+ "'";
			}
			if (dni.length() != 0 && nombre.length() != 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() == 0 && estado.length() == 0) {
				System.out.println("13");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND nombres='"
						+ nombre.trim() + "' AND dni='" + dni.trim()
						+ "' AND estado='" + estado + "'";
			}
			if (dni.length() != 0 && nombre.length() != 0
					&& apellidoPaterno.length() != 0
					&& apellidoMaterno.length() != 0 && estado.length() != 0) {
				System.out.println("14");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND nombres='"
						+ nombre.trim() + "' AND apellidoPaterno='"
						+ apellidoPaterno.trim() + "' AND apellidoMaterno='"
						+ apellidoMaterno.trim() + "' AND dni='" + dni.trim()
						+ "'";
			}
			if (dni.length() != 0 && nombre.length() != 0
					&& apellidoPaterno.length() != 0
					&& apellidoMaterno.length() == 0 && estado.length() != 0) {
				System.out.println("15");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND nombres='"
						+ nombre.trim() + "' AND apellidoPaterno='"
						+ apellidoPaterno.trim() + "' AND dni='" + dni.trim()
						+ "' AND estado='" + estado + "'";
			}
			if (dni.length() != 0 && nombre.length() != 0
					&& apellidoPaterno.length() != 0
					&& apellidoMaterno.length() != 0 && estado.length() != 0) {
				System.out.println("16");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "'AND nombres='"
						+ nombre.trim() + "' AND apellidoPaterno='"
						+ apellidoPaterno.trim() + "' AND apellidoMaterno='"
						+ apellidoMaterno.trim() + "' AND dni='" + dni.trim()
						+ "' AND estado='" + estado + "'";
			}
			if (dni.length() != 0 && nombre.length() == 0
					&& apellidoPaterno.length() == 0
					&& apellidoMaterno.length() == 0 && estado.length() != 0) {
				System.out.println("17");
				sql = "from Alumnos where codigoColegio = '"
						+ codigoColegio.trim() + "' AND dni='" + dni.trim()
						+ "' AND estado='" + estado + "'";
			}

			alumnos = getHibernateTemplate().find(sql);

			if (alumnos.isEmpty()) {
				alumnos = new ArrayList<Alumnos>();
			}

		} catch (Exception e) {
			alumnos = null;
		}

		return alumnos;
	}

	@Override
	public boolean editar(Alumnos editarAlumno) {
		boolean resultado;

		try {
			getHibernateTemplate().update(editarAlumno);
			resultado = true;

		} catch (Exception e) {
			resultado = false;
		}

		return resultado;
	}

}
