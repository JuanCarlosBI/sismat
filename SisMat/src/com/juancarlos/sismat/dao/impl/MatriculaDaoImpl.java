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
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Seccion;

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
			System.out.println(e);
			alumnos = null;
		}

		return alumnos;
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
	public List<Seccion> listaSeccion(String codigoColegio, String grado,String nivelAcademico) {
		logger.info("en listaSeccion");
		System.out.println("en listaSeccion dao");
	
		System.out.println(grado);
		String sql = "";
		List<Seccion> seccion = new ArrayList<Seccion>();

		try {
			sql = "from Seccion where codigoColegio = '" + codigoColegio.trim()
					 + "' AND grado='"+grado + "' AND nivelAcademico='" + nivelAcademico + "'";

			seccion = getHibernateTemplate().find(sql);
			System.out.println("seccion tamanio " + seccion.size());

			if (seccion.isEmpty()) {
				seccion = new ArrayList<Seccion>();
			}

		} catch (Exception e) {
			System.out.println(e);
			seccion = null;
		}

		return seccion;
	}
	@SuppressWarnings("unchecked")
	public List<Seccion> nombreSec(String codigoColegio, String nombreSeccion, String grado,String nivelAcademico) {
		logger.info("en listaSeccion");
		System.out.println("en listaSeccion dao");
	
		String sql = "";
		List<Seccion> seccion = new ArrayList<Seccion>();

		try {
			sql = "from Seccion where codigoColegio = '" + codigoColegio.trim()
					 + "' AND seccion='"+nombreSeccion + "' AND grado='"+grado + "' AND nivelAcademico='" + nivelAcademico + "'";

			seccion = getHibernateTemplate().find(sql);
			System.out.println("lista seccion tamanio " + seccion.size());

			if (seccion.isEmpty()) {
				seccion = new ArrayList<Seccion>();
			}

		} catch (Exception e) {
			System.out.println(e);
			seccion = null;
		}

		return seccion;
	}
	
	@SuppressWarnings("unchecked")
    public List<Empleado> nombreTutor(String idtutor){
        List<Empleado> empleados=null;
 
        String sql = " from Empleado where idEmpleado like '%"+idtutor+"%'";
        try {
 
            empleados = getHibernateTemplate().find(sql);          
           
        } catch (Exception e) {
            System.out.println(e);
            empleados = null;
        }
       
        return empleados;
    }

	@SuppressWarnings("unchecked")
    public List<Empleado> nombreCoTutor(String idcotutor){
        List<Empleado> empleados=null;
 
        String sql = "from Empleado where idEmpleado like '%"+idcotutor+"%'";
        try {
 
            empleados = getHibernateTemplate().find(sql);          
           
        } catch (Exception e) {
            System.out.println(e);
            empleados = null;
        }
       
        return empleados;
    }

	@SuppressWarnings("unchecked")
	public List<Cursos> listaCurso(String codigoColegio,String grado,String nivelAcademico) {
		logger.info("en listaCurso");
		System.out.println("en listaCurso dao");
		String sql = "";
		List<Cursos> curso = new ArrayList<Cursos>();

		try {
			sql = "from Cursos where codigoColegio = '" + codigoColegio.trim()
				 + "' AND grado='"+grado + "' AND nivelAcademico='" + nivelAcademico + "'";

			curso = getHibernateTemplate().find(sql);
			System.out.println("curso tamanio " + curso.size());

			if (curso.isEmpty()) {
				curso = new ArrayList<Cursos>();
			}

		} catch (Exception e) {
			System.out.println(e);
			curso = null;
		}

		return curso;
	}


	@SuppressWarnings("unchecked")
	public List<Nivel> listaNivel(String codigoColegio) {
		logger.info("en listaNivel");
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

}
