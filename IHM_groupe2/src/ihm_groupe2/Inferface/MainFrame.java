package ihm_groupe2.Inferface;

import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Classe MainFrame
 * Créer la fenêtre principale
 * Permet de lancer le programme en chargeant le menu principal
 * @author Paul
 */
public class MainFrame extends JFrame{

    // Création de la fenêtre principale
    private MenuPrincipal menuPrincipal;
    
    public MainFrame(){
        
        menuPrincipal = new MenuPrincipal(this);
        
        this.add(menuPrincipal);
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
                new MainFrame();
            }
        });
    }
    
}
