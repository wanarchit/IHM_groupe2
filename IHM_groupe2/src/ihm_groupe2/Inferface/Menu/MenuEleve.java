package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Noyau_fonctionnel.Eleve;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe MenuEleve
 * Permet de créer le menu d'un eleve
 * Dans ce menu on affichera les exercices à faires, les exercices réalisés, les tentatives et les évaluations
 * @author Paul
 */
public class MenuEleve extends JPanel{
    
    private Eleve eleveConnecte;        // Conserve l'enfant qui est connecté
    
    // Les boutons execrcicePrec/Suiv mettent à jour les labels "commExo" et "NomExo" et l'icone "iconExo" via le controleur "crtlMenuEleve"
    // Les bouton tentPrec/Suiv mettent à jour les labels "commTent" et "numTent" via le controleur "ctrlMenuEleve"
    private JButton butPrecExo;         // Bouton qui permet d'afficher l'exercice précédant
    private JButton butSuivExo;         // Boutton qui permet d'afficher l'exercice suivant
    private JButton butPrecTent;        // Button qui permet d'afficher la tentative de l'élève pour l'exercice selectionné
    private JButton butSuivTent;        // Button qui permet d'afficher la tentative de l'élève pour l'exercice selectionnée
    private JLabel labCommExo;          // Label pour afficher le commentaire de l'exercice selectionné
    private JLabel labCommTent;         // Label pour afficher le commentaire (s'il y en a un) de la tentative selectionné
    private JLabel labNomExo;           // Label pour afficher le nom de l'exercice selectionné
    private JLabel labNumTent;          // Label pour afficher le numéro de la tentative selectionnée
    private ImageIcon iconExo;          // Image de l'exercice selectionnée
    //private ImageIcon iconTentative; // image de la tentative selectionnée de l'elève
    
    /**
     * Constructeur de la classe MenuEleve
     * Permet de créer le menu pour un eleve
     * @param eleve : concerné par le menu (ses dessins)
     */
    public MenuEleve(Eleve eleve){
        eleveConnecte = eleve;
    }
}
