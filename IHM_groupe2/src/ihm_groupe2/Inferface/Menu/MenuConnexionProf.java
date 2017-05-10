package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlConnProf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
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
 * @author Groupe 2
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

        JPanel panConsigne = new JPanel();
        JLabel bienvenue = new JLabel(new ImageIcon(getClass().getResource("/Images/BienvenueProf.png")));
        bienvenue.setPreferredSize(new Dimension(900,217));
        panConsigne.add(bienvenue);
        panConsigne.setBackground(Color.white);
        
        
        JPanel panLogin = new JPanel();
        JLabel textLogin = new JLabel("Identifiant : ");
        textLogin.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));
        textLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        champsLogin = new JTextField(20);
        panLogin.add(textLogin);
        panLogin.add(champsLogin);
        
        JPanel panMdp = new JPanel();
        JLabel textMdp = new JLabel("Mot de passe : ");
        textMdp.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));
        textMdp.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        champsMdp = new JPasswordField(20);
        panMdp.add(textMdp);
        panMdp.add(champsMdp);
        
        JPanel panIden = new JPanel();
        panIden.add(new JLabel(new ImageIcon(getClass().getResource("/Images/ConnexionProf.png"))));
        panIden.add(panLogin);
        panIden.add(panMdp);
        
        JPanel panButVal = new JPanel();
        validationConnexion = new JButton(new ImageIcon(getClass().getResource("/Images/Connexion1.jpg")));
        validationConnexion.setPreferredSize(new Dimension(200,50));
        validationConnexion.setBorderPainted(false);
        
        panButVal.add(validationConnexion);
        
        JPanel panButAnn = new JPanel();
        annulerConnexion = new JButton(new ImageIcon(getClass().getResource("/Images/Annuler1.jpg")));
        annulerConnexion.setPreferredSize(new Dimension(200,50));
        annulerConnexion.setBorderPainted(false);
        panButAnn.add(annulerConnexion);
        
        JPanel panBut = new JPanel();
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
