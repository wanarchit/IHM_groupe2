package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlMenuPrincipal
 * Permet de choisir le type d'utilisateur : élève ou professeur
 * Selon le choix, l'utilisateur sera renvoyé vers la page de connexion appropriée
 * 
 * @author Groupe 2
 */
public class CtrlMenuPrincipal implements ActionListener{
    
    private MenuPrincipal leMenu;
    
    /**
     * Constructeur du controleur CtrlMenuPrincipal
     * 
     * @param MenuPrincip : menu principal
     */
    public CtrlMenuPrincipal(MenuPrincipal MenuPrincip){
        leMenu = MenuPrincip;
    }
    
    @Override
    /**
     * Méthode actionPerformed
     * Permet d'appeler la fonction correspondante en fonction du bouton choisi
     * Soit professeur soit élève
     * @param e : action event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leMenu.getButtonEleve()){
            // On affiche le menu de connexion d'un élève
            //new MenuConnexionEleve(leMenu.getMainFrame());
            ApplicationEleve appliEleve = new ApplicationEleve(leMenu.getMainFrame());
            leMenu.getMainFrame().setAppEleve(appliEleve);
            
        }else{      // bouton Professeur
            // On affiche le menu de connexion d'un professeur
            //new MenuConnexionProf(leMenu.getMainFrame());
            ApplicationProf appliProf = new ApplicationProf(leMenu.getMainFrame());
            leMenu.getMainFrame().setAppProf(appliProf);
        }
    } 
}