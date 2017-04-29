/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Noyau_fonctionnel;

import javax.swing.ImageIcon;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class EvaluationTest {
    private Evaluation e;
    private Eleve el;
    private Exercice exo;
    private Classe c;
    private Professeur p;
    public EvaluationTest() {
    }
    
    @Before
    public void setUp() {
        p = new Professeur("logProf","12345","LeGrand","Jean");
        c = new Classe("CM1",p);
        el = new Eleve(c,"Jean","Bon",null);
        exo = new Exercice("Ex1","",1,new ImageIcon());
        e = new Evaluation(el,exo,false);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setValidation method, of class Evaluation.
     */
    @Test
    public void testSetValidation() {
        System.out.println("setValidation");
        e.setValidation(true);
        assertEquals(true, e.getValidation());
        e.setValidation(false);
        assertEquals(true, e.getValidation());
    }
}
