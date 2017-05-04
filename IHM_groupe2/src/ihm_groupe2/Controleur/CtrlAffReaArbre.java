package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.PanelAffReaArbre;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Groupe 2
 */
public class CtrlAffReaArbre implements ActionListener{

    private ApplicationProf appli;
    private PanelAffReaArbre myPanel;
    private Realisation rea;
    private Eleve el;
    
    public CtrlAffReaArbre(PanelAffReaArbre lePanel,Realisation laRea,ApplicationProf lAppli, Eleve lEleve){
        appli = lAppli;
        myPanel = lePanel;
        rea = laRea;
        el = lEleve;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myPanel.getButEvaluer()){
            appli.evaluerRealisation(rea,el);
        }
    }
    
}
