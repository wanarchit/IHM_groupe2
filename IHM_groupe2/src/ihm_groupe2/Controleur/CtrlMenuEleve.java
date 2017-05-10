package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Menu.MenuEleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlMenuEleve
 * Permet de gérer les actions effectuées grâces aux 4 boutons dans le menu de l'élève
 * Les 4 bontons permettent de changer les exercices ou les tentatives de l'élève
 * Une action sur l'un des boutons va permettre de modifier les labels et les images des exercices/tentatives
 * 
 * @author Groupe 2
 */
public class CtrlMenuEleve implements ActionListener{
    
    private MenuEleve leMenu;
    private ApplicationEleve appli;
    
    /**
     * Constructeur du controleur du MenuEleve
     * @param menuEleve : menu de l'élève 
     * @param lAppli : application utilisée
     */
    public CtrlMenuEleve(MenuEleve menuEleve,ApplicationEleve lAppli){
        //eleve = lEleve;
        leMenu = menuEleve;
        appli=lAppli;
    }
    

    @Override
    /**
     * Méthode actionPerformed
     * Permet d'effectuer les actions en fonction de l'événement produit
     * Les actions possibles sont : faire l'exercice -
     * montrer l'exercice suivant - montrer l'exercice précédent
     * montrer la tentative suivante - montrer la tentative précédente
     * rejouer la tentative
     * @param e : action event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leMenu.getButFaireExo() ){ //FAIRE EXERCICE
            appli.faireExercice(leMenu.getExoEnCours());
        }else if(e.getSource() == leMenu.getButExoSuiv()){ //EXERCICE SUIVANT
            appli.afficheExerciceSuivant(leMenu.getExoEnCours());
        }else if(e.getSource() == leMenu.getButExoPrec()){ //EXERCICE PRECEDENT
            appli.afficheExercicePrecedant(leMenu.getExoEnCours());
        }else if(e.getSource() == leMenu.getButTentSuiv()){ //TENTATIVE SUIVANTE
            appli.afficheTentativeSuivante(leMenu.getExoEnCours(),leMenu.getReaEnCours());
        }else if (e.getSource() == leMenu.getButTentPrec()){ //TENTATIVE PRECEDENTE
            appli.afficheTentativePrecedante(leMenu.getExoEnCours(),leMenu.getReaEnCours());
        }else if (e.getSource() == leMenu.getButRejouerTent()){ //REJOUER SA TENTATIVE
            appli.afficheRejouerRea(leMenu.getReaEnCours());
        }
    }
}