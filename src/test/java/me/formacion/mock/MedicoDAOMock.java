package me.formacion.mock;

import me.formacion.DAO.IMedicoDAO;
import me.formacion.model.Medico;
import me.formacion.model.Usuario;

public class MedicoDAOMock implements IMedicoDAO {

	@Override
	public Usuario getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario[] getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void store(Usuario p) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Usuario p) {
		// TODO Auto-generated method stub

	}

	@Override
	public Usuario[] findByNombre(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario[] findByApellidos(String apellidos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario[] findByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medico[] findByNumColegiado(String numColegiado) {
		// TODO Auto-generated method stub
		return null;
	}

}
