package me.formacion.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import me.formacion.model.Medico;
import me.formacion.model.Usuario;

@Repository
public class MedicoJPA implements IMedicoDAO {
	
	@PersistenceContext
	private EntityManager em;

	public MedicoJPA() {
		// TODO Auto-generated constructor stub
	}
	public MedicoJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Medico getById(Long id) {
		Medico result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Medico> query = cb.createQuery(Medico.class);
		Root<Medico> tables = query.from(Medico.class);
		
		query.select(tables).where(cb.equal(tables.get("id"), id));
		
		Query criteriaQuery = em.createQuery(query);
		List<Medico> resultList = criteriaQuery.getResultList();
		
		System.out.println("resultList sql="+criteriaQuery.toString());
		
		if(resultList != null && !resultList.isEmpty()) {
			result = resultList.get(0);
		}
		
		return result;
	}
	
	@Override
	public Medico[] findByNumColegiado(String numColegiado) {
		List<Medico> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Medico> query = cb.createQuery(Medico.class);
		Root<Medico> tables = query.from(Medico.class);
		
		query.select(tables).where(cb.like(tables.get("numColegiado"), numColegiado));
		result = em.createQuery(query).getResultList();
		
		return (Medico[]) result.toArray();
	}
	
	@Override
	public Medico[] getAll() {
		List<Medico> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Medico> query = cb.createQuery(Medico.class);
		
		query.select(query.from(Medico.class));
		result = em.createQuery(query).getResultList();
		Medico[] m = new Medico[result.size()];
		
		for (int i = 0;i<result.size();i++) {
			m[i] = result.get(i);
		}
		
		return m;
	}

	@Override
	public void store(Usuario m) {
		em.persist(m);
	}
	
	public Medico merge(Usuario m) {
		return (Medico) em.merge(m);
	}

	@Override
	public Medico[] findByNombre(String name) {
		List<Medico> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Medico> query = cb.createQuery(Medico.class);
		Root<Medico> tables = query.from(Medico.class);
		
		query.select(tables).where(cb.like(tables.get("nombre"), name));
		result = em.createQuery(query).getResultList();
		Medico[] m = new Medico[result.size()];
		
		for (int i = 0;i<result.size();i++) {
			m[i] = result.get(i);
		}
		
		return m;
	}

	@Override
	public Medico[] findByApellidos(String apellidos) {
		List<Medico> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Medico> query = cb.createQuery(Medico.class);
		Root<Medico> tables = query.from(Medico.class);
		
		query.select(tables).where(cb.like(tables.get("apellidos"), apellidos));
		result = em.createQuery(query).getResultList();
		Medico[] m = new Medico[result.size()];
		
		for (int i = 0;i<result.size();i++) {
			m[i] = result.get(i);
		}
		
		return m;
	}

	@Override
	public Medico[] findByUsuario(String usuario) {
		List<Medico> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Medico> query = cb.createQuery(Medico.class);
		Root<Medico> tables = query.from(Medico.class);
		
		query.select(tables).where(cb.like(tables.get("usuario"), usuario));
		result = em.createQuery(query).getResultList();
		Medico[] m = new Medico[result.size()];
		
		for (int i = 0;i<result.size();i++) {
			m[i] = result.get(i);
		}
		
		return m;
	}

	@Override
	public void remove(Usuario p) {
		em.remove(em.merge(p));
	}

}
