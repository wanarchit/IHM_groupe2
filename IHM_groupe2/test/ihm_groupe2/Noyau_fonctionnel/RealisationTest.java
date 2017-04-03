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
public class RealisationTest {
    private Realisation r1;
    private Realisation r2;
    private Exercice exo1;
    private Exercice exo2;
    private TortueG t;
    private Commande c;
    
    public RealisationTest() {
    }
    
    @Before
    public void setUp() {
        exo1 = new Exercice("Ex1","",1,new ImageIcon());
        exo2 = new Exercice("Ex2","",2,new ImageIcon());
        r1 = new Realisation(1,"","",exo1);
        r2 = new Realisation(1,"","",exo2);
        t = new TortueG();
        c = new Commande("avancer",t);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ajouterCommande method, of class Realisation.
     */
    @Test
    public void testAjouterCommande() {
        System.out.println("ajouterCommande");
        r1.ajouterCommande(c);
        assertEquals(1,r1.getListeCommande().size());
    }

    /**
     * Test of supprimeDerniereCommande method, of class Realisation.
     */
    @Test
    public void testSupprimeDerniereCommande() {
        System.out.println("supprimeDerniereCommande");
        r1.ajouterCommande(c);
        r1.ajouterCommande(c);
        assertEquals(2,r1.getListeCommande().size());
        r1.supprimeDerniereCommande();
        assertEquals(1,r1.getListeCommande().size());
    }

    /**
     * Test of getCommandeInListe method, of class Realisation.
     */
    @Test
    public void testGetCommandeInListe() {
        System.out.println("getCommandeInListe");
        int i = 0;
        r1.ajouterCommande(c);
        Commande result = r1.getCommandeInListe(i);
        assertEquals(c, result);
    }
    
}
