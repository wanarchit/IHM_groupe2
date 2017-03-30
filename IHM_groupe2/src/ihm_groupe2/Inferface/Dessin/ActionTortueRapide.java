package ihm_groupe2.Inferface.Dessin;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @author Marin
 * Permet de créer un interface pour intéragir avec tortue rapide lors de la réalisation d'un exo
 */
public class ActionTortueRapide extends JPanel{
    JButton accelerer = new JButton(); //Interagit avec TortueRapide.accelerer() via l'actionListener
    JButton freiner = new JButton(); //Interagit avec TortueRapide.freiner() via l'actionListener
    
    
    /**
     * Constructeur de la classe ActionTortueRapide
     */
    public ActionTortueRapide(){
        
    }
    
}
