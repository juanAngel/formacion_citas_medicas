package me.formacion.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import me.formacion.Config;
import me.formacion.model.Cita;

@Repository
public class CitaJPA implements ICitaDAO {
	@PersistenceContext(unitName = Config.PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	public CitaJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Cita getById(Long id) {
		Cita result = null;
		
		return result;
	}

	@Override
	public Cita[] getAll() {
		Cita[] result = null;
		
		return result;
	}

	@Override
	public void store(Cita c) {
		em.persist(c);
	}

	@Override
	public void delete(Cita d) {
		// TODO Auto-generated method stub
		
	}

}
