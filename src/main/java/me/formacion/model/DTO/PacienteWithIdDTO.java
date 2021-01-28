package me.formacion.model.DTO;

import java.util.HashSet;
import java.util.Set;

public class PacienteWithIdDTO extends UsuarioDTO{
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
	private Set<Long> citas = new HashSet<>();
	private Set<Long> medicos = new HashSet<>();
	
	public PacienteWithIdDTO() {
	}
	public PacienteWithIdDTO(Long id, String nombre, String apellidos, String usuario, String nSS,
			String numTarjeta, String telefono, String direccion) {
		super(id, nombre, apellidos, usuario);
		NSS = nSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
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

	public Set<Long> getCitas() {
		return citas;
	}

	public void setCitas(Set<Long> citas) {
		this.citas = citas;
	}

	public Set<Long> getMedicos() {
		return medicos;
	}

	public void setMedicos(Set<Long> medicos) {
		this.medicos = medicos;
	}
}
