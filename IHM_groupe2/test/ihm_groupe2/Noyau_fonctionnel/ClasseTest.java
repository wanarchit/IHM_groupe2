/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jonathan
 */
public class ClasseTest {
    
    public ClasseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getNomClasse method, of class Classe.
     */
    @Test
    public void testGetNomClasse() {
        System.out.println("getNomClasse");
        Classe instance = null;
        String expResult = "";
        String result = instance.getNomClasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNomClasse method, of class Classe.
     */
    @Test
    public void testSetNomClasse() {
        System.out.println("setNomClasse");
        String nomClasse = "";
        Classe instance = null;
        instance.setNomClasse(nomClasse);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getProfesseur method, of class Classe.
     */
    @Test
    public void testGetProfesseur() {
        System.out.println("getProfesseur");
        Classe instance = null;
        Professeur expResult = null;
        Professeur result = instance.getProfesseur();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setProfesseur method, of class Classe.
     */
    @Test
    public void testSetProfesseur() {
        System.out.println("setProfesseur");
        Professeur professeur = null;
        Classe instance = null;
        instance.setProfesseur(professeur);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ajoutEleve method, of class Classe.
     */
    @Test
    public void testAjoutEleve() {
        System.out.println("ajoutEleve");
        Eleve monEleve = null;
        Classe instance = null;
        instance.ajoutEleve(monEleve);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of suppEleve method, of class Classe.
     */
    @Test
    public void testSuppEleve() {
        System.out.println("suppEleve");
        Eleve monEleve = null;
        Classe instance = null;
        instance.suppEleve(monEleve);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListEleveClasse method, of class Classe.
     */
    @Test
    public void testGetListEleveClasse() {
        System.out.println("getListEleveClasse");
        Classe instance = null;
        ArrayList<Eleve> expResult = null;
        ArrayList<Eleve> result = instance.getListEleveClasse();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
