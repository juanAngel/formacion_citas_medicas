package me.formacion.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import me.formacion.Config;
import me.formacion.model.Diagnostico;

@Repository
public class DiagnosticoJPA implements IDiagnosticoDAO {

	@PersistenceContext(unitName = Config.PERSISTENCE_UNIT_NAME)
	private EntityManager em;

	public DiagnosticoJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Diagnostico getById(Long id) {
		Diagnostico result = null;
				
		return result;
	}

	@Override
	public Diagnostico[] getAll() {
		Diagnostico[] result = null;
				
		return result;
	}

	@Override
	public void store(Diagnostico d) {
		//em.persist(d);
	}

	@Override
	public void delete(Diagnostico d) {
		// TODO Auto-generated method stub
		
	}

}
