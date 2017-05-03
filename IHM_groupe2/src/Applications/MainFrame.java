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
    private ApplicationEleve appliEleve;
    private ApplicationProf appliProf;
    
    public MainFrame(){
        
        menuPrincipal = new MenuPrincipal(this);
        appliEleve = null;
        appliProf = null;
        System.out.println("main");
        System.out.println(appliEleve);
        System.out.println(appliProf);
        CtrlWindows controleur = new CtrlWindows(this);
        this.addWindowListener(controleur);
        
        this.add(menuPrincipal);
        
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Application gestion exercices");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        SqliteJDBC db = new SqliteJDBC();
        db.dbConnection();
        Peuplement remplissage= new Peuplement();
        remplissage.Peuplement();
        
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
    
    public ApplicationEleve getAppEleve(){
        return appliEleve;
    }
    
    public ApplicationProf getAppProf(){
        return appliProf;
    }
    
    public void setAppEleve(ApplicationEleve lAppEl){
        System.out.println("setAppEleve");
        System.out.println(appliEleve);
        System.out.println(appliProf);
        this.appliEleve = lAppEl;
    }
    
    public void setAppProf(ApplicationProf lAppPr){
        System.out.println("setAppProf");
        System.out.println(appliEleve);
        System.out.println(appliProf);
        this.appliProf = lAppPr;
    }
}
