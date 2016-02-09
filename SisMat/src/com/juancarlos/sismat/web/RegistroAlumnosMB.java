package com.juancarlos.sismat.web;

import javax.faces.bean.ManagedBean;

import java.io.IOException;

import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.juancarlos.sismat.service.AlumnoService;

@SuppressWarnings("serial")
@ManagedBean(name = "registroAlumnosMB")
@SessionScoped
@Component
public class RegistroAlumnosMB implements Serializable {
	private String dni;
	private String nombres;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private Date fechaNacimiento;
	private String edad;
	private char sexo;
	private String direccion;
	private String distrito;
	private String responsable;
	private String religion;
	private byte[] foto;
	private String nombrefoto;
	private String nombrePadre;
	private String apellidoPaternoPadre;
	private String apellidoMaternoPadre;
	private String dniPadre;
	private Date fechaNacPadre;
	private String estadoCivilPadre;
	private String telefonoPadre;
	private String celularPadre;
	private String direccionPadre;
	private String distritoPadre;
	private String ocupacionPadre;
	private String religionPadre;
	private String estaVivoPadre;
	private String nombreMadre;
	private String apellidoPaternoMadre;
	private String apellidoMaternoMadre;
	private String dniMadre;
	private Date fechaNacMadre;
	private String estadoCivilMadre;
	private String telefonoMadre;
	private String celularMadre;
	private String direccionMadre;
	private String distritoMadre;
	private String ocupacionMadre;
	private String religionMadre;
	private String estaVivoMadre;

	private String nombreApoderado;
	private String apellidoPaternoApoderado;
	private String apellidoMaternoApoderado;
	private String dniApoderado;
	private Date fechaNacApoderado;
	private String estadoCivilApoderado;
	private String telefonoApoderado;
	private String celularApoderado;
	private String direccionApoderado;
	private String distritoApoderado;
	private String ocupacionApoderado;
	private String religionApoderado;
	private String estaVivoApoderado;
	private String codigoColegio;

	@Autowired
	AlumnoService alumnoService;

	@Autowired
	private MainMB mainMB;

	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Ok", "Fichero "
				+ event.getFile().getFileName() + " subido correctamente.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
		foto = event.getFile().getContents();
		nombrefoto = event.getFile().getFileName();
	}

	public void registrarAlumno() {
		System.out.println("registroAlumno");
		System.out.println(nombrefoto);
		codigoColegio = mainMB.getCodigoColegio();
		System.out.println(codigoColegio);

		boolean resultado = alumnoService.registroAlumno(nombres,
				apellidoPaterno, apellidoMaterno, dni, fechaNacimiento, edad,
				sexo, direccion, distrito, responsable, religion, foto,
				nombrePadre, apellidoPaternoPadre, apellidoMaternoPadre,
				dniPadre, fechaNacPadre, estadoCivilPadre, telefonoPadre,
				celularPadre, direccionPadre, distritoPadre, ocupacionPadre,
				religionPadre, estaVivoPadre, nombreMadre,
				apellidoPaternoMadre, apellidoMaternoMadre, dniMadre,
				fechaNacMadre, estadoCivilMadre, telefonoMadre, celularMadre,
				direccionMadre, distritoMadre, ocupacionMadre, religionMadre,
				estaVivoMadre, nombreApoderado, apellidoPaternoApoderado,
				apellidoMaternoApoderado, dniApoderado, fechaNacApoderado,
				estadoCivilApoderado, telefonoApoderado, celularApoderado,
				direccionApoderado, distritoApoderado, ocupacionApoderado,
				religionApoderado, estaVivoApoderado, codigoColegio);
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

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
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

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getNombrePadre() {
		return nombrePadre;
	}

	public void setNombrePadre(String nombrePadre) {
		this.nombrePadre = nombrePadre;
	}

	public String getApellidoPaternoPadre() {
		return apellidoPaternoPadre;
	}

	public void setApellidoPaternoPadre(String apellidoPaternoPadre) {
		this.apellidoPaternoPadre = apellidoPaternoPadre;
	}

	public String getApellidoMaternoPadre() {
		return apellidoMaternoPadre;
	}

	public void setApellidoMaternoPadre(String apellidoMaternoPadre) {
		this.apellidoMaternoPadre = apellidoMaternoPadre;
	}

	public String getDniPadre() {
		return dniPadre;
	}

	public void setDniPadre(String dniPadre) {
		this.dniPadre = dniPadre;
	}

	public Date getFechaNacPadre() {
		return fechaNacPadre;
	}

	public void setFechaNacPadre(Date fechaNacPadre) {
		this.fechaNacPadre = fechaNacPadre;
	}

	public String getEstadoCivilPadre() {
		return estadoCivilPadre;
	}

	public void setEstadoCivilPadre(String estadoCivilPadre) {
		this.estadoCivilPadre = estadoCivilPadre;
	}

	public String getTelefonoPadre() {
		return telefonoPadre;
	}

	public void setTelefonoPadre(String telefonoPadre) {
		this.telefonoPadre = telefonoPadre;
	}

	public String getCelularPadre() {
		return celularPadre;
	}

	public void setCelularPadre(String celularPadre) {
		this.celularPadre = celularPadre;
	}

	public String getDireccionPadre() {
		return direccionPadre;
	}

	public void setDireccionPadre(String direccionPadre) {
		this.direccionPadre = direccionPadre;
	}

	public String getDistritoPadre() {
		return distritoPadre;
	}

	public void setDistritoPadre(String distritoPadre) {
		this.distritoPadre = distritoPadre;
	}

	public String getOcupacionPadre() {
		return ocupacionPadre;
	}

	public void setOcupacionPadre(String ocupacionPadre) {
		this.ocupacionPadre = ocupacionPadre;
	}

	public String getReligionPadre() {
		return religionPadre;
	}

	public void setReligionPadre(String religionPadre) {
		this.religionPadre = religionPadre;
	}

	public String getEstaVivoPadre() {
		return estaVivoPadre;
	}

	public void setEstaVivoPadre(String estaVivoPadre) {
		this.estaVivoPadre = estaVivoPadre;
	}

	public String getNombreMadre() {
		return nombreMadre;
	}

	public void setNombreMadre(String nombreMadre) {
		this.nombreMadre = nombreMadre;
	}

	public String getApellidoPaternoMadre() {
		return apellidoPaternoMadre;
	}

	public void setApellidoPaternoMadre(String apellidoPaternoMadre) {
		this.apellidoPaternoMadre = apellidoPaternoMadre;
	}

	public String getApellidoMaternoMadre() {
		return apellidoMaternoMadre;
	}

	public void setApellidoMaternoMadre(String apellidoMaternoMadre) {
		this.apellidoMaternoMadre = apellidoMaternoMadre;
	}

	public String getDniMadre() {
		return dniMadre;
	}

	public void setDniMadre(String dniMadre) {
		this.dniMadre = dniMadre;
	}

	public Date getFechaNacMadre() {
		return fechaNacMadre;
	}

	public void setFechaNacMadre(Date fechaNacMadre) {
		this.fechaNacMadre = fechaNacMadre;
	}

	public String getEstadoCivilMadre() {
		return estadoCivilMadre;
	}

	public void setEstadoCivilMadre(String estadoCivilMadre) {
		this.estadoCivilMadre = estadoCivilMadre;
	}

	public String getTelefonoMadre() {
		return telefonoMadre;
	}

	public void setTelefonoMadre(String telefonoMadre) {
		this.telefonoMadre = telefonoMadre;
	}

	public String getCelularMadre() {
		return celularMadre;
	}

	public void setCelularMadre(String celularMadre) {
		this.celularMadre = celularMadre;
	}

	public String getDireccionMadre() {
		return direccionMadre;
	}

	public void setDireccionMadre(String direccionMadre) {
		this.direccionMadre = direccionMadre;
	}

	public String getDistritoMadre() {
		return distritoMadre;
	}

	public void setDistritoMadre(String distritoMadre) {
		this.distritoMadre = distritoMadre;
	}

	public String getOcupacionMadre() {
		return ocupacionMadre;
	}

	public void setOcupacionMadre(String ocupacionMadre) {
		this.ocupacionMadre = ocupacionMadre;
	}

	public String getReligionMadre() {
		return religionMadre;
	}

	public void setReligionMadre(String religionMadre) {
		this.religionMadre = religionMadre;
	}

	public String getEstaVivoMadre() {
		return estaVivoMadre;
	}

	public void setEstaVivoMadre(String estaVivoMadre) {
		this.estaVivoMadre = estaVivoMadre;
	}

	public String getNombreApoderado() {
		return nombreApoderado;
	}

	public void setNombreApoderado(String nombreApoderado) {
		this.nombreApoderado = nombreApoderado;
	}

	public String getApellidoPaternoApoderado() {
		return apellidoPaternoApoderado;
	}

	public void setApellidoPaternoApoderado(String apellidoPaternoApoderado) {
		this.apellidoPaternoApoderado = apellidoPaternoApoderado;
	}

	public String getApellidoMaternoApoderado() {
		return apellidoMaternoApoderado;
	}

	public void setApellidoMaternoApoderado(String apellidoMaternoApoderado) {
		this.apellidoMaternoApoderado = apellidoMaternoApoderado;
	}

	public String getDniApoderado() {
		return dniApoderado;
	}

	public void setDniApoderado(String dniApoderado) {
		this.dniApoderado = dniApoderado;
	}

	public Date getFechaNacApoderado() {
		return fechaNacApoderado;
	}

	public void setFechaNacApoderado(Date fechaNacApoderado) {
		this.fechaNacApoderado = fechaNacApoderado;
	}

	public String getEstadoCivilApoderado() {
		return estadoCivilApoderado;
	}

	public void setEstadoCivilApoderado(String estadoCivilApoderado) {
		this.estadoCivilApoderado = estadoCivilApoderado;
	}

	public String getTelefonoApoderado() {
		return telefonoApoderado;
	}

	public void setTelefonoApoderado(String telefonoApoderado) {
		this.telefonoApoderado = telefonoApoderado;
	}

	public String getCelularApoderado() {
		return celularApoderado;
	}

	public void setCelularApoderado(String celularApoderado) {
		this.celularApoderado = celularApoderado;
	}

	public String getDireccionApoderado() {
		return direccionApoderado;
	}

	public void setDireccionApoderado(String direccionApoderado) {
		this.direccionApoderado = direccionApoderado;
	}

	public String getDistritoApoderado() {
		return distritoApoderado;
	}

	public void setDistritoApoderado(String distritoApoderado) {
		this.distritoApoderado = distritoApoderado;
	}

	public String getOcupacionApoderado() {
		return ocupacionApoderado;
	}

	public void setOcupacionApoderado(String ocupacionApoderado) {
		this.ocupacionApoderado = ocupacionApoderado;
	}

	public String getReligionApoderado() {
		return religionApoderado;
	}

	public void setReligionApoderado(String religionApoderado) {
		this.religionApoderado = religionApoderado;
	}

	public String getEstaVivoApoderado() {
		return estaVivoApoderado;
	}

	public void setEstaVivoApoderado(String estaVivoApoderado) {
		this.estaVivoApoderado = estaVivoApoderado;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public String getNombrefoto() {
		return nombrefoto;
	}

	public void setNombrefoto(String nombrefoto) {
		this.nombrefoto = nombrefoto;
	}

	public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}

	public MainMB getMainMB() {
		return mainMB;
	}

	public void setMainMB(MainMB mainMB) {
		this.mainMB = mainMB;
	}

}
