package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.PanelAffReaArbre;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe permettant d'écouter les actions effectuées sur un modèle
 * Il s'agit d'un contrôleur par rapport à l'arbre des réalisations des élèves
 * 
 * @author Groupe 2
 */
public class CtrlAffReaArbre implements ActionListener{

    private ApplicationProf appli;
    private PanelAffReaArbre myPanel;
    private Realisation rea;
    private Eleve el;
    
    /**
     * Constructeur du controleur CtrlAffReaArbre
     * @param lePanel : panel affichant les réalisations (JTree)
     * @param laRea : réalisation choisie
     * @param lAppli : application utilisée
     * @param lEleve : élève choisie
     */
    public CtrlAffReaArbre(PanelAffReaArbre lePanel,Realisation laRea,ApplicationProf lAppli, Eleve lEleve){
        appli = lAppli;
        myPanel = lePanel;
        rea = laRea;
        el = lEleve;
    }
    
    @Override
    /**
     * Méthode actionPerformed
     * Permet d'effectuer une action après avoir cliqué sur un bouton
     * @param e : action event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myPanel.getButEvaluer()){
            appli.evaluerRealisation(rea,el);
        }
    }
}
