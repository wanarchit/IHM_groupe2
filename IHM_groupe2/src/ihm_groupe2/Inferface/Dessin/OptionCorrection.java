package ihm_groupe2.Inferface.Dessin;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 *
 * @author Jonathan
 */
public class OptionCorrection {
    private JPanel panelOptionCorrection; //va contenir les trois boutons
    private JButton butRejouerModeleEleve; //intéragis avec Realisation.getCommandeInLIste() et Commande.doAction()
    private JButton butValiderEval; //intéragis avec Evaluation.setValidation(bool) et Realisation.setACorriger(bool), le passe à false
    private JButton butAnnulerEval; //intéragis avec Realisation.setACorriger et le laisse à true
    
    public OptionCorrection() {
        
    }
}
