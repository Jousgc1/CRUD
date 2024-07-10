package com.certus.edu.pe.modelo;

import java.io.Serializable;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "horarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "horarios.findAll", query = "SELECT h FROM horarios h"),
    @NamedQuery(name = "horarios.findByIdHorario", query = "SELECT h FROM horarios h WHERE h.idHorario = :idHorario"),
    @NamedQuery(name = "horarios.findByIdCurso", query = "SELECT h FROM horarios h WHERE h.idCurso = :idCurso"),
    @NamedQuery(name = "horarios.findByDia", query = "SELECT h FROM horarios h WHERE h.dia = :dia"),
    @NamedQuery(name = "horarios.findByHoraInicio", query = "SELECT h FROM horarios h WHERE h.horaInicio = :horaInicio"),
    @NamedQuery(name = "horarios.findByHoraFin", query = "SELECT h FROM horarios h WHERE h.horaFin = :horaFin")
})
public class horarios implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idHorarios")
    private Integer idHorario;

    @Column(name = "id_curso")
    private Integer idCurso;

    @Column(name = "dia")
    private String dia;

    @Column(name = "hora_inicio")
    private java.sql.Time horaInicio;

    @Column(name = "hora_fin")
    private java.sql.Time horaFin;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_curso", referencedColumnName = "idCurso", insertable = false, updatable = false)
    @JsonBackReference
    private Curso curso;

    public horarios() {
    }

    public horarios(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public java.sql.Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(java.sql.Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public java.sql.Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(java.sql.Time horaFin) {
        this.horaFin = horaFin;
    }

    @XmlTransient
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idHorario != null ? idHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof horarios)) {
            return false;
        }
        horarios other = (horarios) object;
        if ((this.idHorario == null && other.idHorario != null) || (this.idHorario != null && !this.idHorario.equals(other.idHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "certus.edu.pe.modelo.Horario[ idHorario=" + idHorario + " ]";
    }
}
