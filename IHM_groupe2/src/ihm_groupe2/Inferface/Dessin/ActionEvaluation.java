package ihm_groupe2.Inferface.Dessin;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * La classe ActionEvaluation représente le panel comprenant les options pour évaluer un élève
 * Il y a 3 boutons correspondants aux 3 notes possibles : acquis, non acquis ou en cours d'acquisition
 * Ces boutons appeleront le contrôleur de l'évaluation
 * Selon la source du boutton, la valeur de l'évaluation sera modifiée par le contrôleur
 * 
 * @author Groupe 2
 */
public class ActionEvaluation extends JPanel {
    
    //Déclaration des 3 boutons pour l'évaluation
    private JButton butAcquis;    //noteExercice prendra la valeur acquis, et changera le booléen "valide" à vrai dans la classe Evaluation
    private JButton butEnCours;   //noteExercice prendra la valeur en cours d'acquisition
    private JButton butNonAcquis;     //noteExercice prendra la valeur non acquis
    
    
    /**
     * Constructeur du JPanel ActionEvaluation
     * Initialise les 3 bouttons
     */
    public ActionEvaluation(){
        
    }
    
    
}
