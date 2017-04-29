package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationEleve;
import ihm_groupe2.Controleur.CtrlConnEleve;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe MenuConnexionEleve
 Permet de créer le panel du menu de connexion pour un eleve
 Ce panel sera un formulaire de connexion qui demande le nom d'un élève et son prénom
 Un bouton de validation permettra de récupérer le nom de l'élève dans la base de données
 et ainsi l'élève sera redirigé vers son menu avec ses exercices grâce au controleur "CtrlConnEleve"
 * 
 * @author Paul
 */
public class MenuConnexionEleve extends JPanel{
    
    // Permet de valider les informations de connexion de l'élève

    private JButton butAnnuler;
    private ApplicationEleve appliEleve;
    private CtrlConnEleve controleur;
    //public TableEleves modeleTable;
    //private JTable tableEleves;
    private ArrayList<Eleve> lesEleves;
    private TableEleveVue tableEleve;
    
    
    public MenuConnexionEleve(ApplicationEleve lAppli){
        appliEleve = lAppli;
        lesEleves = appliEleve.getListeEleve();
        controleur = new CtrlConnEleve(this,appliEleve);
        
        tableEleve = new TableEleveVue(appliEleve);
        
        // Affichage :
            // Tableau :
        JPanel panelTable = new JPanel();
        panelTable.add(tableEleve);
        
            // Consignes :
        JLabel label1 = new JLabel("Clic sur ton prénom ou ton nom dans la liste :");
        label1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,18));
        JPanel panelConsigne = new JPanel();
        panelConsigne.add(label1);
        
            // Bouton annuler
        JPanel panButton = new JPanel();
        //butAnnuler = new JButton("Annuler");
        butAnnuler = new JButton(new ImageIcon(getClass().getResource("/Applications/images_boutons/but_exit.png")));
        butAnnuler.setPreferredSize(new Dimension(100,100));
        panButton.add(butAnnuler);
        
        this.setLayout(new BorderLayout());
        this.add(panelConsigne,BorderLayout.NORTH);
        this.add(panelTable, BorderLayout.CENTER);
        this.add(panButton, BorderLayout.SOUTH);
        
       butAnnuler.addActionListener(controleur);

    }
    
    public JButton getButAnnuler(){
        return butAnnuler;
    }
   
    
}
