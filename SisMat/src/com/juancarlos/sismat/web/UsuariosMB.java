package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Usuario;
import com.juancarlos.sismat.service.UsuarioService;

@SuppressWarnings("serial")
@ManagedBean(name = "usuariosMB")
@SessionScoped
@Component
public class UsuariosMB implements Serializable {

	private String codigoColegio;
	private String nombreCompleto;
	private String idUsuario;
	private String estado;

	@Autowired
	private MainMB mainMB;

	private List<Usuario> listaUsuario;
	@Autowired
	UsuarioService usuarioService;

	public List<String> autoCompletadoProducto(String query) {

		
		

		List<String> results = new ArrayList<String>();
		List<Usuario> listaNombresProductos = new ArrayList<Usuario>();

		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();

		// codigoColegio="1041701524";
		listaNombresProductos = usuarioService.nombreUsuario(query
				.toUpperCase());

		if (query.length() >= 3) {
			for (Usuario elemento : listaNombresProductos) {
				results.add(elemento.getNombreCompleto() + "-"
						+ elemento.getIdUsuario());
			}
		}

		return results;

	}

	public void listaUsuario() {
		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();
		idUsuario = nombreCompleto.replaceAll("[^0-9.]", "");

		listaUsuario = usuarioService.listaUsuario(codigoColegio, idUsuario,
				estado);
		int resultado = listaUsuario.size();
		if (resultado == 0) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Usuario no encontrado", ""));
		}
		return;

	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Usuario Editado",
				((Usuario) event.getObject()).getNombreUsuario());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		boolean resultado = usuarioService.editar((Usuario) event.getObject());

	}

	public void darBaja(Usuario lista) {
		estado = "Inactivo";
		lista.setEstado(getEstado());

		usuarioService.editar(lista);
	}

	public void darAlta(Usuario lista) {
		estado = "Activo";
		lista.setEstado(getEstado());

		usuarioService.editar(lista);
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	public List<Usuario> getListaUsuario() {
		return listaUsuario;
	}

	public void setListaUsuario(List<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
