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
public class CommandeTest {
    private Commande c;
    private TortueG t;
    
    public CommandeTest() {
    }
    
    @Before
    public void setUp() {
        t = new TortueG();
        c = new Commande("Avancer",t);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of doAction method, of class Commande.
     */
    @Test
    public void testDoAction() {
        c.doAction(c);
        assertEquals(t.getY(),-1);
    }
    
}
