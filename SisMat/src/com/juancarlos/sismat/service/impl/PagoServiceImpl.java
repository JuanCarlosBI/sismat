package com.juancarlos.sismat.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juancarlos.sismat.dao.PagoDao;
import com.juancarlos.sismat.dao.SeccionDao;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Pagos;
import com.juancarlos.sismat.service.PagoService;
import com.juancarlos.sismat.dominio.Seccion;

@Service
public class PagoServiceImpl implements PagoService {
	@Autowired
	PagoDao pagoDao;

	public List<Alumnos> idAlumno(String idAlumno) {
		// TODO Auto-generated method stub
		return pagoDao.idAlumno(idAlumno);
	}

	public List<Matriculas> listaMatricula(String codigoColegio, String idAlumno) {
		System.out.println("en listaAlumnos service");
		System.out.println("codigoColegio " + codigoColegio);
		System.out.println("idAlumno " + idAlumno);

		List<Matriculas> matriculas = pagoDao.listaMatricula(codigoColegio,
				idAlumno);

		return matriculas;
	}

	public List<Alumnos> listaAlumnos(String codigoColegio, String idAlumno) {
		System.out.println("en listaAlumnos service");
		System.out.println("codigoColegio " + codigoColegio);
		System.out.println("idAlumno " + idAlumno);

		List<Alumnos> alumnos = pagoDao.listaAlumnos(codigoColegio, idAlumno);

		return alumnos;
	}

	 public List<Seccion> listaSeccion(Integer idSeccion) {
		System.out.println("en listaSeccion service");
		System.out.println("idSeccion " + idSeccion);

		List<Seccion> seccion = pagoDao.listaSeccion(idSeccion);

		return seccion;
	}

	public List<Pagos> listaPago(Integer idMatricula) {
		System.out.println("en listaMatricula service");
		System.out.println("idMatricula " + idMatricula);

		List<Pagos> pagos = pagoDao.listaPago(idMatricula);

		return pagos;
	}

	public boolean registroPago(Integer idMatricula, String fecha,
			String factura, String boleta, Double recargo, Double descuento,
			Double deuda, Double saldopagado, String codigoColegio,String pension) {

		Pagos pago = new Pagos();
		pago.setIdMatricula(idMatricula);
		pago.setFecha(fecha);
		pago.setFactura(factura);
		pago.setBoleta(boleta);
		pago.setRecargo(recargo);
		pago.setDescuento(descuento);
		pago.setDeuda(deuda);
		pago.setSaldopagado(saldopagado);
		pago.setCodigoColegio(codigoColegio);
		pago.setPension(pension);

		return pagoDao.registroPago(pago);

	}

}
