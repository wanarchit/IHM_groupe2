package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Menu.MenuConnexionEleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlConnEleve
 Permet de controler la connexion d'un élève ou d'un professeur en validant le formulaire
 et en récupérant les données dans la base de données
 Permet de rediriger vers la page des exercices de l'élève pour un élève ou du menu d'un professeur
 * @author Groupe 2
 */
public class CtrlConnEleve implements ActionListener {
    
    private MenuConnexionEleve leMenu;
    private ApplicationEleve appli;
    
    public CtrlConnEleve(MenuConnexionEleve menuCo, ApplicationEleve lAppli){
        leMenu = menuCo;
        appli = lAppli;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == leMenu.getButAnnuler()){
            appli.annulerConnexion();
        }
    }
}
