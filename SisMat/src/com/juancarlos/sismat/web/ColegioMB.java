package com.juancarlos.sismat.web;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;

import org.hibernate.mapping.Map;
import org.primefaces.component.api.UIData;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.juancarlos.sismat.dominio.Colegio;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.service.ColegioService;

@SuppressWarnings("serial")
@ManagedBean(name = "colegioMB")
@SessionScoped
@Component
public class ColegioMB implements Serializable {

	private String codigoColegio;
	private List<Colegio> colegios;
	private String nombreColegio;
	private byte[] logo;
	private StreamedContent[] variable;
	private StreamedContent imagen;
	private String cadena;
	private String[] nombreLogo;
	@Autowired
	ColegioService colegioService;
	@Autowired
	MainMB loginMB;

	public List<String> autoCompletadoColegio(String query) {

		List<String> results = new ArrayList<String>();
		List<Colegio> listaNombresColegio = new ArrayList<Colegio>();

		listaNombresColegio = colegioService.nombreColegio(query.toUpperCase());

		if (query.length() >= 3) {
			for (Colegio elemento : listaNombresColegio) {
				results.add(elemento.getRazonSocial());
			}
		}

		return results;

	}

	public void onEdit(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Colegio Editado",
				((Colegio) event.getObject()).getRazonSocial());
		FacesContext.getCurrentInstance().addMessage(null, msg);
		boolean resultado = colegioService.editar((Colegio) event.getObject());
	}

	public void listaColegio() {

		colegios = colegioService.listaColegio(nombreColegio);

		if (colegios == null) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Hubo un problema en la búsqueda", ""));

		} else if (colegios.isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"No se encontro Colegio", ""));

		}
		System.out.println(colegios.size());
		// variable = new StreamedContent[colegios.size()];
		// nombreLogo=new String[colegios.size()];
		// for (int i = 0; i < colegios.size(); i++) {
		// Colegio colegioses = colegios.get(i);
		// logo = colegioses.getLogo();
		//
		// variable[i] = new DefaultStreamedContent(new ByteArrayInputStream(
		// logo));
		//
		// cadena = String.valueOf(i);
		//
		// cadena= Integer.toString(i);
		//
		// ((DefaultStreamedContent) variable[i]).setName(cadena);
		// nombreLogo[i]=variable[i].getName();
		// }
		//

		return;
	}
//
//	public StreamedContent getProductImage() throws IOException {
//		//
//		// FacesContext context = FacesContext.getCurrentInstance();
//		//
//		// if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//		// return new DefaultStreamedContent();
//		// }
//		//
//		// else {
//		//
//		// String id = context.getExternalContext().getRequestParameterMap()
//		// .get("pid");
//		//
//		// byte[] image = colegioService.getProductImage(id);
//		//
//		return new DefaultStreamedContent(new ByteArrayInputStream(logo));
//
//		// }
//	}

//	public StreamedContent getGraphicText() throws IOException {
//
//		return new DefaultStreamedContent(new ByteArrayInputStream(logo));
//	}

	//
	// public void verImagen(RowEditEvent event) {
	// UIData data = (UIData) event.getComponent()
	// .findComponent("myDataTable");
	// int rowIndex = data.getRowIndex();
	// imagen = variable[rowIndex];
	//
	// }

	// public List<Colegio> getImagem() {
	// for (int i = 0; i < colegios.size(); i++) {
	// Colegio colegioses = colegios.get(i);
	//
	// List<Colegio> lista = new ArrayList<Colegio>();
	// colegioses.setImagemStreamed(new DefaultStreamedContent(new
	// ByteArrayInputStream(colegioses.getLogo())));
	// System.out.println("ImagemStreamed: "+colegioses.getImagemStreamed().getName());
	// lista.add(colegioses);
	//
	// return lista;
	//
	//
	//
	// logo=colegioses.getLogo();
	//
	//
	// variable[i]=new DefaultStreamedContent(new ByteArrayInputStream(logo));
	//
	// }
	//
	// }

	public void reset() {
		this.nombreColegio = null;
		this.colegios = null;

		FacesMessage msg = new FacesMessage("Datos limpios");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public ColegioService getColegioService() {
		return colegioService;
	}

	public void setColegioService(ColegioService colegioService) {
		this.colegioService = colegioService;
	}

	public String getNombreColegio() {
		return nombreColegio;
	}

	public void setNombreColegio(String nombreColegio) {
		this.nombreColegio = nombreColegio;
	}

	public MainMB getLoginMB() {
		return loginMB;
	}

	public void setLoginMB(MainMB loginMB) {
		this.loginMB = loginMB;
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public List<Colegio> getColegios() {
		return colegios;
	}

	public void setColegios(List<Colegio> colegios) {
		this.colegios = colegios;
	}

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public StreamedContent[] getVariable() {
		return variable;
	}

	public void setVariable(StreamedContent[] variable) {
		this.variable = variable;
	}

	public StreamedContent getImagen() {
		return imagen;
	}

	public void setImagen(StreamedContent imagen) {
		this.imagen = imagen;
	}

	public String getCadena() {
		return cadena;
	}

	public void setCadena(String cadena) {
		this.cadena = cadena;
	}

	public String[] getNombreLogo() {
		return nombreLogo;
	}

	public void setNombreLogo(String[] nombreLogo) {
		this.nombreLogo = nombreLogo;
	}

}
