package com.juancarlos.sismat.service;

import java.util.Date;
import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;
public interface AlumnoService {
	public List<Alumnos> listaAlumnos(String codigoColegio, String dni, String nombre, String apellidoPaterno,String apellidoMaterno, char estado);
	
	public boolean registroAlumno(String nombres, String apellidoPaterno,
			String apellidoMaterno, String dni, Date fechaNacimiento,
			String edad, char sexo, String direccion, String distrito,
			String responsable, String religion,String nombrePadre,
			String apellidoPaternoPadre,String apellidoMaternoPadre, String dniPadre, Date fechaNacPadre,
			String estadoCivilPadre, String telefonoPadre, String celularPadre,
			String direccionPadre, String distritoPadre, String ocupacionPadre,
			String religionPadre, String estaVivoPadre, String nombreMadre,
			String apellidoPaternoMadre,String apellidoMaternoMadre, String dniMadre, Date fechaNacMadre,
			String estadoCivilMadre, String telefonoMadre, String celularMadre,
			String direccionMadre, String distritoMadre, String ocupacionMadre,String religionMadre,String estaVivoMadre,String nombreApoderado,
			String apellidoPaternoApoderado,String apellidoMaternoApoderado, String dniApoderado,
			Date fechaNacApoderado, String estadoCivilApoderado,
			String telefonoApoderado, String celularApoderado,
			String direccionApoderado, String distritoApoderado,
			String ocupacionApoderado, String religionApoderado,
			String estaVivoApoderado);
}
