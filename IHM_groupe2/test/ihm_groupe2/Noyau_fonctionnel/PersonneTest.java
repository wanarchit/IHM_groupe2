/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Noyau_fonctionnel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class PersonneTest {
    private Personne p;
    
    public PersonneTest() {
    }
    
    @Before
    public void setUp() {
        p = new Personne("Jean","Bon");
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of setNomPersonne method, of class Personne.
     */
    @Test
    public void testSetNomPersonne() {
        System.out.println("setNomPersonne");
        p.setNomPersonne("Bien");
        assertEquals("Bien",p.getNomPersonne());
    }


    /**
     * Test of setPrenomPersonne method, of class Personne.
     */
    @Test
    public void testSetPrenomPersonne() {
        System.out.println("setPrenomPersonne");
        p.setPrenomPersonne("John");
        assertEquals("John",p.getPrenomPersonne());
    }
    
}
