package me.formacion.model.DTO;

import java.util.HashSet;
import java.util.Set;

public class MedicoWithIdDTO extends UsuarioDTO{
	private Set<Long> pacientes = new HashSet<>();
	private Set<Long> citas = new HashSet<>();
    private String numColegiado;
    
    public MedicoWithIdDTO() {
    	super();
	}
	public MedicoWithIdDTO(Long id, String nombre, String apellidos, String usuario, String numColegiado) {
		super(id, nombre, apellidos, usuario);
		this.numColegiado = numColegiado;
	}

	public Set<Long> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<Long> pacientes) {
		this.pacientes = pacientes;
	}

	public Set<Long> getCitas() {
		return citas;
	}

	public void setCitas(Set<Long> citas) {
		this.citas = citas;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}
}
