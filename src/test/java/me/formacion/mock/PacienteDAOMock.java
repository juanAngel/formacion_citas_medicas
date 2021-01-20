package me.formacion.mock;

import me.formacion.DAO.IPacienteDAO;
import me.formacion.model.Paciente;
import me.formacion.model.Usuario;

public class PacienteDAOMock implements IPacienteDAO{

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
	public Paciente[] findByTelefono(String telefono) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Paciente[] findByNumTarjeta(String numTarjeta) {
		// TODO Auto-generated method stub
		return null;
	}

}
