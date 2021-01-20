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
public class PacienteService {
	@Autowired
	private IMedicoDAO medicoDAO;
	@Autowired
	private IPacienteDAO pacienteDAO;
	@Autowired
	private ICitaDAO citaDAO;

	@Autowired
	public PacienteService(IPacienteDAO pacienteDAO) {
		super();
		this.pacienteDAO = pacienteDAO;
	}
	
	public Paciente save(Paciente p) {
		pacienteDAO.store(p);
		return p;
	}
	
	public Paciente update(Paciente p) {
		pacienteDAO.store(p);
		return p;
	}

	public Paciente getOne(long id) {
		return (Paciente) pacienteDAO.getById(id);
	}
	public Paciente[] getAll() {
		return (Paciente[]) pacienteDAO.getAll();
	}
	public Paciente addMedico(Medico m,Paciente p) {
		m.getPacientes().add(p);
		p.getMedicos().add(m);
		medicoDAO.store(m);
		pacienteDAO.store(p);
		return p;
	}
	public Paciente removeMedico(Medico m,Paciente p) {
		m.getPacientes().remove(p);
		p.getMedicos().remove(m);
		medicoDAO.store(m);
		pacienteDAO.store(p);
		return p;
	}
	public Paciente addCita(Medico m,Paciente p,Cita c) {
		m.getCitas().add(c);
		p.getCitas().add(c);
		c.setMedico(m);
		c.setPaciente(p);
		
		medicoDAO.store(m);
		pacienteDAO.store(p);
		citaDAO.store(c);
		return p;
	}
	public Paciente removeCita(Medico m,Paciente p,Cita c) {
		m.getCitas().remove(c);
		p.getCitas().remove(c);
		c.setMedico(null);
		c.setPaciente(null);
		medicoDAO.store(m);
		pacienteDAO.store(p);
		citaDAO.store(c);
		return p;
	}
}
