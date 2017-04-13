package Applications;

import ihm_groupe2.Controleur.CtrlWindows;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import ihm_groupe2.Modele.Peuplement;
import ihm_groupe2.Modele.SqliteJDBC;
import java.awt.event.WindowListener;
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
        CtrlWindows controleur = new CtrlWindows(this);
        this.addWindowListener(controleur);
        
        this.add(menuPrincipal);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Application gestion exercices");
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //SqliteJDBC db = new SqliteJDBC();
       // db.dbConnection();
       // Peuplement remplissage= new Peuplement();
      //  remplissage.Peuplement();
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
