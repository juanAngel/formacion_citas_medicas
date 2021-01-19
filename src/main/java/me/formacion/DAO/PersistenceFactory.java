package me.formacion.DAO;

public abstract class PersistenceFactory {
	private ICitaDAO cita;
	private IDiagnosticoDAO diagnostico;
	private IMedicoDAO medico;
	private IPacienteDAO paciente;
	
	protected void setCita(ICitaDAO cita) {
		this.cita = cita;
	}
	protected void setDiagnostico(IDiagnosticoDAO diagnostico) {
		this.diagnostico = diagnostico;
	}
	protected void setMedico(IMedicoDAO medico) {
		this.medico = medico;
	}
	
	protected void setPaciente(IPacienteDAO paciente) {
		this.paciente = paciente;
	}
	public ICitaDAO getCita() {
		return cita;
	}
	public IDiagnosticoDAO getDiagnostico() {
		return diagnostico;
	}
	public IMedicoDAO getMedico() {
		return medico;
	}
	public IPacienteDAO getPaciente() {
		return paciente;
	}

}
