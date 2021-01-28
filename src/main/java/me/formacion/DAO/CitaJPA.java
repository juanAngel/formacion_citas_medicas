package me.formacion.DAO;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import me.formacion.Config;
import me.formacion.model.Cita;
import me.formacion.model.Paciente;

@Repository
@Transactional
public class CitaJPA implements ICitaDAO {
	@PersistenceContext
	private EntityManager em;

	public CitaJPA() {
		// TODO Auto-generated constructor stub
	}
	public CitaJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Cita getById(Long id) {
		Cita result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cita> query = cb.createQuery(Cita.class);
		Root<Cita> tables = query.from(Cita.class);
		
		query.select(tables).where(cb.equal(tables.get("id"), id));
		
		List<Cita> resultList = em.createQuery(query).getResultList();
		if(resultList != null && !resultList.isEmpty()) {
			result = resultList.get(0);
		}
		
		return result;
	}

	@Override
	public Cita[] getAll() {
		List<Cita> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cita> query = cb.createQuery(Cita.class);
		
		query.select(query.from(Cita.class));
		result = em.createQuery(query).getResultList();
		Cita[] array = new Cita[result.size()];
		
		return result.toArray(array);
	}

	@Override
	public void store(Cita c) {
		em.persist(c);
	}

	@Override
	public void remove(Cita c) {
		em.remove(em.merge(c));
	}

	@Override
	public Cita[] getAtDate(Date start, Date end) {
		List<Cita> result;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Cita> query = cb.createQuery(Cita.class);
		Root<Cita> tables = query.from(Cita.class);
		
		Expression<Boolean> exp1 = null, exp2 = null;
		Predicate predicate = null;
		if(start != null) {
			exp1 = cb.greaterThanOrEqualTo(tables.get("fechaHora"), start);
		}
		if(end != null) {
			exp2 = cb.lessThanOrEqualTo(tables.get("fechaHora"), end);
		}
		predicate = cb.and(exp1, exp2);
		query.select(tables).where(predicate);
		
		result = em.createQuery(query).getResultList();
		Cita[] array = new Cita[result.size()];
		
		return result.toArray(array);
	}

}
