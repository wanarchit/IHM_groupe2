package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
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
    private JButton annulerConnexion;
    private ApplicationProf appliProf;
    private CtrlConnProf controleur;
    
    // Champs pour le formulaire de connexion
    private JTextField champsLogin;
    private JPasswordField champsMdp;
    
    public MenuConnexionProf(ApplicationProf lAppli){
        appliProf = lAppli;
                
        JLabel textLogin = new JLabel("Entre votre login : ");
        champsLogin = new JTextField(20);
        JLabel textMdp = new JLabel("Entre votre mot de passe : ");
        champsMdp = new JPasswordField(20);
        
        
        JLabel texteConnexion = new JLabel("Vous connecter : ");
        validationConnexion = new JButton("Se connecter");
        annulerConnexion = new JButton("Annuler");
        
        controleur = new CtrlConnProf(this,appliProf);
        validationConnexion.addActionListener(controleur);
        annulerConnexion.addActionListener(controleur);
        
        this.add(textLogin);
        this.add(champsLogin);
        this.add(textMdp);
        this.add(champsMdp);
        this.add(texteConnexion);
        this.add(validationConnexion);
        this.add(annulerConnexion);
         
    }
    
    public JTextField getTextLogin(){
        return champsLogin;
    }
            
    public JTextField getTextMdp(){
        return champsMdp;
    }
    
    public JButton getButValidation(){
        return validationConnexion;
    }
    
    public JButton getButAnnuler(){
        return annulerConnexion;
    }
}
