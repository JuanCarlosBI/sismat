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
import javax.persistence.Table;

/**
 * Matriculas generated by hbm2java
 */
@Entity
@Table(name="matriculas"
    ,catalog="dbcolegio2"
)
public class Matriculas  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idMatricula;
     private String periodo;
   private String fecha;
     private String hora;
     private String codigoColegio;
     private String idAlumno;
     private Integer idSeccion;
     private String situacion;
     private String antcolegio;
     private String estado;
    public Matriculas() {
    }

	
   
   
     public Matriculas(Integer idMatricula, String periodo, String fecha,
			String hora, String codigoColegio, String idAlumno,
			Integer idSeccion, String situacion, String antcolegio,String estado) {
		super();
		this.idMatricula = idMatricula;
		this.periodo = periodo;
		this.fecha = fecha;
		this.hora = hora;
		this.codigoColegio = codigoColegio;
		this.idAlumno = idAlumno;
		this.idSeccion = idSeccion;
		this.situacion = situacion;
		this.antcolegio = antcolegio;
		this.estado=estado;
	}




	@Id @GeneratedValue(strategy=IDENTITY)
    @Column(name="IdMatricula", unique=true, nullable=false)
    public Integer getIdMatricula() {
        return this.idMatricula;
    }
    
    public void setIdMatricula(Integer idMatricula) {
        this.idMatricula = idMatricula;
    }

    

    @Column(name="IdAlumno", nullable=false, length=8)
   public String getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(String idAlumno) {
		this.idAlumno = idAlumno;
	}

	     
    @Column(name="Periodo", nullable=false, length=6)
    public String getPeriodo() {
        return this.periodo;
    }
    
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    
    @Column(name="idSeccion", length=5)
    public Integer getIdSeccion() {
        return this.idSeccion;
    }
    
    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    
    @Column(name="codigoColegio", nullable=false, length=11)
    public String getCodigoColegio() {
        return this.codigoColegio;
    }
    
    public void setCodigoColegio(String codigoColegio) {
        this.codigoColegio = codigoColegio;
    }


    @Column(name="Situacion", nullable=false, length=20)
	public String getSituacion() {
		return situacion;
	}


	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}


    @Column(name="AntColegio", nullable=false, length=20)
	public String getAntcolegio() {
		return antcolegio;
	}


	public void setAntcolegio(String antcolegio) {
		this.antcolegio = antcolegio;
	}



	 @Column(name="Fecha", nullable=false, length=10)
		public String getFecha() {
		return fecha;
	}




	public void setFecha(String fecha) {
		this.fecha = fecha;
	}



	 @Column(name="Hora", nullable=false, length=10)
		public String getHora() {
		return hora;
	}




	public void setHora(String hora) {
		this.hora = hora;
	}



	 @Column(name="Estado", nullable=false, length=10)
	public String getEstado() {
		return estado;
	}




	public void setEstado(String estado) {
		this.estado = estado;
	}





}


