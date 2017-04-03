package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Menu.MenuEleve;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlMenuEleve
 * Permet de gérer les actions effectuées grâces aux 4 boutons dans le menu de l'élève
 * Les 4 bontons permettent de changer les exercices ou les tentatives de l'élève
 * Une action sur l'un des boutons va permettre de modifier les labels et les images des exercices/tentatives
 * 
 * @author Paul
 */
public class CtrlMenuEleve implements ActionListener{
    
    //private Eleve eleve;
    private MenuEleve leMenu;
    private ApplicationEleve appli;
    /**
     * Constructeur du controleur du MenuEleve
     * @param lEleve 
     */
    public CtrlMenuEleve(MenuEleve menuEleve,ApplicationEleve lAppli){
        //eleve = lEleve;
        leMenu = menuEleve;
        appli=lAppli;
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        //Eleve leEleve = new Eleve(null,null,"Rousse","Delphine");
        if (e.getSource() == leMenu.getButFaireExo() ){
            appli.faireExercice();
        }
    
        
        
    }
}
