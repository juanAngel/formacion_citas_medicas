package me.formacion.DAO;

import me.formacion.model.Cita;

public interface ICitaDAO {
	Cita getById(Long id);
	Cita[] getAll();
	void store(Cita d);
	void delete(Cita d);
}
