package com.certus.edu.pe.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c"),
    @NamedQuery(name = "Curso.findByIdCurso", query = "SELECT c FROM Curso c WHERE c.idCurso = :idCurso"),
    @NamedQuery(name = "Curso.findByCursoNombre", query = "SELECT c FROM Curso c WHERE c.cursoNombre = :cursoNombre"),
    @NamedQuery(name = "Curso.findByProfesorId", query = "SELECT c FROM Curso c WHERE c.profesorId = :profesorId")
})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCurso")
    private Integer idCurso;

    @Basic(optional = false)
    @Column(name = "Curso_Nombre")
    private String cursoNombre;

    @Lob
    @Column(name = "Curso_Descripcion")
    private String cursoDescripcion;

    @Column(name = "Profesor_id")
    private Integer profesorId;

    @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL)
    private List<Estudiante> estudianteList = new ArrayList<>();

    
    
    public void addEstudiante(Estudiante estudiante) {
        estudianteList.add(estudiante);
        estudiante.setCurso(this);
    }

    public void removeEstudiante(Estudiante estudiante) {
        estudianteList.remove(estudiante);
        estudiante.setCurso(null);
    }


    public Curso() {
    }

    public Curso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(Integer idCurso, String cursoNombre, String cursoDescripcion, Integer profesorId) {
        this.idCurso = idCurso;
        this.cursoNombre = cursoNombre;
        this.cursoDescripcion = cursoDescripcion;
        this.profesorId = profesorId;
    }

    // Getters and setters

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getCursoNombre() {
        return cursoNombre;
    }

    public void setCursoNombre(String cursoNombre) {
        this.cursoNombre = cursoNombre;
    }

    public String getCursoDescripcion() {
        return cursoDescripcion;
    }

    public void setCursoDescripcion(String cursoDescripcion) {
        this.cursoDescripcion = cursoDescripcion;
    }

    public Integer getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(Integer profesorId) {
        this.profesorId = profesorId;
    }

    @XmlTransient
    public List<Estudiante> getEstudianteList() {
        return estudianteList;
    }

    public void setEstudianteList(List<Estudiante> estudianteList) {
        this.estudianteList = estudianteList;
    }

    // hashCode, equals, and toString methods

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCurso != null ? idCurso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.idCurso == null && other.idCurso != null) || (this.idCurso != null && !this.idCurso.equals(other.idCurso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.certus.edu.pe.modelo.Curso[ idCurso=" + idCurso + " ]";
    }
}
