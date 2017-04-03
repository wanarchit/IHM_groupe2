/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Applications;

import ihm_groupe2.Inferface.Menu.ListeExercices;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author Delphine
 */
public class FrameTest extends JFrame{

    // Création de la fenêtre principale
    private ListeExercices listeExo;
    
    public FrameTest(){
        
        listeExo = new ListeExercices();
        
        this.add(listeExo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Application gestion exercices");  
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
       
        this.setVisible(true);
    }
    
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrameTest();
            }
        });
    }
    
}