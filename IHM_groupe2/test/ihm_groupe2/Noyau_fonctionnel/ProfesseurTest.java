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
        String newLogin = "";
        Professeur instance = null;
        instance.setLogin(newLogin);
    }

    /**
     * Test of setMotDePasse method, of class Professeur.
     */
    @Test
    public void testSetMotDePasse() {
        System.out.println("setMotDePasse");
        String newMotDePasse = "";
        Professeur instance = null;
        instance.setMotDePasse(newMotDePasse);
    }


    /**
     * Test of addClasse method, of class Professeur.
     */
    @Test
    public void testAddClasse() {
        System.out.println("addClasse");
        c = new Classe("CM1",p);
        assertEquals(1,p.getLesClasses().size());
    }

    /**
     * Test of delClasse method, of class Professeur.
     */
    @Test
    public void testDelClasse() {
        System.out.println("delClasse");
        Classe laClasse = null;
        Professeur instance = null;
        instance.delClasse(laClasse);
    }
    
}
