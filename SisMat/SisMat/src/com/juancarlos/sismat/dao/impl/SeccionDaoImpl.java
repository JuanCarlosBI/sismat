package com.juancarlos.sismat.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.CursoDao;
import com.juancarlos.sismat.dao.SeccionDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Seccion;

@Repository
public class SeccionDaoImpl extends HibernateDaoSupport implements SeccionDao {
    Session ayudar;
    Transaction operacion;
    Query consulta;
    
    @Autowired
	public SeccionDaoImpl(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
    
    @Override
	public Seccion datosSeccion(Short idSeccion) {
		logger.info("en datosCurso()");
		
		return getHibernateTemplate().get(Seccion.class, idSeccion);
		// TODO Auto-generated method stub
		
	}
    
    

	@Override
	public boolean registroSeccion(Seccion seccion) {
		boolean resultado;
		
		try {
			getHibernateTemplate().save(seccion);	
			getHibernateTemplate().flush();
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}

    
    
    @SuppressWarnings("unchecked")
      public List<Empleado> nombreEmpleado(String nombreProfesor){
          List<Empleado> empleados=null;
   
          String sql = "from Empleado where nombreCompleto like '%"+nombreProfesor+"%'";
          try {
   
              empleados = getHibernateTemplate().find(sql);          
             
          } catch (Exception e) {
              empleados = null;
          }
         
          return empleados;
      }

	@SuppressWarnings("unchecked")
	public Seccion encontrarSeccion(Short idSeccion){
		List<Seccion> secciones;
		Seccion seccion = new Seccion();
		String sql="";
		try {
			sql = "from Seccion where IdSeccion='"+idSeccion+"'";
			secciones = getHibernateTemplate().find(sql);
			
			if(!secciones.isEmpty()){
				if(secciones.size() == 1){
					seccion = secciones.get(0);
				}
			}
			else{
				seccion = null;
			}
			
		} catch (Exception e) {
			seccion = null;
		}
		
		return seccion;
	}
    
}

