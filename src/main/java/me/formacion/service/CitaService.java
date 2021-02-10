package me.formacion.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.formacion.DAO.ICitaDAO;
import me.formacion.DAO.IDiagnosticoDAO;
import me.formacion.DAO.IMedicoDAO;
import me.formacion.DAO.IPacienteDAO;
import me.formacion.model.Cita;
import me.formacion.model.Diagnostico;
import me.formacion.model.Medico;
import me.formacion.model.Paciente;

@Service
@Transactional
public class CitaService {
	@Autowired
	private IDiagnosticoDAO diagnosticoDAO;
	@Autowired
	private ICitaDAO citaDAO;
	@Autowired
	private IMedicoDAO medicoDAO;
	@Autowired
	private IPacienteDAO pacienteDAO;

	public CitaService(ICitaDAO citaDAO) {
		super();
		this.citaDAO = citaDAO;
	}

	public Cita getOne(long id) {
		if(id == 0)
			return null;
		return citaDAO.getById(id);
	}
	
	public Cita[] getAll() {
		return citaDAO.getAll();
	}
	
	public Cita save(Cita c) {
		citaDAO.store(c);
		
		return c;
	}
	
	public void remove(Cita c) {
		Medico m = c.getMedico();
		Paciente p = c.getPaciente();
		
		p.getCitas().remove(c);
		m.getCitas().remove(c);
		
		pacienteDAO.store(p);
		medicoDAO.store(m);
		
		citaDAO.remove(c);
	}

	public Cita setDiagnostico(Cita c, Diagnostico d) {
		
		c = citaDAO.merge(c);
		c.setDiagnostico(d);
		d.setCita(c);
		diagnosticoDAO.store(d);		
		
		return c;
	}
	public Cita setDatetime(Cita c, Date datetime) {
		c = citaDAO.merge(c);
		c.setFechaHora(datetime);
		
		return c;
	}
	
	public Cita[] getAtDate(Date start, Date end) {
		return citaDAO.getAtDate(start, end);
	}

}
