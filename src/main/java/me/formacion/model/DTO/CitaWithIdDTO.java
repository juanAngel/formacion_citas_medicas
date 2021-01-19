package me.formacion.model.DTO;

public class CitaWithIdDTO {
	private long id;
	private long diagnostico;
	private long medico;
	private long paciente;
    private long fechaHora;
    private String motivoCita;
    private int attibute11;
    
	public CitaWithIdDTO(long id, long fechaHora, String motivoCita, int attibute11) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.attibute11 = attibute11;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(long diagnostico) {
		this.diagnostico = diagnostico;
	}

	public long getMedico() {
		return medico;
	}

	public void setMedico(long medico) {
		this.medico = medico;
	}

	public long getPaciente() {
		return paciente;
	}

	public void setPaciente(long paciente) {
		this.paciente = paciente;
	}

	public long getFechaHora() {
		return fechaHora;
	}

	public void setFechaHora(long fechaHora) {
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
