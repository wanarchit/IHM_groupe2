package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Menu.MenuConnexionEleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlConnEleve
 * Permet de controler la connexion d'un élève
 * et en récupérant les données dans la base de données
 * Permet de rediriger vers la page des exercices de l'élève pour un élève
 * 
 * @author Groupe 2
 */
public class CtrlConnEleve implements ActionListener {
    
    private MenuConnexionEleve leMenu;
    private ApplicationEleve appli;
    
    /**
     * Constructeur du controleur CtrlConnEleve
     * @param menuCo : menu de connexion de l'élève
     * @param lAppli : application utilisée
     */
    public CtrlConnEleve(MenuConnexionEleve menuCo, ApplicationEleve lAppli){
        leMenu = menuCo;
        appli = lAppli;
    }
    
    @Override
    /**
     * Méthode actionPerformed
     * Permet d'effectuer une action en fonction du bouton choisi
     * @param e : action event
     */
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leMenu.getButAnnuler()){
            appli.annulerConnexion();
        }
    }
}
