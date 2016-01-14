package com.juancarlos.sismat.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.juancarlos.sismat.dao.EmpleadoDao;
import com.juancarlos.sismat.dao.UsuarioDao;
import com.juancarlos.sismat.dominio.Empleado;
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

	
	@SuppressWarnings("unchecked")
	public Empleado datosUsuario(String nombreUsuario, String clave) {
		
		logger.info("en datosEmpleado");
		String sql = "";
		List<Usuario> usuarios;
		Integer idEmpleado;
		Empleado empleado = null;
		
		
		 sql = "from Usuario where nombreUsuario = '"+nombreUsuario.trim()+"' and clave = '"+clave.trim()+"'";
		
		 usuarios =  getHibernateTemplate().find(sql);
		 
		 if(!usuarios.isEmpty()){
			 if(usuarios.size() == 1){
				 idEmpleado = usuarios.get(0).getEmpleados().getIdEmpleado();
//				 empleado = usuarios.get(0).getEmpleados();
				 System.out.println("idEmpleado "+idEmpleado);
				 empleado = empleadoDao.datosEmpleado(idEmpleado);
			 }			 
		 }
		
		return empleado;
	}
	
}
