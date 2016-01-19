package com.juancarlos.sismat.service;

import java.util.Date;
import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Pagos;

public interface PagoService {
	 public List<Alumnos> idAlumno(String idAlumno);
	 public List<Matriculas> listaMatricula(String codigoColegio, String idAlumno);

	 public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno);
	 public List<Nivel> listaNivel(String idNivel);
		public List<Pagos> listaPago(Integer idMatricula);
		public boolean registroPago(Integer idMatricula, Date fecha,
				String factura, String boleta, double recargo,double descuento,double deuda,
				double saldopagado,String codigoColegio,String pension);
}
