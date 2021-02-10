package me.formacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.formacion.DAO.ICitaDAO;
import me.formacion.DAO.IDiagnosticoDAO;
import me.formacion.DAO.IMedicoDAO;
import me.formacion.DAO.IPacienteDAO;
import me.formacion.DAO.MedicoJPA;
import me.formacion.model.Cita;
import me.formacion.model.Diagnostico;
import me.formacion.model.Medico;
import me.formacion.model.Paciente;
import me.formacion.model.Usuario;

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
	private IDiagnosticoDAO diagnosticoDAO;

	@Autowired
	public MedicoService(IMedicoDAO medicoDAO, IPacienteDAO pacienteDAO, ICitaDAO citaDAO) {
		super();
		this.medicoDAO = medicoDAO;
		this.pacienteDAO = pacienteDAO;
		this.citaDAO = citaDAO;
	}
	
	@Transactional
	public Medico save(Medico m) {
		medicoDAO.store(m);
		return m;
	}
	
	public void remove(Medico m) {
		m = medicoDAO.merge(m);
		//Elimina las citas
		for(Cita cita: m.getCitas()) {
			removeCita(cita);
		}
		//Desvincula a los pacientes del medico
		for (Paciente paciente : m.getPacientes()) {
			paciente.getMedicos().remove(m);
			pacienteDAO.store(paciente);
		}
		medicoDAO.remove(m);
	}
	
	public Medico getOne(long id) {
		if(id == 0)
			return null;
		return (Medico) medicoDAO.getById(id);
	}
	
	public Medico[] getAll() {
		return (Medico[]) medicoDAO.getAll();
	}
	
	public Medico addPaciente(Medico m,Paciente p) {
		m = medicoDAO.merge(m);
		p = pacienteDAO.merge(p);
		
		m.getPacientes().add(p);
		p.getMedicos().add(m);
		return m;
	}
	
	public Medico removePaciente(Medico m,Paciente p) {
		m = medicoDAO.merge(m);
		p = pacienteDAO.merge(p);
		
		m.getPacientes().remove(p);
		p.getMedicos().remove(m);
		return m;
	}
	
	public Medico addCita(Medico m,Paciente p,Cita c) {
		m = medicoDAO.merge(m);
		p = pacienteDAO.merge(p);
		c = citaDAO.merge(c);
		
		m.getCitas().add(c);
		p.getCitas().add(c);
		c.setMedico(m);
		c.setPaciente(p);
		
		return m;
	}
	
	public Medico removeCita(Cita c) {
		c = citaDAO.merge(c);
		Medico m = c.getMedico();
		Paciente p = c.getPaciente();
		Diagnostico d = c.getDiagnostico();
		
		m.getCitas().remove(c);
		p.getCitas().remove(c);
		c.setMedico(null);
		c.setPaciente(null);
		if(d != null) {
			d.setCita(null);
			c.setDiagnostico(null);
			diagnosticoDAO.remove(d);
		}
		
		citaDAO.remove(c);
		
		return m;
	}

	public Medico[] findByNombre(String name) {
		Usuario[] medicos = medicoDAO.findByNombre(name);
		
		return (Medico[]) medicos;
	}
	
	public Medico[] findByApellidos(String apellidos) {
		Usuario[] medicos = medicoDAO.findByApellidos(apellidos);
		
		return (Medico[]) medicos;
	}
	
	public Medico[] findByUsuario(String usuario) {
		Usuario[] medicos = medicoDAO.findByUsuario(usuario);
		
		return (Medico[]) medicos;
	}

	public Medico[] findByNumColegiado(String numColegiado) {
		Medico[] medicos = medicoDAO.findByNumColegiado(numColegiado);
		
		return medicos;
	}

}
