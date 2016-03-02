package com.juancarlos.sismat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.AlumnoDao;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.service.AlumnoService;

@Service
public class AlumnoServiceImpl implements AlumnoService {
	@Autowired
	AlumnoDao alumnoDao;

	public List<Alumnos> listaAlumnos(String codigoColegio, String dni, String nombre, String apellidoPaterno,String apellidoMaterno, String estado) {
		
		
		List<Alumnos> alumnos = alumnoDao.listaAlumnos(codigoColegio, dni, nombre,  apellidoPaterno,apellidoMaterno, estado);

		return alumnos;
	}
	public boolean registroAlumno(String nombres, String apellidoPaterno,
			String apellidoMaterno, String dni, Date fechaNacimiento,
			String edad, char sexo, String direccion, String distrito,
			String responsable, String religion,byte[] foto,String nombrePadre,
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
			String estaVivoApoderado,String codigoColegio,String estado) {
		Alumnos alumno = new Alumnos();
		String apellidosPadre = apellidoPaternoPadre + " " + apellidoMaternoPadre;
		String apellidosMadre = apellidoPaternoMadre + " " + apellidoMaternoMadre;
		String apellidosApoderado = apellidoPaternoApoderado + " " + apellidoMaternoApoderado;
		String apellidos=apellidoPaterno+" "+apellidoMaterno;
		String nombreCompleto=nombres+" "+apellidos;
		alumno.setNombres(nombres);
		alumno.setApellidoPaterno(apellidoPaterno);
		alumno.setApellidoMaterno(apellidoMaterno);
		alumno.setDni(dni);
		alumno.setFechaNacimiento(fechaNacimiento);
		alumno.setEdad(edad);
		alumno.setSexo(sexo);
		alumno.setDireccion(direccion);
		alumno.setDistrito(distrito);
		alumno.setResponsable(responsable);
		alumno.setReligion(religion);
		alumno.setFoto(foto);
		alumno.setNombrePadre(nombrePadre);
		alumno.setApellidosPadre(apellidosPadre);
		alumno.setDniPadre(dniPadre);
		alumno.setFechaNacPadre(fechaNacPadre);
		alumno.setEstadoCivilPadre(estadoCivilPadre);
		alumno.setTelefonoPadre(telefonoPadre);
		alumno.setCelularPadre(celularPadre);
		alumno.setDireccionPadre(direccionPadre);
		alumno.setDistritoPadre(distritoPadre);
		alumno.setOcupacionPadre(ocupacionPadre);
		alumno.setReligionPadre(religionPadre);
		alumno.setEstaVivoPadre(estaVivoPadre);
		alumno.setNombreMadre(nombreMadre);
		alumno.setApellidosMadre(apellidosMadre);
		alumno.setDniMadre(dniMadre);
		alumno.setFechaNacMadre(fechaNacMadre);
		alumno.setEstadoCivilMadre(estadoCivilMadre);
		alumno.setTelefonoMadre(telefonoMadre);
		alumno.setCelularMadre(celularMadre);
		alumno.setDireccionMadre(direccionMadre);
		alumno.setDistritoMadre(distritoMadre);
		alumno.setOcupacionMadre(ocupacionMadre);
		alumno.setReligionMadre(religionMadre);
		alumno.setEstaVivoMadre(estaVivoMadre);
		alumno.setNombreApoderado(nombreApoderado);
		alumno.setApellidosApoderado(apellidosApoderado);
		alumno.setDniApoderado(dniApoderado);
		alumno.setFechaNacApoderado(fechaNacApoderado);
		alumno.setEstadoCivilApoderado(estadoCivilApoderado);
		alumno.setTelefonoApoderado(telefonoApoderado);
		alumno.setCelularApoderado(celularApoderado);
		alumno.setDireccionApoderado(direccionApoderado);
		alumno.setDistritoApoderado(distritoApoderado);
		alumno.setOcupacionApoderado(ocupacionApoderado);
		alumno.setReligionApoderado(religionApoderado);
		alumno.setEstaVivoApoderado(estaVivoApoderado);
		alumno.setNombreCompleto(nombreCompleto);
		alumno.setCodigoColegio(codigoColegio);
		alumno.setEstado(estado);
		return alumnoDao.registroAlumno(alumno);
	}

	public boolean editar(Alumnos editarAlumno){
		return alumnoDao.editar(editarAlumno);
	}

}
