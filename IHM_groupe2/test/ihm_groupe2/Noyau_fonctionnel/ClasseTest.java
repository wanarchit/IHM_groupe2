/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Noyau_fonctionnel;
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
    private Eleve e;
    private Eleve e1;
    private Professeur p;
    private Professeur p1;
    private Classe cl;
    
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
        p = new Professeur("logProf","12345","LeGrand","Jean");
        p1 = new Professeur("logProf","12345","Bon","Jean");
        cl = new Classe("CM1",p);
        e = new Eleve("Rousse","Delphine");
        e1 = new Eleve("ihb","iyg");
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
        String expResult = "CM1";
        String result = cl.getNomClasse();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNomClasse method, of class Classe.
     */
    @Test
    public void testSetNomClasse() {
        System.out.println("setNomClasse");
        String nomClasse = "CM2";
        cl.setNomClasse(nomClasse);
        assertEquals(nomClasse,"CM2");
    }

    /**
     * Test of getProfesseur method, of class Classe.
     */
    @Test
    public void testGetProfesseur() {
        System.out.println("getProfesseur");
        Professeur expResult = p;
        Professeur result = cl.getProfesseur();
        assertEquals(expResult, result);
    }

    /**
     * Test of setProfesseur method, of class Classe.
     */
    @Test
    public void testSetProfesseur() {
        System.out.println("setProfesseur");
        cl.setProfesseur(p1);
        assertEquals(cl.getProfesseur().getPrenomPersonne(),"Jean");
    }

    /**
     * Test of ajoutEleve method, of class Classe.
     */
    @Test
    public void testAjoutEleve() {
        System.out.println("ajoutEleve");
        cl.ajoutEleve(e);
        assertEquals(cl.getSizeClasse(),1);
    }
    
    @Test
    public void testAjoutEleveIdentique() {
        System.out.println("Eleve identique");
        cl.ajoutEleve(e);
        cl.ajoutEleve(e);
        assertEquals(cl.getSizeClasse(),1);
    }

    /**
     * Test of suppEleve method, of class Classe.
     */
    @Test
    public void testSuppEleve() {
        System.out.println("suppEleve");
        cl.ajoutEleve(e);
        cl.ajoutEleve(e1);
        cl.suppEleve(e);
        assertEquals(cl.getSizeClasse(),1);
    } 
}
