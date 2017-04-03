/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class ProfesseurTest {
    private Professeur p;
    private Classe c;
    private Classe c1;
    
    public ProfesseurTest() {
    }
    
    @Before
    public void setUp() {
        p = new Professeur("logProf","12345","LeGrand","Jean");
        
        
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of setLogin method, of class Professeur.
     */
    @Test
    public void testSetLogin() {
        System.out.println("setLogin");
        p.setLogin("poupoupou");
        assertEquals("poupoupou", p.getLogin());
    }

    /**
     * Test of setMotDePasse method, of class Professeur.
     */
    @Test
    public void testSetMotDePasse() {
        System.out.println("setMotDePasse");
        p.setMotDePasse("dude");
        assertEquals("dude", p.getMotdePasse());
    }


    /**
     * Test of addClasse method, of class Professeur.
     */
    @Test
    public void testAddClasse() {
        System.out.println("addClasse");
        c = new Classe("CM1",p);
        assertEquals(1,p.getLesClasses().size());
        p.addClasse(c);
        assertEquals(1,p.getLesClasses().size());
        c1 = new Classe("CM2",p);
        assertEquals(2,p.getLesClasses().size());
    }

    /**
     * Test of delClasse method, of class Professeur.
     */
    @Test
    public void testDelClasse() {
        System.out.println("delClasse");
        c = new Classe("CM1",p);
        c1 = new Classe("CM2",p);
        p.delClasse(c1);
    }
    
}
