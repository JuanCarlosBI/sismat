package com.juancarlos.sismat.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.EmpleadoDao;
import com.juancarlos.sismat.dao.UsuarioDao;
import com.juancarlos.sismat.dominio.Cursos;
import com.juancarlos.sismat.dominio.Empleado;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Usuario;

@Repository
public class UsuarioDaoImpl extends HibernateDaoSupport implements  UsuarioDao {
	
	@Autowired
	EmpleadoDao empleadoDao;

	@Autowired
	public UsuarioDaoImpl(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}
	
	@SuppressWarnings("unchecked")
	public boolean iniciaSession(String nombreUsuario, String clave) {
		logger.info("en iniciaSession");
		String sql = "";
		List<Usuario> usuarios;
		boolean sesion = false;
		
		 sql = "from Usuario where nombreUsuario = '"+nombreUsuario.trim()+"' and clave = '"+clave.trim()+"'";
		
		 usuarios =  getHibernateTemplate().find(sql);
		
		 if(!usuarios.isEmpty()){
			 if(usuarios.size() == 1){
				 sesion = true;
			 }			 
		 }
		
		return sesion;
	}
	
	public List<Usuario> listaUsuario(String codigoColegio, String idUsuario){
		logger.info("en listaUsuario");
		System.out.println("en listaUsuario dao");
	
		String sql = "";
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		try {
			sql = "from Usuario where codigoColegio = '" + codigoColegio.trim()
					 + "' AND idUsuario='"+idUsuario  + "'";

			listaUsuario = getHibernateTemplate().find(sql);
			System.out.println("listcurso tamanio " + listaUsuario.size());

			if (listaUsuario.isEmpty()) {
				listaUsuario = new ArrayList<Usuario>();
			}

		} catch (Exception e) {
			System.out.println(e);
			listaUsuario = null;
		}

		return listaUsuario;
	
	
	}

	
	@SuppressWarnings("unchecked")
	public Empleado datosUsuario(String nombreUsuario, String clave) {
		
		logger.info("en datosEmpleado");
		String sql = "";
		List<Usuario> usuarios;
		String idEmpleado;
		Empleado empleado = null;
		
		
		 sql = "from Usuario where nombreUsuario = '"+nombreUsuario.trim()+"' and clave = '"+clave.trim()+"'";
		
		 usuarios =  getHibernateTemplate().find(sql);
		 
		 //if(!usuarios.isEmpty()){
			// if(usuarios.size() == 1){
				// idEmpleado = usuarios.get(0).getEmpleados().getIdEmpleado();
//				// empleado = usuarios.get(0).getEmpleados();
				// System.out.println("idEmpleado "+idEmpleado);
				// empleado = empleadoDao.datosEmpleado(idEmpleado);
			 //}			 
		 //}
		
		return empleado;
	}

	
	@Override
	public boolean registroUsuario(Usuario usuario)  {
		boolean resultado;
		
		try {
			getHibernateTemplate().save(usuario);	
			getHibernateTemplate().flush();
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
	}

	
	@SuppressWarnings("unchecked")
	public Usuario encontrarUsuario(Short idUsuario){
		List<Usuario> usuarios;
		Usuario usuario = new Usuario();
		String sql="";
		try {
			sql = "from Pruebas where IdCurso='"+idUsuario+"'";
			usuarios = getHibernateTemplate().find(sql);
			
			if(!usuarios.isEmpty()){
				if(usuarios.size() == 1){
					usuario = usuarios.get(0);
				}
			}
			else{
				usuario = null;
			}
			
		} catch (Exception e) {
			usuario = null;
		}
		
		return usuario;
	}

	
	
    @SuppressWarnings("unchecked")
      public List<Usuario> nombreUsuario(String nombreUsuario){
          List<Usuario> usuarios=null;
   
          String sql = "from Usuario where nombreCompleto like '%"+nombreUsuario+"%'";
          try {
   
              usuarios = getHibernateTemplate().find(sql);          
             
          } catch (Exception e) {
              System.out.println(e);
              usuarios = null;
          }
         
          return usuarios;
      }

	@Override
	public boolean editar(Usuario editarUsuario) {
		boolean resultado;
		
		try {
			getHibernateTemplate().update(editarUsuario);
			resultado = true;
			
		} catch (Exception e) {
			resultado = false;
		}	
		
		return resultado;
		
	}  
	
	
}
