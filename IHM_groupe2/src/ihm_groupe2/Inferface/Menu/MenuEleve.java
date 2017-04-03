package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationEleve;
import Applications.MainFrame;
import ihm_groupe2.Controleur.CtrlMenuEleve;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;

/**
 * Classe MenuEleve
 * Permet de créer le menu d'un eleve
 * Dans ce menu on affichera les exercices à faires, les exercices réalisés, les tentatives et les évaluations
 * @author Paul
 */
public class MenuEleve extends JPanel{
    
    private Eleve eleveConnecte;        // Conserve l'enfant qui est connecté
    private ApplicationEleve appli;
    //private MainFrame fenetreMain;
    // Les boutons execrcicePrec/Suiv mettent à jour les labels "commExo" et "NomExo" et l'icone "iconExo" via le controleur "crtlMenuEleve"
    // Les bouton tentPrec/Suiv mettent à jour les labels "commTent" et "numTent" via le controleur "ctrlMenuEleve"
    private JButton butPrecExo;         // Bouton qui permet d'afficher l'exercice précédant
    private JButton butSuivExo;         // Boutton qui permet d'afficher l'exercice suivant
    private JButton butPrecTent;        // Button qui permet d'afficher la tentative de l'élève pour l'exercice selectionné
    private JButton butSuivTent;        // Button qui permet d'afficher la tentative de l'élève pour l'exercice selectionnée
    private JTextArea labCommExo;          // Label pour afficher le commentaire de l'exercice selectionné
    private JTextArea labCommTent;         // Label pour afficher le commentaire (s'il y en a un) de la tentative selectionné
    private JLabel labNomExo;           // Label pour afficher le nom de l'exercice selectionné
    private JLabel labNumTent;          // Label pour afficher le numéro de la tentative selectionnée
    private ImageIcon iconExo;          // Image de l'exercice selectionnée
    private ImageIcon iconTent; // image de la tentative selectionnée de l'elève
    private JButton butFaireExo;
    private CtrlMenuEleve controleur;
    /**
     * Constructeur de la classe MenuEleve
     * Permet de créer le menu pour un eleve
     * @param eleve : concerné par le menu (ses dessins)
     */
    public MenuEleve(Eleve eleve,ApplicationEleve lAppli){
        eleveConnecte = eleve;
        appli = lAppli;
        
        
        /** PANEL TITRE AU NORD*/
        
        JPanel panelTitre = new JPanel();
        panelTitre.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel texteTitre = new JLabel("Bonjour "+ eleveConnecte.getPrenomPersonne() + " "+  eleveConnecte.getNomPersonne());
        panelTitre.add(texteTitre);
        
        
        /** AFFICHAGE DES EXERCICES - PARTIE HAUTE */
        
        /** Partie gauche : */
               
        JPanel panNomExo = new JPanel();
        labNomExo = new JLabel("Exercice 10");
        panNomExo.add(labNomExo);
        
        JPanel panComExo = new JPanel(new BorderLayout());
        labCommExo = new JTextArea("Tortue rapide, vous devez dessinez en moins de 30 coups le dessin ci-contre");
        labCommExo.setLineWrap(true);
        labCommExo.setWrapStyleWord(true);
        panComExo.add(labCommExo,BorderLayout.CENTER);
        
        
        /** Boutons **/
        JPanel ssPanButPrec = new JPanel();
        butPrecExo = new JButton("Précédent");
        ssPanButPrec.add(butPrecExo);
        JPanel panButPrec = new JPanel();
        panButPrec.add(ssPanButPrec);
        
        JPanel ssPanButSuiv = new JPanel();
        butSuivExo = new JButton("Suivant");
        ssPanButSuiv.add(butSuivExo);
        JPanel panButSuiv = new JPanel();
        panButSuiv.add(ssPanButSuiv);
        
        JPanel panButton = new JPanel(new GridLayout(1,2));
        panButton.add(panButPrec);
        panButton.add(panButSuiv);
        
        
        /** regroupement gauche */
        
        JPanel panGauche = new JPanel(new GridLayout(3,1));
        panGauche.add(panNomExo);
        panGauche.add(panButton);
        panGauche.add(panComExo);
        
        /** Partie droite : */
        
        JPanel panImage = new JPanel(new BorderLayout());
        panImage.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panImage.setPreferredSize(new Dimension(300,300));
        JLabel labImage = new JLabel();
        labImage.setHorizontalAlignment(JLabel.CENTER);
        labImage.setVerticalAlignment(JLabel.CENTER);
        iconExo = new ImageIcon(getClass().getResource("IconEleve.png"));
        labImage.setIcon(iconExo);
        butFaireExo = new JButton();
        butFaireExo.add(labImage);
        panImage.add(butFaireExo, BorderLayout.CENTER);
        
        
        
        /** regroupement gauche/droite */
        
        JPanel panelExercice = new JPanel(new BorderLayout());
        panelExercice.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panelExercice.add(panGauche, BorderLayout.CENTER);
        panelExercice.add(panImage, BorderLayout.EAST);
        
        
        /** AFFICHAGE DES TENTATIVES - PARTIE BASSE */
        
        /** Partie gauche : */
               
        JPanel panNomTent = new JPanel();
        labNumTent = new JLabel("Tentative 3");
        panNomTent.add(labNumTent);
        
        JPanel panComTent = new JPanel(new BorderLayout());
        labCommTent = new JTextArea("Note : Non Aquis - Exercice complètement loupé !");
        labCommTent.setLineWrap(true);
        labCommTent.setWrapStyleWord(true);
        panComTent.add(labCommTent,BorderLayout.CENTER);
        
        /** Boutons **/
        JPanel ssPanButPrecT = new JPanel();
        butPrecTent = new JButton("Précédent");
        ssPanButPrecT.add(butPrecTent);
        JPanel panButPrecT = new JPanel();
        panButPrecT.add(ssPanButPrecT);
        
        JPanel ssPanButSuivT = new JPanel();
        butSuivTent = new JButton("Suivant");
        ssPanButSuivT.add(butSuivTent);
        JPanel panButSuivT = new JPanel();
        panButSuivT.add(ssPanButSuivT);
        
        JPanel panButtonT = new JPanel(new GridLayout(1,2));
        panButtonT.add(panButPrecT);
        panButtonT.add(panButSuivT);
        
        
        /** regroupement gauche */
        
        JPanel panGaucheT = new JPanel(new GridLayout(3,1));
        panGaucheT.add(panNomTent);
        panGaucheT.add(panButtonT);
        panGaucheT.add(panComTent);
        
        /** Tenetaive : Partie droite : */
        
        JPanel panImageT = new JPanel(new BorderLayout());
        panImageT.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panImageT.setPreferredSize(new Dimension(300,300));
        JLabel labImageT = new JLabel();
        labImageT.setHorizontalAlignment(JLabel.CENTER);
        labImageT.setVerticalAlignment(JLabel.CENTER);
        iconTent = new ImageIcon(getClass().getResource("IconEleve.png"));
        labImageT.setIcon(iconTent);
        panImageT.add(labImageT, BorderLayout.CENTER);
        
         /** Tentative : regroupement gauche/droite */
        
        JPanel panelTentative = new JPanel(new BorderLayout());
        panelTentative.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panelTentative.add(panGaucheT, BorderLayout.CENTER);
        panelTentative.add(panImageT, BorderLayout.EAST);
        
        
        
        /** REGROUPEMENT EXERCICE ET TENTATIVE - PARTIE CENTRALE */
        
        JPanel panelDessin = new JPanel(new GridLayout(2,1));
        panelDessin.add(panelExercice);
        panelDessin.add(panelTentative);
        
        
        /** REGROUPEMENT PARTIE CENTRALE ET TITRE (PANEL FINAL)*/
        
        this.setLayout(new BorderLayout());
        this.add(panelTitre, BorderLayout.NORTH);
        this.add(panelDessin, BorderLayout.CENTER);
        
        controleur = new CtrlMenuEleve(this,appli);
        butFaireExo.addActionListener(controleur);
                
                
        appli.getMainFrame().setContentPane(this);
        appli.getMainFrame().repaint();
        appli.getMainFrame().revalidate();
    }
    
    public JButton getButFaireExo(){
        return butFaireExo;
    }
}
