package com.certus.edu.pe.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;




@Entity
@Table(name= "profesor")
@NamedQueries({
	@NamedQuery(name = "Profesor.findAll", query = "SELECT p FROM Profesor p")
	,@NamedQuery(name = "Profesor.findByIdprofesor", query="SELECT p FROM Profesor p WHERE p.idProfesor = :idProfesor")
	, @NamedQuery(name = "Profesor.findByProfesor_Dni", query = "SELECT p FROM Profesor p WHERE p.Profesor_dni = :Profesor_dni")
    , @NamedQuery(name = "Profesor.findByPrimer_Nombre", query = "SELECT p FROM Profesor p WHERE p.primer_nombre = :primer_nombre ")
    , @NamedQuery(name = "Profesor.findBySegundo_Nombre", query = "SELECT p FROM Profesor p WHERE p.segundo_nombre = :segundo_nombre")
    , @NamedQuery(name = "Profesor.findByApellido_Paterno", query = "SELECT p FROM Profesor p WHERE p.apellido_paterno = :apellido_paterno")
    , @NamedQuery(name = "Profesor.findByApellido_Materno", query = "SELECT p FROM Profesor p WHERE p.apellido_materno = :apellido_materno")
    , @NamedQuery(name = "Profesor.findByTelefono", query = "SELECT p FROM Profesor p WHERE p.telefono = :telefono")
    , @NamedQuery(name = "Profesor.findByCorreo", query = "SELECT p FROM Profesor p WHERE p.correo = :correo")})
	




public class Profesor implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)// representa que este campo es obligatorio en base de datos
	@Column(name = "idProfesor")
	private Integer idProfesor;
	
	@Basic(optional = false)
	@Column(name = "Profesor_dni")
	private String Profesor_dni;
	
	
	@Column(name= "primer_nombre")
	private String primer_nombre;
	
	@Column(name = "segundo_nombre")
	private String segundo_nombre;
	
	@Column(name="apellido_paterno")
	private String apellido_paterno;
	
	@Column(name = "apellido_materno")
	private String apellido_materno;
	
	@Column(name = "telefono")
		private String telefono;
	
	@Column(name = "correo")
		private String correo;
	
	
	public Profesor() {
    	
    }
	
    public Profesor (Integer idProfesor, String Profesor_dni) {
    	
    	this.idProfesor = idProfesor;
    	this.Profesor_dni= Profesor_dni;
    }

	public Integer getIdProfesor() {
		return idProfesor;
	}

	public void setIdProfesor(Integer idProfesor) {
		this.idProfesor = idProfesor;
	}

	public String getProfesor_dni() {
		return Profesor_dni;
	}

	public void setProfesor_dni(String Profesor_dni) {
		this.Profesor_dni = Profesor_dni;
	}

	public String getPrimer_nombre() {
		return primer_nombre;
	}

	public void setPrimer_nombre(String primer_nombre) {
		this.primer_nombre = primer_nombre;
	}

	public String getSegundo_nombre() {
		return segundo_nombre;
	}

	public void setSegundo_nombre(String segundo_nombre) {
		this.segundo_nombre = segundo_nombre;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno= apellido_paterno;
		
	}
	
	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}
	

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}



	public Profesor(String Profesor_dni, String primer_nombre, String segundo_nombre, String apellido_paterno, String apellido_materno, String telefono,
			String correo) {
		super();
		this.Profesor_dni = Profesor_dni;
		this.primer_nombre = primer_nombre;
		this.segundo_nombre = segundo_nombre;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.telefono = telefono;
		this.correo = correo;
	}
	
	
	@Override
	public String toString() {
		return "Profesor [IdProfesor=" + idProfesor + ", Profesor_dni=" + Profesor_dni + ", primer_nombre=" + primer_nombre
				+ ",  segundo_nombre=" +  segundo_nombre + ", apellido_paterno=" + apellido_paterno + ", apellido_materno=" + apellido_materno + ", telefono="
				+ telefono + ", correo=" + correo + "]";
	}
	
	
	
	
	

}
