package me.formacion.mock;

import java.util.Date;

import me.formacion.DAO.ICitaDAO;
import me.formacion.model.Cita;

public class CitaDAOMock implements ICitaDAO {

	@Override
	public Cita getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cita[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Cita d) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Cita d) {
		// TODO Auto-generated method stub

	}

	@Override
	public Cita[] getAtDate(Date start, Date end) {
		// TODO Auto-generated method stub
		return null;
	}

}
