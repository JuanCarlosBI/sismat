package com.juancarlos.sismat.service;

import java.util.Date;
import java.util.List;

import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Seccion;
import com.juancarlos.sismat.dominio.Pagos;

public interface PagoService {
	 public List<Matriculas> listaMatricula(String codigoColegio, String idAlumno);

	 public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno);
	 public List<Seccion> listaSeccion(Integer idSeccion);
		public List<Pagos> listaPago(Integer idMatricula);
		public boolean registroPago(Integer idMatricula, String fecha,
				String factura, String boleta, Double recargo,Double descuento,Double deuda,
				Double saldopagado,String codigoColegio,String pension);
		
		
}
