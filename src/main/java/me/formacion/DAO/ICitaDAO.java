package me.formacion.DAO;

import java.util.Date;

import me.formacion.model.Cita;

public interface ICitaDAO {
	Cita getById(Long id);
	Cita[] getAll();
	Cita[] getAtDate(Date start, Date end);
	void store(Cita d);
	void remove(Cita d);
}
