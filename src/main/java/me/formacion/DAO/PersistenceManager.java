package me.formacion.DAO;


public class PersistenceManager {
	static private PersistenceManager instance = null;
	private PersistenceFactory factory;
	
	private PersistenceManager() {
		factory = new PersistenceFactoryEclipseLink();
	}
	public static PersistenceManager getInstance() {
		if(instance == null) {
			instance = new PersistenceManager();
		}
		return instance;
	}
	public PersistenceFactory getFactory() {
		return factory;
	}
}
