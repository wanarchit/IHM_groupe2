package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlMenuProf;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Classe MenuProf
 * Peremt de créer le panel du menu du professeur (avec ses exercices, les classes et les élèves
 * @author Paul
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
     */
    public MenuProf(Professeur leProf, ApplicationProf lAppli){
        profConnecte = leProf;
        appli = lAppli;
        //fenetreMain = main;
        
        JLabel monLabel = new JLabel("Prénom : " + profConnecte.getPrenomPersonne());
        JLabel monLabel2 = new JLabel("Nom : " + profConnecte.getNomPersonne());
        
        butCreerExo = new JButton("Créer exercice");
        butVoirExo = new JButton("Liste exercices");
        butVoirEleve = new JButton("Liste élèves");
        butVoirClasse = new JButton("Liste classes");
        butSeDeco = new JButton("Se déconnecter");
        
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
        
        panelDroite = new JPanel();
        panelDroite.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panelDroite.add(monLabel);
        panelDroite.add(monLabel2);
        
        this.setLayout(new BorderLayout());
        this.add(panelGauche, BorderLayout.WEST);
        this.add(panelDroite, BorderLayout.CENTER);
    }
    
    public void setPanelDroite(JPanel newPanel){
        this.add(panelGauche, BorderLayout.WEST);
        this.add(newPanel, BorderLayout.CENTER);
    }
    
    public JButton getButtonCreerExo(){
        return butCreerExo;
    }
    
    public JButton getButtonExo(){
        return butVoirExo;
    }
    
    public JButton getButtonEleve(){
        return butVoirEleve;
    }
    
    public JButton getButtonClasse(){
        return butVoirClasse;
    }
    
    public JButton getButtonDeco(){
        return butSeDeco;
    }
}
