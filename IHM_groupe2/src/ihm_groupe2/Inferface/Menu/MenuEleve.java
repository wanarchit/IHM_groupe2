package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationEleve;
import ihm_groupe2.Controleur.CtrlMenuEleve;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
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
    private JLabel labImage;
    private ImageIcon iconTent; // image de la tentative selectionnée de l'elève
    private JButton butFaireExo;
    private CtrlMenuEleve controleur;
    private Exercice exoEnCours;
    private Realisation tentEnCours;
    private String textNote,textComm;
    private int numTent;
    private JButton rejouerTentative;
    
    private ArrayList<Exercice> lesExos;
    private ArrayList<Realisation> lesTents;
    
    /**
     * Constructeur de la classe MenuEleve
     * Permet de créer le menu pour un eleve
     * @param eleve : concerné par le menu (ses dessins)
     * @param lAppli
     * @param exo 
     */
    public MenuEleve(Eleve eleve,ApplicationEleve lAppli, Exercice exo, int num){
        eleveConnecte = eleve;
        appli = lAppli;
        exoEnCours = exo;
        numTent = num;
        lesTents = appli.getTentativeExo(exoEnCours);
        if (lesTents.size() != 0){
            tentEnCours = lesTents.get(numTent);
        }
        
        /** PANEL TITRE AU NORD*/
        
        JPanel panelTitre = new JPanel();
        panelTitre.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel texteTitre = new JLabel("Bonjour "+ eleveConnecte.getPrenomPersonne() + " "+  eleveConnecte.getNomPersonne());
        panelTitre.add(texteTitre);
        
        
        /** AFFICHAGE DES EXERCICES - PARTIE HAUTE */
        
        /** Partie gauche : */
               
        JPanel panNomExo = new JPanel();
        labNomExo = new JLabel(exoEnCours.getNom());
        panNomExo.add(labNomExo);
        
        JPanel panComExo = new JPanel(new BorderLayout());
        labCommExo = new JTextArea(exoEnCours.getCommentaire());
        labCommExo.setLineWrap(true);
        labCommExo.setWrapStyleWord(true);
        labCommExo.getCaret().deinstall(labCommExo);
        panComExo.add(labCommExo,BorderLayout.CENTER);
        
        
        /** Boutons **/
        JPanel ssPanButPrec = new JPanel();
        butPrecExo = new JButton("Précédent");
        if (appli.exercicePrecExist(exoEnCours)){
            butPrecExo.setEnabled(true);
        }else{
            butPrecExo.setEnabled(false);
        }
        ssPanButPrec.add(butPrecExo);
        JPanel panButPrec = new JPanel();
        panButPrec.add(ssPanButPrec);
        
        JPanel ssPanButSuiv = new JPanel();
        butSuivExo = new JButton("Suivant");
        if (appli.exerciceSuivExist(exoEnCours)){
            butSuivExo.setEnabled(true);
        }else{
            butSuivExo.setEnabled(false);
        }
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
        labImage = new JLabel();
        labImage.setHorizontalAlignment(JLabel.CENTER);
        labImage.setVerticalAlignment(JLabel.CENTER);
        iconExo = exoEnCours.getImage();
        iconExo = new ImageIcon((exoEnCours.getImage()).getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT));
        labImage.setIcon(iconExo);
        butFaireExo = new JButton();
        butFaireExo.setPreferredSize(new Dimension(300,300));
        butFaireExo.setMinimumSize(new Dimension(300,300));
        butFaireExo.setBorderPainted(false);
        butFaireExo.add(labImage);
        panImage.add(butFaireExo, BorderLayout.CENTER);
        
        
        
        /** regroupement gauche/droite */
        
        JPanel panelExercice = new JPanel(new BorderLayout());
        panelExercice.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panelExercice.add(panGauche, BorderLayout.CENTER);
        panelExercice.add(panImage, BorderLayout.EAST);
        
        
        /** AFFICHAGE DES TENTATIVES - PARTIE BASSE */
        
        /** Partie gauche : */
        
        
        
        
        
        
        if (lesTents.size() != 0){
            labNumTent = new JLabel("Tentative n°"+tentEnCours.getNumeroTentative());
            if (tentEnCours.getNote().equals("")){
                textNote = "Non évalué";
            }else{
                textNote = tentEnCours.getNote();
            }
            
            if (tentEnCours.getCommentaire().equals("")){
                textComm = "Pas de commentaires pour la tentative "+tentEnCours.getNumeroTentative();
            }else{
                textComm = "\""+tentEnCours.getCommentaire()+"\"";
            }

            labCommTent = new JTextArea("Note : "+textNote+"    --    Commentaire de l'enseignant : "+textComm);
            
            
            
            iconTent = new ImageIcon(getClass().getResource("IconContent.jpg"));
            
        }else{
            labNumTent = new JLabel("Pas de tentative pour cet exercice");
            labCommTent = new JTextArea("Exercice a réaliser");
            iconTent = new ImageIcon(getClass().getResource("IconTriste.jpg"));
        }
        
        
        
        JPanel panNomTent = new JPanel();
        panNomTent.add(labNumTent);
        
        JPanel panComTent = new JPanel(new BorderLayout());
        labCommTent.setLineWrap(true);
        labCommTent.setWrapStyleWord(true);
        labCommTent.getCaret().deinstall(labCommTent);
        panComTent.add(labCommTent,BorderLayout.CENTER);
        
        /** Boutons **/
        JPanel ssPanButPrecT = new JPanel();
        butPrecTent = new JButton("Précédent");
        ssPanButPrecT.add(butPrecTent);
        if (lesTents.size() != 0){
            if (appli.tentativePrecExist(exoEnCours,tentEnCours)){
                butPrecTent.setEnabled(true);
            }else{
                butPrecTent.setEnabled(false);
            }
        }else{
            butPrecTent.setEnabled(false);
        }
        JPanel panButPrecT = new JPanel();
        panButPrecT.add(ssPanButPrecT);
        
        JPanel ssPanButSuivT = new JPanel();
        butSuivTent = new JButton("Suivant");
        ssPanButSuivT.add(butSuivTent);
        if (lesTents.size() != 0){
            if (appli.tentativeSuivExist(exoEnCours,tentEnCours)){
            butSuivTent.setEnabled(true);
            }else{
                butSuivTent.setEnabled(false);
            }
        }else{
            butSuivTent.setEnabled(false);
        }
        
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
        
        labImageT.setIcon(iconTent);
        rejouerTentative = new JButton();
        rejouerTentative.setIcon(iconTent);
        
        if (lesTents.size() != 0){
            rejouerTentative.setEnabled(true);
        }else{
            rejouerTentative.setEnabled(false);
        }
        
        panImageT.add(rejouerTentative, BorderLayout.CENTER);
        
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
        butPrecExo.addActionListener(controleur);
        butSuivExo.addActionListener(controleur);
        butPrecTent.addActionListener(controleur);
        butSuivTent.addActionListener(controleur);
        rejouerTentative.addActionListener(controleur);
                
                
    }
    
    public JButton getButFaireExo(){
        return butFaireExo;
    }
    
    public JButton getButExoSuiv(){
        return butSuivExo;
    }
    
    public JButton getButExoPrec(){
        return butPrecExo;
    }
    
    public JButton getButTentSuiv(){
        return butSuivTent;
    }
    
    public JButton getButTentPrec(){
        return butPrecTent;
    }
    
    public JButton getButRejouerTent(){
        return rejouerTentative;
    }
            
    public Exercice getExoEnCours(){
        return exoEnCours;
    }
    
    public Realisation getReaEnCours(){
        return tentEnCours;
    }
    
    
    
    
}
