package com.juancarlos.sismat.dominio;
// Generated 20-abr-2015 23:35:22 by Hibernate Tools 3.6.0


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Usuarios generated by hbm2java
 */
@Entity
@Table(name="usuarios"
    ,catalog="dbcolegio2"
)
public class Usuario  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short idUsuario;
	private String nombreCompleto;
	private String estado;

    private String fecha;
     private String nombreUsuario;
     private String clave;
     private String tipo;
     private String codigoColegio;

    public Usuario() {
    }

    public Usuario( String nombreUsuario, String clave, String tipo, String codigoColegio) {
     
       this.nombreUsuario = nombreUsuario;
       this.clave = clave;
       this.tipo = tipo;
    }
    
     
    
   
     public Usuario(String nombreCompleto, String estado, String nombreUsuario,
			String clave, String tipo, String codigoColegio,String fecha) {
		super();
		this.nombreCompleto = nombreCompleto;
		this.estado = estado;
		this.nombreUsuario = nombreUsuario;
		this.clave = clave;
		this.tipo = tipo;
		this.codigoColegio = codigoColegio;
		this.fecha=fecha;
	}

	@Id @GeneratedValue(strategy=IDENTITY)  
     
    @Column(name="IdUsuario", unique=true, nullable=false)
    public Short getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Short idUsuario) {
        this.idUsuario = idUsuario;
    }


    
    @Column(name="NombreUsuario", nullable=false, length=20)
    public String getNombreUsuario() {
        return this.nombreUsuario;
    }
    
    public void setNombreUsuario(String usuario) {
        this.nombreUsuario = usuario;
    }

    
    @Column(name="Clave", nullable=false, length=20)
    public String getClave() {
        return this.clave;
    }
    
    public void setClave(String clave) {
        this.clave = clave;
    }

    
    @Column(name="Tipo", nullable=false, length=30)
    public String getTipo() {
        return this.tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    @Column(name="NombreCompleto", nullable=false, length=100)
    public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}
	@Column(name="Estado", nullable=false, length=10)
    public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Column(name="codigoColegio", nullable=false, length=11)
    public String getCodigoColegio() {
		return codigoColegio;
	}

	public void setCodigoColegio(String codigoColegio) {
		this.codigoColegio = codigoColegio;
	}
	  
	    @Column(name="FechaRegistro", nullable=false, length=10)
	 public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

    

}


