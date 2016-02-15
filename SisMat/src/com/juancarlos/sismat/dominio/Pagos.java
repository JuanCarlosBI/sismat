package com.juancarlos.sismat.dominio;
// Generated 20-abr-2015 23:35:22 by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Matriculas generated by hbm2java
 */
@Entity
@Table(name="pagos"
    ,catalog="dbcolegio2"
)
public class Pagos  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPago;
	private Integer idMatricula;
    private String fecha;
     private String factura;
     private String boleta;
     private Double recargo;
     private Double descuento;
    private Double deuda;
     private Double saldopagado;
     private String codigoColegio;
     private String pension;

    public Pagos() {
    }

	
   
     public Pagos(Integer idMatricula, String fecha, String factura,
			String boleta, Double recargo, Double descuento, Double deuda,
			Double saldopagado,String pension) {
		this.idMatricula = idMatricula;
		this.fecha = fecha;
		this.factura = factura;
		this.boleta = boleta;
		this.recargo = recargo;
		this.descuento = descuento;
		this.deuda = deuda;
		this.saldopagado = saldopagado;
		this.pension=pension;
	}



	public Pagos(Integer idPago, Integer idMatricula, String fecha,
			String factura, String boleta, Double recargo, Double descuento,
			Double deuda, Double saldopagado, String codigoColegio,String pension) {
		
		this.idPago = idPago;
		this.idMatricula = idMatricula;
		this.fecha = fecha;
		this.factura = factura;
		this.boleta = boleta;
		this.recargo = recargo;
		this.descuento = descuento;
		this.deuda = deuda;
		this.saldopagado = saldopagado;
		this.codigoColegio = codigoColegio;
		this.pension=pension;
	}



	@Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="IdPago", unique=true, nullable=false)
    public Integer getIdPago() {
        return this.idPago;
    }
    
    public void setIdPago(Integer idPago) {
        this.idPago = idPago;
    }

    

    @Column(name="IdMatricula", nullable=false, length=10)
   public Integer getIdMatricula() {
		return idMatricula;
	}

	public void setIdMatricula(Integer idMatricula) {
		this.idMatricula = idMatricula;
	}


    
    @Column(name="Fecha", nullable=false, length=10)
    public String getFecha() {
        return this.fecha;
    }
    
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


   

    @Column(name="Factura", nullable=false, length=20)
    public String getFactura() {
		return factura;
	}



	public void setFactura(String factura) {
		this.factura = factura;
	}



    @Column(name="Boleta", nullable=false, length=20)
	public String getBoleta() {
		return boleta;
	}



	public void setBoleta(String boleta) {
		this.boleta = boleta;
	}



    @Column(name="Recargo", nullable=false, length=10)
	public Double getRecargo() {
		return recargo;
	}



	public void setRecargo(Double recargo) {
		this.recargo = recargo;
	}



    @Column(name="Descuento", nullable=false, length=10)
	public Double getDescuento() {
		return descuento;
	}



	public void setDescuento(Double descuento) {
		this.descuento = descuento;
	}



    @Column(name="Deuda", nullable=false, length=10)
	public Double getDeuda() {
		return deuda;
	}



	public void setDeuda(Double deuda) {
		this.deuda = deuda;
	}



    @Column(name="Saldopagado", nullable=false, length=10)
	public Double getSaldopagado() {
		return saldopagado;
	}



	public void setSaldopagado(Double saldopagado) {
		this.saldopagado = saldopagado;
	}



	@Column(name="codigoColegio", nullable=false, length=11)
    public String getCodigoColegio() {
        return this.codigoColegio;
    }
    
    public void setCodigoColegio(String codigoColegio) {
        this.codigoColegio = codigoColegio;
    }



	@Column(name="Pension", nullable=false, length=10)
	public String getPension() {
		return pension;
	}



	public void setPension(String pension) {
		this.pension = pension;
	}




}


