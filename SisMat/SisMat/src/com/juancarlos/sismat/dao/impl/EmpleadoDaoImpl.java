package com.juancarlos.sismat.dao.impl;

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
import com.juancarlos.sismat.dominio.Empleado;

@Repository
public class EmpleadoDaoImpl extends HibernateDaoSupport implements EmpleadoDao {

	@Autowired
	public EmpleadoDaoImpl(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	public Empleado datosEmpleado(String idEmpleado) {
		logger.info("en datosEmpleado()");
		
		return getHibernateTemplate().get(Empleado.class, idEmpleado);
	}

	
	public boolean guardarEmpleado(Empleado empleado) {
		
		return false;
	}

	
	public boolean eliminaEmpleado(String idEmpleado) {
		boolean resultado = false;
		
		Colegio colegio = new Colegio(); //encontrar(idEmpleado);
		
		if(!(colegio == null)){				
			try {
				getHibernateTemplate().delete(colegio);
				resultado = true;
			} catch (Exception e) {
				resultado = false;
			}				
		}
//		else{
//			resultado = false;
//		}
	
		
		return false;
	}

	
	public boolean eliminaEmpleado(Empleado empleado) {
		
		return false;
	}

	
	public List<Empleado> listaProfesores(String codigoColegio, String dni,
			String nombre, String apellidos,
			char estado, char cargo) {
		
//		getSession().createCriteria(Empleado.class).add(Restrictions.or(Restrictions.eq("codigoColegio", codigoColegio), null));
		
		if(dni.length()==0 && nombre.length()==0 && apellidos.length()==0 && estado == ' ' && cargo == ' '){
			
		}
		
		return null;
	}

	public boolean actualizarRegistroEmpleado(Empleado empleado) {
		boolean resultado;
		boolean eliminado;
		
		try {	
			eliminado = eliminaEmpleado(empleado.getIdEmpleado());
			
			if(eliminado){
				getHibernateTemplate().update(empleado);	
				getHibernateTemplate().flush();
				resultado = true;
			}
			else{
				resultado = false;
			}			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;	
	}

	public boolean registroEmpleado(Empleado empleado){
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

}
