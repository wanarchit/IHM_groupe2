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
public class RealisationTest {
    
    public RealisationTest() {
    }
    
    @Before
    public void setUp() {
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
        Commande cmd = null;
        Realisation instance = null;
        instance.ajouterCommande(cmd);
    }

    /**
     * Test of supprimeDerniereCommande method, of class Realisation.
     */
    @Test
    public void testSupprimeDerniereCommande() {
        System.out.println("supprimeDerniereCommande");
        Realisation instance = null;
        instance.supprimeDerniereCommande();
    }

    /**
     * Test of getCommandeInListe method, of class Realisation.
     */
    @Test
    public void testGetCommandeInListe() {
        System.out.println("getCommandeInListe");
        int i = 0;
        Realisation instance = null;
        Commande expResult = null;
        Commande result = instance.getCommandeInListe(i);
        assertEquals(expResult, result);
    }

    /**
     * Test of setACorriger method, of class Realisation.
     */
    @Test
    public void testSetACorriger() {
        System.out.println("setACorriger");
        boolean bool = false;
        Realisation instance = null;
        instance.setACorriger(bool);
    }
    
}
