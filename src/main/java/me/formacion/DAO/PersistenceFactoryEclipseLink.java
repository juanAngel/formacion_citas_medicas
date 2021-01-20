package me.formacion.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

//@Repository
public class PersistenceFactoryEclipseLink extends PersistenceFactory {
    private static final String PERSISTENCE_UNIT_NAME = "FORACION";
	private EntityManagerFactory factory;
	
	public PersistenceFactoryEclipseLink() {
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
		EntityManager em = factory.createEntityManager();
		
        
        setCita(new CitaJPA(em));
        setDiagnostico(new DiagnosticoJPA(em));
        setMedico(new MedicoJPA(em));
        setPaciente(new PacienteJPA(em));
	}

}
