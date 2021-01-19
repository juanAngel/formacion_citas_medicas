package me.formacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import me.formacion.DAO.IDiagnosticoDAO;
import me.formacion.DAO.PersistenceFactory;
import me.formacion.model.Diagnostico;

@Service
@Transactional
public class DiagnosticoService {
	@Autowired
	private IDiagnosticoDAO diagnosticoDAO;
	
	public DiagnosticoService(IDiagnosticoDAO diagnosticoDAO) {
		this.diagnosticoDAO = diagnosticoDAO;
	}

	public Diagnostico getOne(long id) {
		return diagnosticoDAO.getById(id);
	}
	public Diagnostico[] getAll() {
		return diagnosticoDAO.getAll();
	}

}
