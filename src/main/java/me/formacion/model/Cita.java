package me.formacion.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * 
 */
@Entity
public class Cita implements IUnique{
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@OneToOne(targetEntity = Diagnostico.class)
	private Diagnostico diagnostico;
	@ManyToOne(targetEntity = Medico.class)
	private Medico medico;
	@ManyToOne(targetEntity = Paciente.class)
	private Paciente paciente;
	@Column
	@Temporal(TemporalType.DATE)
    private Date fechaHora;
    private String motivoCita;
    private int attibute11;

    public Cita() {
        super();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Diagnostico getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(Diagnostico diagnostico) {
		this.diagnostico = diagnostico;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	public String getMotivoCita() {
		return motivoCita;
	}

	public void setMotivoCita(String motivoCita) {
		this.motivoCita = motivoCita;
	}

	public int getAttibute11() {
		return attibute11;
	}

	public void setAttibute11(int attibute11) {
		this.attibute11 = attibute11;
	}
}