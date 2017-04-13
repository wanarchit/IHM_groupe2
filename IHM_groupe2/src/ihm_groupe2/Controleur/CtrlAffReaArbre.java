package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.PanelAffReaArbre;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Paul
 */
public class CtrlAffReaArbre implements ActionListener{

    private ApplicationProf appli;
    private PanelAffReaArbre myPanel;
    private Realisation rea;
    
    public CtrlAffReaArbre(PanelAffReaArbre lePanel,Realisation laRea,ApplicationProf lAppli){
        appli = lAppli;
        myPanel = lePanel;
        rea = laRea;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == myPanel.getButEvaluer()){
            appli.evaluerRealisation(rea);
        }
    }
    
}
