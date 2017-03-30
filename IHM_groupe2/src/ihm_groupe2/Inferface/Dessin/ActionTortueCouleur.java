package ihm_groupe2.Inferface.Dessin;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe ActionTortueCouleur
 * Cette classe permet de créer le panel qui contiendra les boutons spécifiques
 * de la tortue couleur
 * @author Jonathan
 */
public class ActionTortueCouleur extends ActionTortueG {
    /**
     * JPanel contenant les six boutons permettant de changer de couleur
     * GridLayout (3,2)
     */
    protected JPanel butCouleur;
    
    /**
     * Ce boutton permet que le tracé fait par la tortue est de couleur rouge
     * Renvoi au controleur des actions de la tortue ActionTortue et active 
     * la fonction setCouleur(String coul) provenant de la classe TortueCouleur. 
     */
    protected JButton butRouge;
    
    /**
     * Ce boutton permet que le tracé fait par la tortue est de couleur bleu
     * Renvoi au controleur des actions de la tortue ActionTortue et active 
     * la fonction setCouleur(String coul) provenant de la classe TortueCouleur. 
     */
    protected JButton butBleu;
    
    /**
     * Ce boutton permet que le tracé fait par la tortue est de couleur vert
     * Renvoi au controleur des actions de la tortue ActionTortue et active 
     * la fonction setCouleur(String coul) provenant de la classe TortueCouleur. 
     */
    protected JButton butVert;
    
    /**
     * Ce boutton permet que le tracé fait par la tortue est de couleur rose
     * Renvoi au controleur des actions de la tortue ActionTortue et active 
     * la fonction setCouleur(String coul) provenant de la classe TortueCouleur. 
     */
    protected JButton butRose;
    
    /**
     * Ce boutton permet que le tracé fait par la tortue est de couleur violet
     * Renvoi au controleur des actions de la tortue ActionTortue et active 
     * la fonction setCouleur(String coul) provenant de la classe TortueCouleur. 
     */
    protected JButton butViolet;

    /**
     * Ce boutton permet que le tracé fait par la tortue est de couleur jaune
     * Renvoi au controleur des actions de la tortue ActionTortue et active 
     * la fonction setCouleur(String coul) provenant de la classe TortueCouleur. 
     */
    protected JButton bouttonJaune;

    public ActionTortueCouleur (){
        super();
     /**
     * Ajout des JButton au panel ActionCouleurTortue
     * Ajout du Panel ActionCouleurTortue au panel ActionTortue
     */
    }
}
