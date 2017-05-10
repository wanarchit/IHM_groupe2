package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.MenuProf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlMenuProf
 * Permet de gérer les choix du professeur dans le menuProf
 * Il affichera les panels en fonction des choix que l'utilisateur fait
 * 
 * @author Groupe 2
 */
public class CtrlMenuProf implements ActionListener{
    
    private ApplicationProf appli;
    private MenuProf menuProfesseur;
    
    /**
     * Constructeur de la classe CtrlMenuProf
     * @param lAppli : application utilisée
     * @param leMenu : menu du professeur
     */
    public CtrlMenuProf(ApplicationProf lAppli, MenuProf leMenu){
        appli = lAppli;
        menuProfesseur = leMenu;
    }
    
    @Override
    /**
     * Méthode actionPerformed
     * Permet l'appel de la fonction souhaitée selon le bouton choisi
     * Les actions possibles sont ici : créér un exercie -
     * afficher les exercices - afficher les élèves ou afficher les classes 
     * ou se déconnecter
     * @param e : action event
     */
    public void actionPerformed(ActionEvent e) {
        //menuProfesseur.getPanelDroite(); (maj du panel de droite)
        if (e.getSource() == menuProfesseur.getButtonCreerExo()){ //CREER EXERCICE
            appli.creerExercice();
        }else if (e.getSource() == menuProfesseur.getButtonExo()){ //AFFICHER EXERCICES
            appli.afficheExercices();
        }else if (e.getSource() == menuProfesseur.getButtonEleve()){ //AFFICHER LES ELEVES
            appli.afficheEleves();
        }else if (e.getSource() == menuProfesseur.getButtonClasse()){ //AFFICHER LES CLASSES
            appli.afficheClasses();
        }else if (e.getSource() == menuProfesseur.getButtonDeco()){ // SE DECONNECTER
            appli.seDeconnecter();
        }     
    }
}