package me.formacion.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.formacion.Config;
import me.formacion.model.Diagnostico;
import me.formacion.model.Medico;
import me.formacion.model.Paciente;

@Repository
@Transactional
public class DiagnosticoJPA implements IDiagnosticoDAO{

	@PersistenceContext
	private EntityManager em;

	public DiagnosticoJPA() {
	}
	public DiagnosticoJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Diagnostico getById(Long id) {
		Diagnostico result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Diagnostico> query = cb.createQuery(Diagnostico.class);
		Root<Diagnostico> tables = query.from(Diagnostico.class);
		
		query.select(tables).where(cb.equal(tables.get("id"), id));
		
		List<Diagnostico> resultList = em.createQuery(query).getResultList();
		if(resultList != null && !resultList.isEmpty()) {
			result = resultList.get(0);
		}
		
		return result;
	}

	@Override
	public Diagnostico[] getAll() {
		List<Diagnostico> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Diagnostico> query = cb.createQuery(Diagnostico.class);
		
		query.select(query.from(Diagnostico.class));
		result = em.createQuery(query).getResultList();
		
		return (Diagnostico[]) result.toArray();
	}

	@Override
	public void store(Diagnostico d) {
		em.persist(d);
	}

	@Override
	public void remove(Diagnostico d) {
		em.remove(em.merge(d));
	}

}
