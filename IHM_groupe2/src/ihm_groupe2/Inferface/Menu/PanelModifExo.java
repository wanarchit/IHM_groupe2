package ihm_groupe2.Inferface.Menu;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Classe PanelModifExo
 * Panel qui contient le formulaire pour pouvoir modifier un exercice
 * Il y aura plusieurs champs : Nom exercice, Tortue choisi, Commentaire exercice, modifier Image exercice
 * Les champs seront préremplis avec les information de l'exercice selectionné
 * Il y aura un bouton de validation du formulaire qui renverra vers le controleur de validation du formulaire d'exercices
 * S'il n'y a aucune modification alors l'utilisateur sera simplement renvoyé vers la page de la liste des exercices
 * Sinon il y aura un controle des champs via le controleur "ControlFormExo"
 * @author Paul
 */
public class PanelModifExo extends JPanel{
    
    private JButton butValidForm;           // Permet d'enregistrer un nouvel exercice
    // Ce boutton va utiliser un controleur qui va vérifier le contenu du fomrulaire et créer un nouvel exercice.
    
    private JRadioButton butRadChoixTortue;     // Permet de renseigner le choix de la torute
    private JTextField textFieldNomExo;     // Permet de renseigner le nom de l'exercice
    private JTextField textFieldCommExo;    // Permet de renseigner le commentaire de l'exercice
    // private UploadFile -> Image; // Permet de charger l'image de l'exercice
    
    public PanelModifExo(){
        
    }
}
