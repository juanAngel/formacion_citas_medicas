package me.formacion.DAO;

import me.formacion.model.Medico;

public interface IMedicoDAO extends IUsuarioDAO{
	Medico[] findByNumColegiado(String numColegiado);
}
