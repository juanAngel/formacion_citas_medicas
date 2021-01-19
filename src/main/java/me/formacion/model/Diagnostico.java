package me.formacion.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * 
 */
@Entity
public class Diagnostico implements IUnique{
	@Id
	private Long id;
	@OneToOne(targetEntity = Cita.class)
	private Cita cita;
    private String valoracionEspecialista;
    private String enfermedad;

    public Diagnostico() {
        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public String getValoracionEspecialista() {
		return valoracionEspecialista;
	}

	public void setValoracionEspecialista(String valoracionEspecialista) {
		this.valoracionEspecialista = valoracionEspecialista;
	}

	public String getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		this.enfermedad = enfermedad;
	}
    
}