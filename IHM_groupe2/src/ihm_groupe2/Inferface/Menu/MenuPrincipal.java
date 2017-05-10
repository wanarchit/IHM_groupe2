package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlMenuPrincipal;
import Applications.MainFrame;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * Classe MenuPrincipal
 * Permet de créer le menu principal qui proposera deux boutons
 * L'un pour renvoyer vers la page de connexion d'un élève et l'autre pour la connexion d'un professeur
 * @author Groupe 2
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
     * @param main : Renvoie la mainframe de l'application
     */
    public MenuPrincipal(MainFrame main){
        fenetreMain = main;
        
        JPanel panel1 = new JPanel();
        JLabel bienvenue = new JLabel(new ImageIcon(getClass().getResource("/Images/BienvenueGeneral.png")));
        bienvenue.setPreferredSize(new Dimension(900,217));
        panel1.add(bienvenue);
        panel1.setBackground(Color.white);
        
        
        JPanel panel3 = new JPanel(new GridLayout(1,2));
        JPanel ssPanel1 = new JPanel();
        butConnectEleve = new JButton(new ImageIcon(getClass().getResource("/Images/Enfant.jpg")));
        butConnectEleve.setPreferredSize(new Dimension(400,400));
        ssPanel1.add(butConnectEleve);
        ssPanel1.setBackground(Color.white);
        
        JPanel ssPanel2 = new JPanel();
        butConnectProf = new JButton(new ImageIcon(getClass().getResource("/Images/Professeur.png")));
        butConnectProf.setPreferredSize(new Dimension(400,400));
        ssPanel2.add(butConnectProf);
        ssPanel2.setBackground(Color.white);
        panel3.add(ssPanel1);
        panel3.add(ssPanel2);
        panel3.setBackground(Color.white);      
        JPanel panel4 = new JPanel(new BorderLayout());
        panel4.add(panel1,BorderLayout.NORTH);
        panel4.add(panel3,BorderLayout.SOUTH);
        panel4.setBackground(Color.white);       
        controleur = new CtrlMenuPrincipal(this);
        butConnectEleve.addActionListener(controleur);
        butConnectProf.addActionListener(controleur);
        this.add(panel4);     
    }
    /**
     * Méthode getButtonEleve
     * @return butConnectEleve: JButton
     */
    public JButton getButtonEleve(){
        return butConnectEleve;
    }
    /**
     * Méthode getMainFrame
     * @return fenetreMain: MainFrame
     */
    public MainFrame getMainFrame(){
        return fenetreMain;
    }
    
    
}
