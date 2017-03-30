package ihm_groupe2.Controleur;

import ihm_groupe2.Noyau_fonctionnel.Eleve;

/**
 * Classe CtrlMenuEleve
 * Permet de gérer les actions effectuées grâces aux 4 boutons dans le menu de l'élève
 * Les 4 bontons permettent de changer les exercices ou les tentatives de l'élève
 * Une action sur l'un des boutons va permettre de modifier les labels et les images des exercices/tentatives
 * 
 * @author Paul
 */
public class CtrlMenuEleve {
    
    private Eleve eleve;
    
    /**
     * Constructeur du controleur du MenuEleve
     * @param lEleve 
     */
    public CtrlMenuEleve(Eleve lEleve){
        eleve = lEleve;
        
    }
}
