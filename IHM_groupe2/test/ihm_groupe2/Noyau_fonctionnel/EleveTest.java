/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;
import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class EleveTest {
    private Eleve e;
    private Realisation r1;
    private Realisation r2;
    private Professeur p;
    private Classe c;
    private Exercice exo;
    
    public EleveTest() {
        exo = new Exercice("Ex1","",1,"");
        p = new Professeur("logProf","12345","LeGrand","Jean");
        c = new Classe("CM1",p);
        e = new Eleve(c,"Jean","Bon",null);
        r1 = new Realisation(1,"Joli","Bien",exo);
        r2 = new Realisation(2,"Moins joli","Moins bien",exo);
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addRealisation method, of class Eleve.
     */
    @Test
    public void testAddRealisation() {
        System.out.println("addRealisation");
        e.addRealisation(r1);
        assertEquals(1,e.getLesRealisations().size());
        e.addRealisation(r1);
        assertEquals(1,e.getLesRealisations().size());
        e.addRealisation(r2);
        assertEquals(2,e.getLesRealisations().size());
    }

    
}
