package ihm_groupe2.Inferface.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Classe MenuPrincipal
 * Permet de créer le menu principal qui proposera deux boutons
 * L'un pour renvoyer vers la page de connexion d'un élève et l'autre pour la connexion d'un professeur
 * @author Jonathan
 */
public class MenuPrincipal extends JPanel{
    
    
    // Les bontons renverrons vers le controleur de connexion
    // selon la source on aura un affichage de l'un des deux panels de connexion
    private JButton butConnectEleve;
    private JButton butConnectProf;
    
    /**
     * Constructeur de la classe MenuPrincipal
     */
    public MenuPrincipal(){
        
    }
}
