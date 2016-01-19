package com.juancarlos.sismat.dominio;
// Generated 20-abr-2015 23:35:22 by Hibernate Tools 3.6.0


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;

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
     private Empleado empleado;
     private String nombreUsuario;
     private String clave;
     private String tipo;
     private String codigoColegio;


    public Usuario() {    	
        this.nombreUsuario = "Juan Carlos";        
        this.codigoColegio = "10417015243";
    }

    public Usuario(Empleado empleado, String nombreUsuario, String clave, String tipo, String codigoColegio) {
       this.empleado = empleado;
       this.nombreUsuario = nombreUsuario;
       this.clave = clave;
       this.tipo = tipo;
       this.codigoColegio = codigoColegio;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)    
    @Column(name="IdUsuario", unique=true, nullable=false)
    public Short getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Short idUsuario) {
        this.idUsuario = idUsuario;
    }

@OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="IdEmpleado", nullable=false)
    public Empleado getEmpleados() {
        return this.empleado;
    }
    

	public void setEmpleados(Empleado empleado) {
        this.empleado = empleado;
    }

    
    @Column(name="nombreUsuario", nullable=false, length=20)
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

    
    @Column(name="CodigoColegio", nullable=false, length=10)
    public String getCodigoColegio() {
        return this.codigoColegio;
    }
    
    public void setCodigoColegio(String codigoColegio) {
        this.codigoColegio = codigoColegio;
    }
}


