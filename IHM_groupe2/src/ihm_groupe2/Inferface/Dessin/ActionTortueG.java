package ihm_groupe2.Inferface.Dessin;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe mère comprenant les actions faisables par une tortue générale (avancer, tourner, écrire, ne plus écrire)
 * @author Jonathan
 */
public class ActionTortueG {
    protected JPanel panelActionTortueGenerale; //va contenir les 3 boutons
    protected JButton butAvancer; //intéragit avec la fonction TortueG.avancer()
    protected JButton butTourner; //intéragit avec la fonction TortueG.tourner()
    protected JButton butTracer; //intéragit avec la fonction TortueG.tracer(bool)
    
    
    public ActionTortueG() {
        
    }
}
