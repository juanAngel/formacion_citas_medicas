package me.formacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.formacion.DAO.IPacienteDAO;
import me.formacion.model.Paciente;

@Service
@Transactional
public class PacienteService {
	@Autowired
	private IPacienteDAO pacienteDAO;

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

}
