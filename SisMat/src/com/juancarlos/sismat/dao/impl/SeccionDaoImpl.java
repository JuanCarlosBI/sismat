package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
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
import com.juancarlos.sismat.dominio.Nivel;
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
    @SuppressWarnings("unchecked")
    public String nombreTutor(String idtutor){
        List<Empleado> empleados=null;
        Empleado empleado;
        String nombreTutor;
 
        String sql = " from Empleado where idEmpleado='"+idtutor+"'";
        try {
 
            empleados = getHibernateTemplate().find(sql);
            empleado=empleados.get(0);
            nombreTutor=empleado.getNombreCompleto();
            
           
        } catch (Exception e) {
            nombreTutor = null;
        }
       
        return nombreTutor;
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

    

	@Override
	public boolean eliminar(Seccion seccion) {
		boolean resultado;
		
		try {
			getHibernateTemplate().delete(seccion);
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}    
	
	@Override
	public boolean editar(Seccion editarseccion) {
		boolean resultado;
		
		try {
			getHibernateTemplate().update(editarseccion);
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
	public List<Nivel> listaNivel(String codigoColegio) {
		logger.info("en listaSeccion");
	
		String sql = "";
		List<Nivel> nivel = new ArrayList<Nivel>();

		try {
			sql = "from Nivel where codigoColegio = '" + codigoColegio.trim()
					 +  "'";

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
	@SuppressWarnings("unchecked")
	public List<Seccion> listaSeccion(String codigoColegio, String grado,String nivelAcademico) {
		logger.info("en listaSeccion");
	
		String sql = "";
		List<Seccion> seccion = new ArrayList<Seccion>();

		try {
			if(grado.length()==0 && nivelAcademico.length()==0 ){
				sql = "from Seccion where codigoColegio = '" + codigoColegio.trim() + "'";

			}
			if(grado.length()!=0 && nivelAcademico.length()!=0 ){
				sql = "from Seccion where codigoColegio = '" + codigoColegio.trim()
						 + "' AND grado='"+grado + "' AND nivelAcademico='" + nivelAcademico + "'";

			}
			if(grado.length()==0 && nivelAcademico.length()!=0 ){
				sql = "from Seccion where codigoColegio = '" + codigoColegio.trim()
						+ "' AND nivelAcademico='" + nivelAcademico + "'";

			}
			if(grado.length()!=0 && nivelAcademico.length()==0 ){
				sql = "from Seccion where codigoColegio = '" + codigoColegio.trim()
						+ "' AND grado='"+grado + "'";

			}
				
			
			seccion = getHibernateTemplate().find(sql);

			if (seccion.isEmpty()) {
				seccion = new ArrayList<Seccion>();
			}

		} catch (Exception e) {
			seccion = null;
		}

		return seccion;
	}
	public List<Empleado> listaProfesores(String codigoColegio) {

		logger.info("en listaEmpleado");

		String sql = "";
		List<Empleado> empleado = new ArrayList<Empleado>();

		try {
			sql = "from Empleado where codigoColegio = '"
					+ codigoColegio.trim()  + "'";

			empleado = getHibernateTemplate().find(sql);

			if (empleado.isEmpty()) {
				empleado = new ArrayList<Empleado>();
			}

		} catch (Exception e) {
			empleado = null;
		}

		return empleado;

	}
	
	
}

