package com.juancarlos.sismat.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.juancarlos.sismat.dominio.Alumnos;
import com.juancarlos.sismat.dominio.Matriculas;
import com.juancarlos.sismat.dominio.Nivel;
import com.juancarlos.sismat.dominio.Pagos;
import com.juancarlos.sismat.service.PagoService;
@SuppressWarnings("serial")
@ManagedBean(name="registroPagoMB")
@SessionScoped
@Component

public class RegistroPagoMB implements Serializable  {
	private String idAlumno;

	private List<Matriculas> matriculas;
	private List<Alumnos> alumnos;
	private List<Nivel> nivel;
	private List<Pagos> pagos ;
	private String codigoColegio;   
	private Double saldo;
	private String factura;
	private String boleta;
	private Double deuda;
	private Double recargo;
	private Double descuento;
	private Double saldopagado;
	private Date fecha;
	private String pension;

	@Autowired
	PagoService pagoService;
	Integer idMatricula;
	
	public List<String> autoCompletadoAlumno(String query) {
		
		
		List<String> results = new ArrayList<String>();
		List<Alumnos> listaNombresAlumnos = new ArrayList<Alumnos>();		
		
		listaNombresAlumnos = pagoService.idAlumno(query.toUpperCase());
		
		
		if (query.length() >= 3) {
			for (Alumnos elemento : listaNombresAlumnos) {
				results.add(elemento.getIdAlumno());	
			}
		}

		return results;

	}
	

	
	public void listaAlumnos(){

		
		alumnos = pagoService.listaAlumnos(codigoColegio, idAlumno);
		
		if(alumnos == null){
			FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_ERROR,"Hubo un problema en la búsqueda",""));
			this.matriculas=null;
			this.nivel=null;
			this.pagos=null;
			this.deuda=null;
			this.saldopagado=null;
			this.recargo=null;
			this.saldo=null;
			this.idMatricula=null;
			this.descuento=null;
		}
		else if(alumnos.isEmpty()){
				FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"No se encontro alumnos",""));
				this.matriculas=null;
				this.nivel=null;
				this.pagos=null;
				this.deuda=null;
				this.saldopagado=null;
				this.recargo=null;
				this.saldo=null;
				this.idMatricula=null;
				this.descuento=null;
		}else{
			matriculas =pagoService.listaMatricula(codigoColegio, idAlumno);

			Matriculas matricula=matriculas.get(0); 
			Integer idNivel=matricula.getIdNivel();
			idMatricula=matricula.getIdMatricula();
			nivel=pagoService.listaNivel(idNivel);}
		
		
		return;
	}
	public void verPagos(){
		pagos = pagoService.listaPago(idMatricula);

	}
	public void calcularDeuda(){
		deuda=saldo-saldo*descuento+saldo*recargo-saldopagado;
		if(descuento!=0&&recargo!=0){
			deuda=saldo-saldo*descuento+saldo*recargo-saldopagado;
		}else if(descuento!=0&&recargo==0){
			deuda=saldo-saldo*descuento-saldopagado;
		}else if(descuento==0&&recargo!=0){
			deuda=saldo+saldo*recargo-saldopagado;
		}else if(descuento==0&&recargo==0){
			deuda=saldo-saldopagado;
		}
		
	}
	
	public void registrarPago() {

		
		
		boolean resultado = pagoService.registroPago(idMatricula, fecha,
				factura,  boleta, recargo, descuento, deuda,
				 saldopagado, codigoColegio,pension);

		if (resultado) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO,
							"Se registro correctamente", ""));
		} else {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Por favor revise que los datos del alumno esten correctos", ""));
		}
		

	}
	public void resetFail() {
        this.descuento = null;
        this.deuda = null;
        this.recargo = null;
        this.saldopagado = null;

        this.saldo = null;
        
        
        
         
        FacesMessage msg = new FacesMessage("Datos limpios");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

	public String getCodigoColegio() {
		return codigoColegio;
	}
	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}
	public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}



	public PagoService getPagoService() {
		return pagoService;
	}

	public void setPagoService(PagoService pagoService) {
		this.pagoService = pagoService;
	}
	public List<Alumnos> getAlumnos() {
		return alumnos;
	}
	public void setAlumnos(List<Alumnos> alumnos) {
		this.alumnos = alumnos;
	}

	public List<Matriculas> getMatriculas() {
		return matriculas;
	}

	public void setMatriculas(List<Matriculas> matriculas) {
		this.matriculas = matriculas;
	}

	public List<Nivel> getNivel() {
		return nivel;
	}

	public void setNivel(List<Nivel> nivel) {
		this.nivel = nivel;
	}



		public List<Pagos> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pagos> pagos) {
		this.pagos = pagos;
	}

		public Double getSaldo() {
			return saldo;
		}

		public void setSaldo(Double saldo) {
			this.saldo = saldo;
		}

		public String getFactura() {
			return factura;
		}

		public void setFactura(String factura) {
			this.factura = factura;
		}

		public String getBoleta() {
			return boleta;
		}

		public void setBoleta(String boleta) {
			this.boleta = boleta;
		}



		public Double getDeuda() {
			return deuda;
		}



		public void setDeuda(Double deuda) {
			this.deuda = deuda;
		}



		public Double getRecargo() {
			return recargo;
		}



		public void setRecargo(Double recargo) {
			this.recargo = recargo;
		}



		public Double getDescuento() {
			return descuento;
		}



		public void setDescuento(Double descuento) {
			this.descuento = descuento;
		}



		public Double getSaldopagado() {
			return saldopagado;
		}



		public void setSaldopagado(Double saldopagado) {
			this.saldopagado = saldopagado;
		}



		public Date getFecha() {
			return fecha;
		}



		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}



		public Integer getIdMatricula() {
			return idMatricula;
		}



		public void setIdMatricula(Integer idMatricula) {
			this.idMatricula = idMatricula;
		}



		public String getPension() {
			return pension;
		}



		public void setPension(String pension) {
			this.pension = pension;
		}
	    
	    
}
