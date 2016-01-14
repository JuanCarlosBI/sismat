package com.juancarlos.sismat.dominio;
// Generated 20-abr-2015 23:35:22 by Hibernate Tools 3.6.0


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

/**
 * Nivel generated by hbm2java
 */
@Entity
@Table(name="nivel"
    ,catalog="dbcolegio2"
)
public class Nivel  implements java.io.Serializable {


     /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Short idNivel;
     private Empleado empleadosByTutor;
     private Empleado empleadosByCoTutor;
     private String grado;
     private String orden;
     
     private char estado;
     private String tipo;
     private String nroVacantes;
     public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	 @Column(name="NroVacantes", nullable=false)
	public String getNroVacantes() {
		return nroVacantes;
	}


	public void setNroVacantes(String nroVacantes) {
		this.nroVacantes = nroVacantes;
	}



	private String codigoColegio;
     private Set<Horarios> horarioses = new HashSet<Horarios>(0);
     private Set<Matriculas> matriculases = new HashSet<Matriculas>(0);

    public Nivel() {
    }


   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IdNivel", unique=true, nullable=false)
    public Short getIdNivel() {
        return this.idNivel;
    }
    
    public void setIdNivel(Short idNivel) {
        this.idNivel = idNivel;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Tutor", nullable=false)
    public Empleado getEmpleadosByTutor() {
        return this.empleadosByTutor;
    }
    
    public void setEmpleadosByTutor(Empleado empleadosByTutor) {
        this.empleadosByTutor = empleadosByTutor;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CoTutor", nullable=false)
    public Empleado getEmpleadosByCoTutor() {
        return this.empleadosByCoTutor;
    }
    
    public void setEmpleadosByCoTutor(Empleado empleadosByCoTutor) {
        this.empleadosByCoTutor = empleadosByCoTutor;
    }

    
    @Column(name="Grado", nullable=false, length=60)
    public String getGrado() {
        return this.grado;
    }
    
    public void setGrado(String grado) {
        this.grado = grado;
    }

    
    @Column(name="Orden", nullable=false, length=10)
    public String getOrden() {
        return this.orden;
    }
    
    public void setOrden(String orden) {
        this.orden = orden;
    }

    
   

    
    @Column(name="Estado", nullable=false, length=1)
    public char getEstado() {
        return this.estado;
    }
    
    public void setEstado(char estado) {
        this.estado = estado;
    }

    
    @Column(name="CodigoColegio", nullable=false, length=11)
    public String getCodigoColegio() {
        return this.codigoColegio;
    }
    
    public void setCodigoColegio(String codigoColegio) {
        this.codigoColegio = codigoColegio;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="nivel")
    public Set<Horarios> getHorarioses() {
        return this.horarioses;
    }
    
    public void setHorarioses(Set<Horarios> horarioses) {
        this.horarioses = horarioses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="nivel")
    public Set<Matriculas> getMatriculases() {
        return this.matriculases;
    }
    
    public void setMatriculases(Set<Matriculas> matriculases) {
        this.matriculases = matriculases;
    }




}


