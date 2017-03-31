package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlConnEleve;
import Applications.MainFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Classe MenuConnexionEleve
 Permet de créer le panel du menu de connexion pour un eleve
 Ce panel sera un formulaire de connexion qui demande le nom d'un élève et son prénom
 Un bouton de validation permettra de récupérer le nom de l'élève dans la base de données
 et ainsi l'élève sera redirigé vers son menu avec ses exercices grâce au controleur "CtrlConnEleve"
 * 
 * @author Paul
 */
public class MenuConnexionEleve extends JPanel{
    
    // Permet de valider les informations de connexion de l'élève
    private JButton validationConnexion;
    private MainFrame fenetreMain;
    private CtrlConnEleve controleur;
    
    // champs pour le formulaire
    private JTextField champsNom;
    private JTextField champsPrenom;
    
    public MenuConnexionEleve(MainFrame main){
        fenetreMain = main;
        
        
        
        
        JLabel textPrenom = new JLabel("Entre ton prénom : ");
        champsPrenom = new JTextField(20);
        JLabel textNom = new JLabel("Entre ton nom : ");
        champsNom = new JTextField(20);
        
        JLabel texteConnexion = new JLabel("te connecter : ");
        validationConnexion = new JButton("Je me connecte");
        
        controleur = new CtrlConnEleve(this);
        validationConnexion.addActionListener(controleur);
        
        this.add(textPrenom);
        this.add(champsPrenom);
        this.add(textNom);
        this.add(champsNom);
        this.add(texteConnexion);
        this.add(validationConnexion);
        
        fenetreMain.setContentPane(this);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public MainFrame getMainFrame(){
        return fenetreMain;
    }
    
}
