package me.formacion;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import me.formacion.DAO.PersistenceFactory;
import me.formacion.DAO.PersistenceManager;
import me.formacion.model.Medico;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite( AppTest.class );
    }
    /**
     * Rigourous Test :-)
     */
    public void testApp(){
        assertTrue( true );
    }
    public void testPersistence() {
/*
        PersistenceFactory factory = PersistenceManager.getInstance().getFactory();
        Medico medico = new Medico("pepe","sanchez","pepe96","1234","00000");
        
        factory.getMedico().store(medico);*/
    }
}
