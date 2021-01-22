package me.formacion.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;


/**
 * 
 */
@Entity
public class Medico extends Usuario{
    private String numColegiado;
	@ManyToMany(targetEntity = Paciente.class)
	private Set<Paciente> pacientes = new HashSet<>();
	@OneToMany(targetEntity = Cita.class)
	private Set<Cita> citas;


    public Medico() {
    	super();
	}
	public Medico(String nombre, String apellidos, String usuario, String clave, String numColegiado) {
		super(nombre, apellidos, usuario, clave);
		this.numColegiado = numColegiado;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}

	public Set<Paciente> getPacientes() {		
		return this.pacientes;
	}

	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
}