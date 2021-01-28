package me.formacion.model.DTO;


public class CitaDTO {
	private Long id;
	private DiagnosticoWithIdDTO diagnostico;
	private MedicoWithIdDTO medico;
	private PacienteWithIdDTO paciente;
    private long fechaHora;
    private String motivoCita;
    private int attibute11;
    
    public CitaDTO() {
	}
    
	public CitaDTO(Long id, long fechaHora, String motivoCita, int attibute11) {
		super();
		this.id = id;
		this.fechaHora = fechaHora;
		this.motivoCita = motivoCita;
		this.attibute11 = attibute11;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DiagnosticoWithIdDTO getDiagnostico() {
		return diagnostico;
	}

	public void setDiagnostico(DiagnosticoWithIdDTO diagnostico) {
		this.diagnostico = diagnostico;
	}

	public MedicoWithIdDTO getMedico() {
		return medico;
	}

	public void setMedico(MedicoWithIdDTO medico) {
		this.medico = medico;
	}

	public PacienteWithIdDTO getPaciente() {
		return paciente;
	}

	public void setPaciente(PacienteWithIdDTO paciente) {
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
