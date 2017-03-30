package ihm_groupe2.Inferface.Dessin;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * La classe console représente le panel de la console. 
 * Cette console est présente au lors de la réalisation des exercices.
 * Elle permet d'afficher les actions effectuées par la tortue selon les choix de l'enfant
 * 
 * Elle est composée d'un JLabel comprenant les actions effectuées.
 * Elle est mise à jour à chaque action donc via les contrôleurs d'actions
 * 
 * @author Groupe 2
 */
public class Console extends JPanel {
    
    //Déclaration du label de la console
    private JLabel labelConsole;
    
    /**
     * Constructeur de la classe console
     */
    public Console (){
        
    }
    
    /**
     * Méthode permettant de mettre à jour le texte de la console
     * Elle commence par récupérer le texte existante et y ajouter "leTexte"
     * @param leTexte : récupère le texte à ajouter
     */
    public void setTexteConsole(String leTexte){
        
    }
}
