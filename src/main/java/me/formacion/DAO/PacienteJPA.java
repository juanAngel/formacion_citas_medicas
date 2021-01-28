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
import me.formacion.model.Medico;
import me.formacion.model.Paciente;
import me.formacion.model.Usuario;

@Repository
@Transactional
public class PacienteJPA implements IPacienteDAO {

	@PersistenceContext()
	private EntityManager em;

	public PacienteJPA() {
	}
	public PacienteJPA(EntityManager em) {
		super();
		this.em = em;
	}

	@Override
	public Paciente getById(Long id) {
		Paciente result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = cb.createQuery(Paciente.class);
		Root<Paciente> tables = query.from(Paciente.class);
		
		query.select(tables).where(cb.equal(tables.get("id"), id));
		
		List<Paciente> resultList = em.createQuery(query).getResultList();
		if(resultList != null && !resultList.isEmpty()) {
			result = resultList.get(0);
		}
		
		return result;
	}

	@Override
	public Paciente[] getAll() {
		List<Paciente> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = cb.createQuery(Paciente.class);
		
		query.select(query.from(Paciente.class));
		result = em.createQuery(query).getResultList();
		Paciente[] array = new Paciente[result.size()];
		
		return result.toArray(array);
	}

	@Override
	public void store(Usuario p) {
		em.persist(p);
	}
	@Override
	public Paciente merge(Usuario p) {
		return (Paciente) em.merge(p);
	}

	@Override
	public Paciente[] findByNombre(String name) {
		List<Paciente> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = cb.createQuery(Paciente.class);
		Root<Paciente> tables = query.from(Paciente.class);
		
		query.select(tables).where(cb.like(tables.get("nombre"), "%"+name+"%"));
		result = em.createQuery(query).getResultList();
		Paciente[] array = new Paciente[result.size()];
		
		return result.toArray(array);
	}

	@Override
	public Paciente[] findByApellidos(String apellidos) {
		List<Paciente> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = cb.createQuery(Paciente.class);
		Root<Paciente> tables = query.from(Paciente.class);
		
		query.select(tables).where(cb.like(tables.get("apellidos"), "%"+apellidos+"%"));
		result = em.createQuery(query).getResultList();
		Paciente[] array = new Paciente[result.size()];
		
		return result.toArray(array);
	}

	@Override
	public Paciente[] findByUsuario(String usuario) {
		List<Paciente> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = cb.createQuery(Paciente.class);
		Root<Paciente> tables = query.from(Paciente.class);
		
		query.select(tables).where(cb.like(tables.get("usuario"), "%"+usuario+"%"));
		result = em.createQuery(query).getResultList();
		Paciente[] array = new Paciente[result.size()];
		
		return result.toArray(array);
	}

	@Override
	public Paciente[] findByTelefono(String telefono) {
		List<Paciente> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = cb.createQuery(Paciente.class);
		Root<Paciente> tables = query.from(Paciente.class);
		
		query.select(tables).where(cb.like(tables.get("telefono"), "%"+telefono+"%"));
		result = em.createQuery(query).getResultList();
		Paciente[] array = new Paciente[result.size()];
		
		return result.toArray(array);
	}

	@Override
	public Paciente[] findByNumTarjeta(String numTarjeta) {
		List<Paciente> result = null;
		
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Paciente> query = cb.createQuery(Paciente.class);
		Root<Paciente> tables = query.from(Paciente.class);
		
		query.select(tables).where(cb.like(tables.get("numTarjeta"), "%"+numTarjeta+"%"));
		result = em.createQuery(query).getResultList();
		Paciente[] array = new Paciente[result.size()];
		
		return result.toArray(array);
	}

	@Override
	public void remove(Usuario p) {
		em.remove(em.merge(p));
	}

}
