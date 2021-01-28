package me.formacion.model.DTO;

public class DiagnosticoWithIdDTO {
	private long id;
	private long cita;
    private String valoracionEspecialista;
    private String enfermedad;
    
    public DiagnosticoWithIdDTO() {
	}
    
	public DiagnosticoWithIdDTO(long id, long cita, String valoracionEspecialista, String enfermedad) {
		super();
		this.id = id;
		this.cita = cita;
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getCita() {
		return cita;
	}

	public void setCita(long cita) {
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
