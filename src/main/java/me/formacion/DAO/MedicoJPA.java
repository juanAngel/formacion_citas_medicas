package me.formacion.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import me.formacion.Config;
import me.formacion.model.Medico;
import me.formacion.model.Usuario;

@Repository
public class MedicoJPA implements IMedicoDAO {
	@PersistenceContext(unitName = Config.PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	public MedicoJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Medico getById(Long id) {
		Medico result = null;
		
		return result;
	}
	

	@Override
	public Medico[] findByNumColegiado(String numColegiado) {
		Medico[] result = null;
		
		return result;
	}
	
	@Override
	public Medico[] getAll() {
		Medico[] result = null;
		
		return result;
	}

	@Override
	public void store(Usuario m) {
		//em.persist(m);
	}

	@Override
	public Usuario[] findByNombre(String name) {
		Medico[] result = null;
		
		return result;
	}

	@Override
	public Usuario[] findByApellidos(String apellidos) {
		Medico[] result = null;
		
		return result;
	}

	@Override
	public Usuario[] findByUsuario(String usuario) {
		Medico[] result = null;
		
		return result;
	}

	@Override
	public void delete(Usuario p) {
		// TODO Auto-generated method stub
		
	}

}
