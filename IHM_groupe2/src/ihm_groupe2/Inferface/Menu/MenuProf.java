package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Inferface.MainFrame;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe MenuProf
 * Peremt de créer le panel du menu du professeur (avec ses exercices, les classes et les élèves)
 * @author Paul
 */
public class MenuProf extends JPanel{
    
    private MainFrame fenetreMain;
    private Professeur profConnecte;
    // 4 bouttons qui va modifier le panel de droite de ce menu
    private JButton butCreerExo;        // on affichera un panel contenant le formulaire de création d'un exercice "PanelCreerExo"
    private JButton butVoirExo;         // on affichera un panel contenant la liste des exercies "PanelModifExo"
    private JButton butVoirEleve;       // on affichera un panel contenant la liste des eleves
    private JButton butVoirClasse;      // on affichera un panel contenant la liste des classes
    
    /**
     * constructeur de la classe MenuProf
     * Il sera initialisé avec un panel contenant les 4 boutons et un panel vide à droite.
     * @param leProf qui s'est connecté
     */
    public MenuProf(Professeur leProf, MainFrame main){
        profConnecte = leProf;
        fenetreMain = main;
        
        JLabel monLabel = new JLabel("Prénom : " + profConnecte.getPrenomPersonne());
        JLabel monLabel2 = new JLabel("Nom : " + profConnecte.getNomPersonne());
        this.add(monLabel);
        this.add(monLabel2);
        
        
        fenetreMain.setContentPane(this);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
}
