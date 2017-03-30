package ihm_groupe2.Inferface.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Classe PanelCreerExo
 * Panel qui contient le formulaire pour pouvoir créer un exercice
 * Il y aura plusieurs champs : Nom exercice, Tortue choisi, Commentaire exercice, ajouter Image exercice
 * Il y aura un boutton de validation du formulaire qui renverra vers le controleur de validation du formulaire de création d'exercice
 * @author Paul
 */
public class PanelCreerExo extends JPanel{
    
    private JButton butValidForm;           // Permet d'enregistrer un nouvel exercice
    // Ce boutton va utiliser un controleur qui va vérifier le contenu du fomrulaire et créer un nouvel exercice.
    
    private JRadioButton butRadChoixTortue;     // Permet de renseigner le choix de la torute
    private JTextField textFieldNomExo;     // Permet de renseigner le nom de l'exercice
    private JTextField textFieldCommExo;    // Permet de renseigner le commentaire de l'exercice
    // private UploadFile -> Image; // Permet de charger l'image de l'exercice
    
    public PanelCreerExo(){
        
    }
}
