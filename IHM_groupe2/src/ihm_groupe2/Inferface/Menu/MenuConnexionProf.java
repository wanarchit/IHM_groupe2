package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlConnProf;
import Applications.MainFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Classe MenuConnexionProf
 * Permet de créer le panel du menu de connexion pour un professeur
 * Ce panel contient un bouton de validation des informations, il permettra de vérifier les informations
 * et de rediriger le professeur vers le menu du professeur "MenuProf" via le controleur "CtrlConnProf"
 * 
 * @author Paul
 */
public class MenuConnexionProf extends JPanel{
    
    // Permet de valider les informations de connexion de l'élève
    private JButton validationConnexion;
    private MainFrame fenetreMain;
    private CtrlConnProf controleur;
    
    // Champs pour le formulaire de connexion
    private JTextField champsLogin;
    private JPasswordField champsMdp;
    
    public MenuConnexionProf(MainFrame main){
        fenetreMain = main;
        
        JLabel textLogin = new JLabel("Entre votre login : ");
        champsLogin = new JTextField(20);
        JLabel textMdp = new JLabel("Entre votre mot de passe : ");
        champsMdp = new JPasswordField(20);
        
        
        JLabel texteConnexion = new JLabel("Vous connecter : ");
        validationConnexion = new JButton("Se connecter");
        
        controleur = new CtrlConnProf(this);
        validationConnexion.addActionListener(controleur);
        
        this.add(textLogin);
        this.add(champsLogin);
        this.add(textMdp);
        this.add(champsMdp);
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
