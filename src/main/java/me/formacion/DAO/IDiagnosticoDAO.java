package me.formacion.DAO;

import me.formacion.model.Diagnostico;

public interface IDiagnosticoDAO {
	Diagnostico getById(Long id);
	Diagnostico[] getAll();
	void store(Diagnostico d);
	void delete(Diagnostico d);
}
