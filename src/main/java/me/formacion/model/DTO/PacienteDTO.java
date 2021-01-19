package me.formacion.model.DTO;

import java.util.HashSet;
import java.util.Set;

public class PacienteDTO extends UsuarioDTO{

    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
	private Set<CitaWithIdDTO> citas = new HashSet<>();
	private Set<MedicoWithIdDTO> medicos = new HashSet<>();
	
	public PacienteDTO(Long id, String nombre, String apellidos, String usuario, String NSS, String numTarjeta,
			String telefono, String direccion, Set<CitaWithIdDTO> citas, Set<MedicoWithIdDTO> medicos) {
		super(id, nombre, apellidos, usuario);
		this.NSS = NSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
		this.citas = citas;
		this.medicos = medicos;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String nSS) {
		NSS = nSS;
	}

	public String getNumTarjeta() {
		return numTarjeta;
	}

	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<CitaWithIdDTO> getCitas() {
		return citas;
	}

	public void setCitas(Set<CitaWithIdDTO> citas) {
		this.citas = citas;
	}

	public Set<MedicoWithIdDTO> getMedicos() {
		return medicos;
	}

	public void setMedicos(Set<MedicoWithIdDTO> medicos) {
		this.medicos = medicos;
	}
}
