package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlMenuPrincipal;
import Applications.MainFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Classe MenuPrincipal
 * Permet de créer le menu principal qui proposera deux boutons
 * L'un pour renvoyer vers la page de connexion d'un élève et l'autre pour la connexion d'un professeur
 * @author Groupe2
 */
public class MenuPrincipal extends JPanel{
    
    
    // Les bontons renverrons vers le controleur du menu principal "CtrlMenuPrincipal"
    // selon la source on aura un affichage de l'un des deux panels de connexion
    private JButton butConnectEleve;
    private JButton butConnectProf;
    private CtrlMenuPrincipal controleur;
    private MainFrame fenetreMain;
    
    /**
     * Constructeur de la classe MenuPrincipal
     */
    public MenuPrincipal(MainFrame main){
        fenetreMain = main;
        
        JPanel panel1 = new JPanel(new GridLayout(2,1));
        JLabel labelBonjour = new JLabel("Bienvenue");
        labelBonjour.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,40));
        labelBonjour.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        JLabel texteMenu = new JLabel("Se connecter en tant que :");
        texteMenu.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,18));
        texteMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        panel1.add(labelBonjour);
        panel1.add(texteMenu);
        
        JPanel panel3 = new JPanel(new GridLayout(1,2));
        JPanel ssPanel1 = new JPanel();
        butConnectEleve = new JButton(new ImageIcon(getClass().getResource("/Images/Enfant.jpg")));
        butConnectEleve.setPreferredSize(new Dimension(400,400));
        ssPanel1.add(butConnectEleve);
        
        JPanel ssPanel2 = new JPanel();
        butConnectProf = new JButton(new ImageIcon(getClass().getResource("/Images/Professeur.png")));
        butConnectProf.setPreferredSize(new Dimension(400,400));
        ssPanel2.add(butConnectProf);
        panel3.add(ssPanel1);
        panel3.add(ssPanel2);
        
        JPanel panel4 = new JPanel(new BorderLayout());
        //panel4.add(panel2,BorderLayout.NORTH);
        //panel4.add(panel3,BorderLayout.CENTER);
        panel4.add(panel1,BorderLayout.NORTH);
        panel4.add(panel3,BorderLayout.SOUTH);
        
        controleur = new CtrlMenuPrincipal(this);
        butConnectEleve.addActionListener(controleur);
        butConnectProf.addActionListener(controleur);
        
        
        //this.setLayout(new GridLayout(1,1));
        //this.add(panel1);
        this.add(panel4);
        this.setBackground(Color.WHITE);
        
    }
    
    public JButton getButtonEleve(){
        return butConnectEleve;
    }
    
    public MainFrame getMainFrame(){
        return fenetreMain;
    }
    
    
}
