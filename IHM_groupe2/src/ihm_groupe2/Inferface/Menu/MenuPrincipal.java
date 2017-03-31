package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlMenuPrincipal;
import Applications.MainFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe MenuPrincipal
 * Permet de créer le menu principal qui proposera deux boutons
 * L'un pour renvoyer vers la page de connexion d'un élève et l'autre pour la connexion d'un professeur
 * @author Jonathan
 */
public class MenuPrincipal extends JPanel{
    
    
    // Les bontons renverrons vers le controleur du menu principal "CtrlMenuPrincipal"
    // selon la source on aura un affichage de l'un des deux panels de connexion
    private JButton butConnectEleve;
    private JButton butConnectProf;
    private JLabel texteMenu;
    private CtrlMenuPrincipal controleur;
    private MainFrame fenetreMain;
    
    /**
     * Constructeur de la classe MenuPrincipal
     */
    public MenuPrincipal(MainFrame main){
        fenetreMain = main;
        texteMenu = new JLabel("Se connecter en tant que :");
        //texteMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        butConnectEleve = new JButton("Eleve");
        butConnectProf = new JButton("Professeur");
        
 
        
        controleur = new CtrlMenuPrincipal(this);
        butConnectEleve.addActionListener(controleur);
        butConnectProf.addActionListener(controleur);
        
        
        
        this.add(texteMenu);
        this.add(butConnectEleve);
        this.add(butConnectProf);
        this.setBackground(Color.WHITE);
        
    }
    
    public JButton getButtonEleve(){
        return butConnectEleve;
    }
    
    public MainFrame getMainFrame(){
        return fenetreMain;
    }
    
    
}
