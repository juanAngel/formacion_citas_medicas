package me.formacion.model.DTO;

import java.util.HashSet;
import java.util.Set;

public class MedicoDTO extends UsuarioDTO{
	private Set<PacienteWithIdDTO> pacientes = new HashSet<>();
	private Set<CitaWithIdDTO> citas = new HashSet<>();
    private String numColegiado;
    
	public MedicoDTO(Long id, String nombre, String apellidos, String usuario, String numColegiado) {
		super(id, nombre, apellidos, usuario);
		this.numColegiado = numColegiado;
	}

	public Set<PacienteWithIdDTO> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Set<PacienteWithIdDTO> pacientes) {
		this.pacientes = pacientes;
	}

	public Set<CitaWithIdDTO> getCitas() {
		return citas;
	}

	public void setCitas(Set<CitaWithIdDTO> citas) {
		this.citas = citas;
	}

	public String getNumColegiado() {
		return numColegiado;
	}

	public void setNumColegiado(String numColegiado) {
		this.numColegiado = numColegiado;
	}
    
    
}
