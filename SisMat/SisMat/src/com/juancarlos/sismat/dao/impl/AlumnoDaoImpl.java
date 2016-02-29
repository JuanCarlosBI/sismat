package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.AlumnoDao;
import com.juancarlos.sismat.dominio.Alumnos;

@Repository
public class AlumnoDaoImpl extends HibernateDaoSupport implements AlumnoDao {

	@Autowired
	public AlumnoDaoImpl(SessionFactory sessionFactory){
		setSessionFactory(sessionFactory);
	}
	
	public Alumnos datosAlumno(String idAlumno) {
		logger.info("en datosAlumno()");
		
		return getHibernateTemplate().get(Alumnos.class, idAlumno);
	}

	

	public boolean registroAlumno(Alumnos alumno){
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
	public Alumnos encontrarAlumno(String string){
		List<Alumnos> alumnos;
		Alumnos alumno = new Alumnos();
		String sql="";
		try {
			sql = "from Alumnos where IdAlumno='"+string+"'";
			alumnos = getHibernateTemplate().find(sql);
			
			if(!alumnos.isEmpty()){
				if(alumnos.size() == 1){
					alumno = alumnos.get(0);
				}
			}
			else{
				alumno = null;
			}
			
		} catch (Exception e) {
			alumno = null;
		}
		
		return alumno;
	}


	@SuppressWarnings("unchecked")
	public List<Alumnos> listaAlumnos(String codigoColegio, String dni, String nombre, String apellidoPaterno,String apellidoMaterno, char estado) {	
		logger.info("en listaAlumnos");
		String sql = "";
		List<Alumnos> alumnos = new ArrayList<Alumnos>();		
			 
		 try {
			 
			 if(dni.length()==0 && nombre.length()==0 && apellidoPaterno.length()==0 && apellidoMaterno.length()==0 && estado == ' '){
				 
				 sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'";				  
			 }
			 if(dni.length()!=0 && nombre.length()==0 && apellidoPaterno.length()==0 && apellidoMaterno.length()==0 && estado == ' '){
				
				 sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"' AND dni='"+dni.trim()+"'";
			 }
			 if(dni.length()==0 && nombre.length()!=0 && apellidoPaterno.length()==0 && apellidoMaterno.length()==0 && estado == ' '){
				 
				 sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND nombres='"+nombre.trim()+"'";			 
			 }
			 if(dni.length()==0 && nombre.length()==0 && apellidoPaterno.length()!=0 && apellidoMaterno.length()==0 && estado == ' '){
				 
				 sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'OR nombres='"+nombre.trim()+"' AND apellidoPaterno='"+apellidoPaterno.trim()+"'";
			 }
			 if(dni.length()==0 && nombre.length()==0 && apellidoPaterno.length()==0 && apellidoMaterno.length()!=0 && estado == ' '){
				
				 sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND apellidoMaterno='"+apellidoMaterno.trim()+"'";
			 }
			if(dni.length()==0 && nombre.length()==0 && apellidoPaterno.length()==0 && apellidoMaterno.length()==0 && estado != ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND estado='"+estado+"'";			 
			}
			if(dni.length()!=0 && nombre.length()!=0 && apellidoPaterno.length()==0 && apellidoMaterno.length()==0 && estado == ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND nombres='"+nombre.trim()+"'AND dni='"+dni.trim()+"'"; 
			}
			if(dni.length()!=0 && nombre.length()==0 && apellidoPaterno.length()!=0 && apellidoMaterno.length()==0 && estado == ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND apellidoPaterno='"+apellidoPaterno.trim()+"' AND dni='"+dni.trim()+"'"; 
			}
			if(dni.length()!=0 && nombre.length()==0 && apellidoPaterno.length()==0 && apellidoMaterno.length()!=0 && estado == ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"' AND apellidoMaterno='"+apellidoMaterno.trim()+"' AND dni='"+dni.trim()+"'"; 
			}
			if(dni.length()!=0 && nombre.length()==0 && apellidoPaterno.length()==0 && apellidoMaterno.length()==0 && estado != ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"' AND dni='"+dni.trim()+"' AND estado='"+estado+"'"; 
			}
			if(dni.length()!=0 && nombre.length()!=0 && apellidoPaterno.length()!=0 && apellidoMaterno.length()==0 && estado == ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND nombres='"+nombre.trim()+"' AND apellidoPaterno='"+apellidoPaterno.trim()+"' AND dni='"+dni.trim()+"'"; 
			}
			if(dni.length()!=0 && nombre.length()!=0 && apellidoPaterno.length()==0 && apellidoMaterno.length()!=0 && estado == ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND nombres='"+nombre.trim()+"' AND apellidoMaterno='"+apellidoMaterno.trim()+"' AND dni='"+dni.trim()+"'"; 
			 }
			if(dni.length()!=0 && nombre.length()!=0 && apellidoPaterno.length()==0 && apellidoMaterno.length()==0 && estado != ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND nombres='"+nombre.trim()+"' AND dni='"+dni.trim()+"' AND estado='"+estado+"'"; 
			 }
			if(dni.length()!=0 && nombre.length()!=0 && apellidoPaterno.length()!=0 && apellidoMaterno.length()!=0 && estado == ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND nombres='"+nombre.trim()+"' AND apellidoPaterno='"+apellidoPaterno.trim()+"' AND apellidoMaterno='"+apellidoMaterno.trim()+"' AND dni='"+dni.trim()+"'"; 
			 }
			if(dni.length()!=0 && nombre.length()!=0 && apellidoPaterno.length()!=0 && apellidoMaterno.length()==0 && estado != ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND nombres='"+nombre.trim()+"' AND apellidoPaterno='"+apellidoPaterno.trim()+"' AND dni='"+dni.trim()+"' AND estado='"+estado+"'"; 
			 }
			if(dni.length()!=0 && nombre.length()!=0 && apellidoPaterno.length()!=0 && apellidoMaterno.length()!=0 && estado != ' '){
				
				sql = "from Alumnos where codigoColegio = '"+codigoColegio.trim()+"'AND nombres='"+nombre.trim()+"' AND apellidoPaterno='"+apellidoPaterno.trim()+"' AND apellidoMaterno='"+apellidoMaterno.trim()+"' AND dni='"+dni.trim()+"' AND estado='"+estado+"'";
		     }
			  
			 
			 alumnos =  getHibernateTemplate().find(sql);
			 
			 if(alumnos.isEmpty()){
				 alumnos = new ArrayList<Alumnos>(); 
			 }
			 
		} catch (Exception e) {
			alumnos = null;
		}
		
		return alumnos;
	}



}

