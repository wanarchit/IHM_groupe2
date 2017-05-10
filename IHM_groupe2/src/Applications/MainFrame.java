package Applications;

import ihm_groupe2.Controleur.CtrlWindows;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import ihm_groupe2.Modele.Peuplement;
import ihm_groupe2.Modele.SqliteJDBC;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Classe MainFrame
 * Créer la fenêtre principale
 * Permet de lancer le programme en chargeant le menu principal
 * @author Groupe 2
 */
public class MainFrame extends JFrame{

    // Création de la fenêtre principale
    private MenuPrincipal menuPrincipal;
    private ApplicationEleve appliEleve;
    private ApplicationProf appliProf;
    
    /**
     *  Constructeur de la fenêtre principale
     *  Ne prend aucun paramètre
     */
    public MainFrame(){
        menuPrincipal = new MenuPrincipal(this);
        appliEleve = null;
        appliProf = null;
        CtrlWindows controleur = new CtrlWindows(this);
        this.addWindowListener(controleur);
        this.add(menuPrincipal);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Application gestion exercices");
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
   
        ///**** PARTIE A COMMENTER / DECOMMENTER POUR LE PEUPLEMENT DE BASE DE LA BDD ****\\\
        ///                 DEBUT               ///
//        FenetreLoad progress = new FenetreLoad("Chargement de la base de données ...");
//        try {
//            SwingUtilities.invokeLater(new Runnable() {
//                public void run() {
//                    SqliteJDBC db = new SqliteJDBC();
//                    db.dbConnection();
//                    Peuplement remplissage= new Peuplement();
//                    remplissage.Peuplement();
//                    progress.closeFrameLoad();
//                }
//            });
//            java.lang.Thread.sleep(100);
//        }catch (InterruptedException exp) {
//            System.err.println( exp.getClass().getName() + ": " + exp.getMessage() );
//            System.exit(0);
//      } 
        ///                 FIN                 ///
        ///**** FIN PARTIE A COMMENTER / DECOMMENTER POUR LE PEUPLEMENT DE BASE DE LA BDD ****///
    }
    
    /**
     * Permet d'excécuter l'application "main"
     * @param args 
     */
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });
    }
    
    /**
     * getAppEleve : fonction qui permet de récupérer l'application élève en cours d'éxécution
     * @return appliEleve : application élève qui est en cours d'exécution
     */
    public ApplicationEleve getAppEleve(){
        return appliEleve;
    }
    
    /**
     * getAppProf :  fonction qui permet de récupérer l'application prof en cours d'éxécution
     * @return appliProf : application prof qui est en cours d'exécution
     */
    public ApplicationProf getAppProf(){
        return appliProf;
    }
    
    /**
     * setAppEleve : permet de modifier l'application élève en cours d'éxécution (déconnexion)
     * @param lAppEl : application élève
     */
    public void setAppEleve(ApplicationEleve lAppEl){
        this.appliEleve = lAppEl;
    }
    
    /**
     * setAppProf : permet de modifier l'application prof en cours d'éxécution (déconnexion)
     * @param lAppPr : application prof
     */
    public void setAppProf(ApplicationProf lAppPr){
        this.appliProf = lAppPr;
    }
}
