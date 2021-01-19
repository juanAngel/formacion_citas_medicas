package me.formacion.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import me.formacion.Config;
import me.formacion.model.Paciente;
import me.formacion.model.Usuario;

@Repository
public class PacienteJPA implements IPacienteDAO {
	@PersistenceContext(unitName = Config.PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	public PacienteJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Paciente getById(Long id) {
		return null;
	}

	@Override
	public Paciente[] getAll() {
		Paciente[] result = null;
		
		return result;
	}

	@Override
	public void store(Usuario p) {
		
	}

	@Override
	public Usuario[] findByNombre(String name) {
		Paciente[] result = null;
		
		return result;
	}

	@Override
	public Usuario[] findByApellidos(String apellidos) {
		Paciente[] result = null;
		
		return result;
	}

	@Override
	public Usuario[] findByUsuario(String usuario) {
		Paciente[] result = null;
		
		return result;
	}

	@Override
	public Paciente[] findByTelefono(String telefono) {
		Paciente[] result = null;
		
		return result;
	}

	@Override
	public Paciente[] findByNumTarjeta(String numTarjeta) {
		Paciente[] result = null;
		
		return result;
	}

	@Override
	public void delete(Usuario p) {
		// TODO Auto-generated method stub
		
	}

}
