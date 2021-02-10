package me.formacion.DAO;

import me.formacion.model.Medico;
import me.formacion.model.Usuario;

public interface IMedicoDAO extends IUsuarioDAO{
	Medico[] findByNumColegiado(String numColegiado);
	Medico merge(Usuario p);
}
