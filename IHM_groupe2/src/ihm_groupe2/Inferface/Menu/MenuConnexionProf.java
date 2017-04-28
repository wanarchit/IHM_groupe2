package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlConnProf;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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
        
        JLabel label1 = new JLabel("Merci d'entrer vos identifiants :");
        JPanel panConsigne = new JPanel();
        panConsigne.add(label1);
        
        JPanel panLogin = new JPanel();
        JLabel textLogin = new JLabel("Entre votre login : ");
        champsLogin = new JTextField(20);
        panLogin.add(textLogin);
        panLogin.add(champsLogin);
        JPanel panMdp = new JPanel();
        JLabel textMdp = new JLabel("Entre votre mot de passe : ");
        champsMdp = new JPasswordField(20);
        panMdp.add(textMdp);
        panMdp.add(champsMdp);
        
        JPanel panIden = new JPanel();
        panIden.add(panLogin);
        panIden.add(panMdp);
        
        JPanel panButVal = new JPanel();
        validationConnexion = new JButton("Se connecter");
        panButVal.add(validationConnexion);
        
        JPanel panButAnn = new JPanel();
        annulerConnexion = new JButton("Annuler");
        panButAnn.add(annulerConnexion);
        
        JPanel panBut = new JPanel(new GridLayout(1,2));
        panBut.add(panButVal);
        panBut.add(panButAnn);
        
        JPanel panConnexion = new JPanel(new BorderLayout());
        panConnexion.add(panIden,BorderLayout.NORTH);
        panConnexion.add(panBut,BorderLayout.CENTER);
        
        controleur = new CtrlConnProf(this,appliProf);
        validationConnexion.addActionListener(controleur);
        annulerConnexion.addActionListener(controleur);
        
        this.setLayout(new BorderLayout());
        this.add(panConsigne, BorderLayout.NORTH);
        this.add(panConnexion,BorderLayout.CENTER);        
        
        
         
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
