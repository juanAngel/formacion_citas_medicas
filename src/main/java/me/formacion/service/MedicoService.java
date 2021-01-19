package me.formacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.formacion.DAO.ICitaDAO;
import me.formacion.DAO.IMedicoDAO;
import me.formacion.DAO.IPacienteDAO;
import me.formacion.model.Cita;
import me.formacion.model.Medico;
import me.formacion.model.Paciente;

@Service
@Transactional
public class MedicoService {
	@Autowired
	private IMedicoDAO medicoDAO;
	@Autowired
	private IPacienteDAO pacienteDAO;
	@Autowired
	private ICitaDAO citaDAO;

	@Autowired
	public MedicoService(IMedicoDAO medicoDAO, IPacienteDAO pacienteDAO, ICitaDAO citaDAO) {
		super();
		this.medicoDAO = medicoDAO;
		this.pacienteDAO = pacienteDAO;
		this.citaDAO = citaDAO;
	}
	
	public Medico save(Medico m) {
		medicoDAO.store(m);
		return m;
	}
	public void update(Medico m) {
		
	}
	public void remove(Medico m) {
		
	}
	public Medico getOne(long id) {
		return (Medico) medicoDAO.getById(id);
	}
	public Medico[] getAll() {
		return (Medico[]) medicoDAO.getAll();
	}
	public Medico addPaciente(Medico m,Paciente p) {
		return null;
	}
	public Medico removePaciente(Medico m,Paciente p) {
		return null;
	}
	public Medico addCita(Medico m,Cita c) {
		return null;
	}
	public Medico removeCita(Medico m,Cita c) {
		return null;
	}

}
