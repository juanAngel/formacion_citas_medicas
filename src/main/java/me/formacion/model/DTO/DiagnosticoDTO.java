package me.formacion.model.DTO;

public class DiagnosticoDTO {
	private Long id;
	private CitaWithIdDTO cita;
    private String valoracionEspecialista;
    private String enfermedad;
    
	public DiagnosticoDTO(Long id, CitaWithIdDTO cita, String valoracionEspecialista, String enfermedad) {
		super();
		this.id = id;
		this.cita = cita;
		this.valoracionEspecialista = valoracionEspecialista;
		this.enfermedad = enfermedad;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CitaWithIdDTO getCita() {
		return cita;
	}

	public void setCita(CitaWithIdDTO cita) {
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
