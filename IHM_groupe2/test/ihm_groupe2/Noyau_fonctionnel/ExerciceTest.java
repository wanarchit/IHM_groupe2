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
public class ExerciceTest {
    private Exercice e;
    public ExerciceTest() {
    }
    
    @Before
    public void setUp() {
        e = new Exercice("Ex1","",1,new ImageIcon());
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setCommentaire method, of class Exercice. Check si le commentaire est inférieur à 300 de longueur.
     */
    @Test
    public void testSetCommentaire() {
        System.out.println("setCommentaire");
        e.setCommentaire("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaadddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd");
        assertEquals("",e.getCommentaire());
        e.setCommentaire("Ouais");
        assertEquals("Ouais",e.getCommentaire());
    }
    
}
