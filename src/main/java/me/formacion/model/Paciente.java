package me.formacion.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 * 
 */
@Entity
public class Paciente extends Usuario{
	@ManyToMany(targetEntity = Medico.class)
	private Set<Medico> medicos;
    private String NSS;
    private String numTarjeta;
    private String telefono;
    private String direccion;
	@OneToMany(targetEntity = Cita.class)
	private Set<Cita> citas;
    
	public Paciente(String nombre, String apellidos, String usuario, String clave, String NSS, String numTarjeta,
			String telefono, String direccion) {
		super(nombre, apellidos, usuario, clave);
		this.NSS = NSS;
		this.numTarjeta = numTarjeta;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Set<Medico> getMedicos() {
		return medicos;
	}

	public void setMedico(Set<Medico> medicos) {
		this.medicos = medicos;
	}

	public String getNSS() {
		return NSS;
	}

	public void setNSS(String NSS) {
		this.NSS = NSS;
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

	public Set<Cita> getCitas() {
		return citas;
	}

	public void setCitas(Set<Cita> citas) {
		this.citas = citas;
	}
}