package com.juancarlos.sismat.dao;

import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Pagos;

public interface PagoDao {
	public  List<Alumnos> idAlumno(String idAlumno);
	public List<Matriculas> listaMatricula(String codigoColegio, String idAlumno);

	public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno);

	public List<Nivel> listaNivel(Integer idNivel) ;
	public List<Pagos> listaPago(Integer idMatricula);
	public boolean registroPago(Pagos pago);
}
