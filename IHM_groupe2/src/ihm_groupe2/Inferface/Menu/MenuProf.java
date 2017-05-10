package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlMenuProf;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Classe MenuProf
 * Permet de créer le panel du menu du professeur (avec ses exercices, les classes et les élèves
 * @author Groupe 2
 */
public class MenuProf extends JPanel{
    
    private ApplicationProf appli;
    private Professeur profConnecte;
    private CtrlMenuProf controleur;
    private JPanel panelDroite,panelGauche;
    
    
    // 4 bouttons qui va modifier le panel de droite de ce menu
    private JButton butCreerExo;        // on affichera un panel contenant le formulaire de création d'un exercice "PanelCreerExo"
    private JButton butVoirExo;         // on affichera un panel contenant la liste des exercies "PanelModifExo"
    private JButton butVoirEleve;       // on affichera un panel contenant la liste des eleves
    private JButton butVoirClasse;      // on affichera un panel contenant la liste des classes
    private JButton butSeDeco;
    
    /**
     * constructeur de la classe MenuProf
     * Il sera initialisé avec un panel contenant les 4 boutons et un panel vide à droite.
     * @param leProf qui s'est connecté
     * @param lAppli application en cours
     */
    public MenuProf(Professeur leProf, ApplicationProf lAppli){
        profConnecte = leProf;
        appli = lAppli;

        JPanel labTitre = new JPanel();
        JLabel bienvenue = new JLabel(new ImageIcon(getClass().getResource("/Images/AccueilProf.png")));
        bienvenue.setPreferredSize(new Dimension(900,300));
        labTitre.add(bienvenue);
        labTitre.setBackground(Color.white);
        
        JLabel monLabel = new JLabel(profConnecte.getPrenomPersonne() + " " + profConnecte.getNomPersonne());
        monLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        monLabel.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        
        JPanel panelSousDroite = new JPanel();
        panelSousDroite.add(new JLabel(new ImageIcon(getClass().getResource("/Images/Utilisateur.png"))));
        panelSousDroite.add(monLabel);
        
        butCreerExo = new JButton(new ImageIcon(getClass().getResource("/Images/CreerExo.png")));
        butCreerExo.setPreferredSize(new Dimension(250,51));
        
        butVoirExo = new JButton(new ImageIcon(getClass().getResource("/Images/ListeExos.png")));
        butVoirExo.setPreferredSize(new Dimension(250,51));
        
        butVoirEleve = new JButton(new ImageIcon(getClass().getResource("/Images/ListeEleves.png")));
        butVoirEleve.setPreferredSize(new Dimension(250,51));
        
        butVoirClasse = new JButton(new ImageIcon(getClass().getResource("/Images/ListeClasses.png")));
        butVoirClasse.setPreferredSize(new Dimension(250,51));     
        
        butSeDeco = new JButton(new ImageIcon(getClass().getResource("/Images/Deconnexion.png")));
        butSeDeco.setPreferredSize(new Dimension(250,51));
        
        controleur = new CtrlMenuProf(appli,this);
        butCreerExo.addActionListener(controleur);
        butVoirExo.addActionListener(controleur);
        butVoirEleve.addActionListener(controleur);
        butVoirClasse.addActionListener(controleur);
        butSeDeco.addActionListener(controleur);
                
                
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        JPanel panBut1 = new JPanel();
        panBut1.setLayout(new GridBagLayout());
        panBut1.add(butCreerExo, gbc);
        
        JPanel panBut2 = new JPanel();
        panBut2.setLayout(new GridBagLayout());
        panBut2.add(butVoirExo, gbc);
        
        JPanel panBut3 = new JPanel();
        panBut3.setLayout(new GridBagLayout());
        panBut3.add(butVoirEleve, gbc);
        
        JPanel panBut4 = new JPanel();
        panBut4.setLayout(new GridBagLayout());
        panBut4.add(butVoirClasse, gbc);   
        
        JPanel panBut5 = new JPanel();
        panBut5.setLayout(new GridBagLayout());
        panBut5.add(butSeDeco, gbc);
                
        panelGauche = new JPanel();
        panelGauche.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panelGauche.setLayout(new GridLayout(5,1));
        panelGauche.add(panBut1);
        panelGauche.add(panBut2);
        panelGauche.add(panBut3);
        panelGauche.add(panBut4);
        panelGauche.add(panBut5);
        
        panelDroite = new JPanel(new GridLayout(2,1));
        panelDroite.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panelDroite.add(labTitre);
        panelDroite.add(panelSousDroite);
        
        this.setLayout(new BorderLayout());
        this.add(panelGauche, BorderLayout.WEST);
        this.add(panelDroite, BorderLayout.CENTER);
    }
    /**
     * Méthode setPanelDroite
     * @param newPanel Panel a affecté à droite
     */
    public void setPanelDroite(JPanel newPanel){
        this.add(panelGauche, BorderLayout.WEST);
        this.add(newPanel, BorderLayout.CENTER);
    }
    /**
     * Méthode getButtonCreerExo
     * @return butCreerExo: JButton
     */
    public JButton getButtonCreerExo(){
        return butCreerExo;
    }
    /**
     * Méthode getButtonExo
     * @return butVoirExo: JButton
     */
    public JButton getButtonExo(){
        return butVoirExo;
    }
    /**
     * Méthode getButtonEleve
     * @return butVoirEleve: JButton
     */
    public JButton getButtonEleve(){
        return butVoirEleve;
    }
    /**
     * Méthode getButtonClasse
     * @return butVoirClasse: JButton
     */
    public JButton getButtonClasse(){
        return butVoirClasse;
    }
    /**
     * Méthode getButtonDeco
     * @return butSeDeco: JButton
     */
    public JButton getButtonDeco(){
        return butSeDeco;
    }
}
