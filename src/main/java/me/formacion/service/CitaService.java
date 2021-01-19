package me.formacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.formacion.DAO.ICitaDAO;
import me.formacion.DAO.IMedicoDAO;
import me.formacion.model.Cita;

@Service
@Transactional
public class CitaService {
	@Autowired
	private ICitaDAO citaDAO;

	public CitaService(ICitaDAO citaDAO) {
		super();
		this.citaDAO = citaDAO;
	}

	public Cita getOne(long id) {
		return citaDAO.getById(id);
	}
	public Cita[] getAll() {
		return citaDAO.getAll();
	}

}
