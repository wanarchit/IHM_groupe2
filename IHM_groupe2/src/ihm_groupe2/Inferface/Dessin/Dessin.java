/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Inferface.Dessin;

import Applications.ApplicationEleve;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Paul
 */
public class Dessin extends JPanel{
    
    private ApplicationEleve appli;
    
    public Dessin(ApplicationEleve lAppli){
        appli=lAppli;
        
        
        
        
        
        
        JLabel monLabel = new JLabel("toto");
        this.add(monLabel);
        
        
    }
}
