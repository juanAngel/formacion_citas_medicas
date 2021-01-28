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
import me.formacion.model.Usuario;

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
		if(id == 0)
			return null;
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

	public Paciente[] findByNombre(String name) {
		Usuario[] pacientes = pacienteDAO.findByNombre(name);

		return (Paciente[]) pacientes;
	}
	public Paciente[] findByApellidos(String apellidos) {
		Usuario[] pacientes = pacienteDAO.findByApellidos(apellidos);

		return (Paciente[]) pacientes;
	}
	public Paciente[] findByUsuario(String usuario) {
		Usuario[] pacientes = pacienteDAO.findByUsuario(usuario);

		return (Paciente[]) pacientes;
	}
	public Paciente[] findByTelefono(String telefono) {
		Usuario[] pacientes = pacienteDAO.findByTelefono(telefono);
		
		return (Paciente[]) pacientes;
	}
	public Paciente[] findByNumTarjeta(String numTarjeta) {
		Usuario[] pacientes = pacienteDAO.findByNumTarjeta(numTarjeta);
		
		return (Paciente[]) pacientes;
	}

	public void remove(Paciente paciente) {
		//Elimina las citas
		for(Cita cita: paciente.getCitas()) {
			removeCita(cita.getMedico(), cita.getPaciente(), cita);
		}
		//Desvincula a los medicos del paciente
		for (Medico medico : paciente.getMedicos()) {
			medico.getPacientes().remove(paciente);
			medicoDAO.store(medico);
		}
		
		pacienteDAO.remove(paciente);
	}
}
