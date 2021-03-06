package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.icu.text.DateFormat;
import com.ibm.icu.text.SimpleDateFormat;
import com.juancarlos.sismat.service.EmpleadoService;

@SuppressWarnings("serial")
@ManagedBean(name = "registroProfesorMB")
@SessionScoped
@Component
public class RegistroProfesorMB implements Serializable {

	private String dni;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaNacimiento;
	private char sexo;
	private String direccion;
	private String distrito;
	private String celular;
	private String cargo;
	private String especialidad;

	@Autowired
	private MainMB mainMB;

	private String codigoColegio;
	DateFormat df = new SimpleDateFormat("yyyy-MM-d");
	@Autowired
	EmpleadoService empleadoService;

	public void registrarEmpleado() {

		mainMB.datosUsuario();
		codigoColegio = mainMB.getCodigoColegio();
		if(fechaNacimiento.getYear()<1998){
			System.out.println("holi");
			FacesContext.getCurrentInstance().addMessage(
			null,
			new FacesMessage(FacesMessage.SEVERITY_INFO,
					"La fecha de Nacimieno es incorrecta, el profesor debe ser mayor de edad(+18)", ""));
			return;
		}else{
			// codigoColegio="1041701524";
			boolean resultado = empleadoService.registroEmpleado(dni, nombres,
					apellidoPaterno, apellidoMaterno, fechaNacimiento, sexo,
					direccion, distrito, celular, cargo, especialidad,
					codigoColegio);

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
	
		}

			}

	public void resetFail() {
		
			this.dni = null;
			this.nombres = null;
			this.apellidoPaterno = null;
			this.apellidoMaterno = null;
			this.fechaNacimiento = null;
			this.cargo = null;
			this.direccion = null;
			this.distrito = null;
			this.celular = null;
			this.especialidad = null;
		
		
			}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public MainMB getMainMB() {
		return mainMB;
	}

	public void setMainMB(MainMB mainMB) {
		this.mainMB = mainMB;
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public EmpleadoService getEmpleadoService() {
		return empleadoService;
	}

	public void setEmpleadoService(EmpleadoService empleadoService) {
		this.empleadoService = empleadoService;
	}

}
