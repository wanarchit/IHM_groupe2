package ihm_groupe2.Inferface;

import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import javax.swing.JFrame;

/**
 * Classe MainFrame
 * Créer la fenêtre principale
 * Permet de lancer le programme en chargeant le menu principal
 * @author Paul
 */
public class MainFrame extends JFrame{

    // Création de la fenêtre principale
    private JFrame maFrame;
    private MenuPrincipal menuPrincipal;
    
    public MainFrame(){
        maFrame = new JFrame();
        menuPrincipal = new MenuPrincipal();
        
        maFrame.add(menuPrincipal);
    }
    
}
