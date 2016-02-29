package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.juancarlos.sismat.service.UsuarioService;


@SuppressWarnings("serial")
@ManagedBean(name="registroUsuarioMB")
@SessionScoped
@Component
public class RegistroUsuarioMB implements Serializable{
	private String nombreUsuario="";
    private String clave;
    private String clave1;
    private String tipo;
    private String contrasenia2;
    private String nombreCompleto;
    private String estado;
    private String codigoColegio;
	private String fecha;

	@Autowired
	private MainMB mainMB;
    @Autowired
	UsuarioService usuarioService;

    public void registrarUsuario() {
		

			mainMB.datosUsuario();
			codigoColegio=mainMB.getCodigoColegio();
			Date date = new Date();
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			fecha = dateFormat.format(date);

			if(clave.equals(clave1)){
				
				boolean resultado = usuarioService.registroUsuario(nombreUsuario,
						clave, tipo, nombreCompleto,estado,codigoColegio,fecha );
				if (resultado) {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									"Se registro correctamente", ""));
				} else {
					FacesContext.getCurrentInstance().addMessage(
							null,
							new FacesMessage(FacesMessage.SEVERITY_ERROR,
									"Hubo un error en guardar la información", ""));
				}
			
				
			}else{
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Las contraseñas no coinciden", ""));
		
			}
			
		

		

	}

	 public void resetFail() {
	        this.nombreUsuario = null;
	        this.clave = null;
	        this.tipo = null;
	        this.contrasenia2=null;
	        this.nombreCompleto=null;
	        
	        
	        
	    }

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getContrasenia2() {
		return contrasenia2;
	}

	public void setContrasenia2(String contrasenia2) {
		this.contrasenia2 = contrasenia2;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getClave1() {
		return clave1;
	}

	public void setClave1(String clave1) {
		this.clave1 = clave1;
	}


}

