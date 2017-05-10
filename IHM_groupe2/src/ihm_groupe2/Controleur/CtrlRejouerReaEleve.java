package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.RejouerReaEleve;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlRejouerReaEleve
 * Controleur gérant les actions au niveau du rejoue des réalisations
 * de l'élève
 * 
 * @author Groupe 2
 */
public class CtrlRejouerReaEleve implements ActionListener{
    
    private RejouerReaEleve leMenu;
    
    /**
     * Constructeur du controleur CtrlRejouerReaEleve
     * @param menu : menu de l'élève
     */
    public CtrlRejouerReaEleve(RejouerReaEleve menu){
        leMenu = menu;
    }

    @Override
    /**
     * Méthode actionPerformed
     * Permet d'appeler la fonction correspondante selon le bouton/action 
     * réalisée.
     * Les actions peuvent être retour - avancer - reculer
     * @param e : action event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leMenu.getButRetour()){ //RETOUR
            leMenu.dispose();
        }else if (e.getSource() == leMenu.getButAvance()){ //AVANCER
            leMenu.avancer();
        }else if (e.getSource() == leMenu.getButRecule()){ //RECULER
            leMenu.annuler();
        }
    }
}