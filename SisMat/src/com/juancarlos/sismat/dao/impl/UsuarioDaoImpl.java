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
public class UsuarioDaoImpl extends HibernateDaoSupport implements UsuarioDao {

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

		sql = "from Usuario where nombreUsuario = '" + nombreUsuario.trim()
				+ "' and clave = '" + clave.trim() + "'";

		usuarios = getHibernateTemplate().find(sql);

		if (!usuarios.isEmpty()) {
			if (usuarios.size() == 1) {
				sesion = true;
			}
		}

		return sesion;
	}

	public List<Usuario> listaUsuario(String codigoColegio, String nombreCompleto,
			String estado) {
		logger.info("en listaUsuario");

		String sql = "";
		List<Usuario> listaUsuario = new ArrayList<Usuario>();

		try {
			if (nombreCompleto.length() == 0 && estado.length() == 0) {
				sql = "from Usuario where codigoColegio = '"
						+ codigoColegio.trim() + "'";

			}
			if (nombreCompleto.length() != 0 && estado.length() == 0) {
				sql = "from Usuario where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nombreCompleto='"
						+ nombreCompleto + "'";

			}
			if (nombreCompleto.length() == 0 && estado.length() != 0) {
				sql = "from Usuario where codigoColegio = '"
						+ codigoColegio.trim() + "' AND estado='" + estado
						+ "'";

			}
			if (nombreCompleto.length() != 0 && estado.length() != 0) {
				sql = "from Usuario where codigoColegio = '"
						+ codigoColegio.trim() + "' AND nombreCompleto='"
						+ nombreCompleto + "' AND estado='" + estado + "'";

			}

			listaUsuario = getHibernateTemplate().find(sql);

			if (listaUsuario.isEmpty()) {
				listaUsuario = new ArrayList<Usuario>();
			}

		} catch (Exception e) {
			
			listaUsuario = null;
		}

		return listaUsuario;

	}

	@SuppressWarnings("unchecked")
	public List<Usuario> datosUsuario(String nombreUsuario, String clave) {
		List<Usuario> usuarios = null;
		String sql = "";
		try {

			sql = "from Usuario where nombreUsuario = '" + nombreUsuario.trim()
					+ "' AND clave='" + clave + "'";

			usuarios = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			
			usuarios = null;
		}

		return usuarios;
	}

	@Override
	public boolean registroUsuario(Usuario usuario) {
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
	public List<Usuario> nombreUsuario(String nombreUsuario) {
		List<Usuario> usuarios = null;

		String sql = "from Usuario where nombreCompleto like '%"
				+ nombreUsuario + "%'";
		try {

			usuarios = getHibernateTemplate().find(sql);

		} catch (Exception e) {
			
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
