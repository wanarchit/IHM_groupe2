package ihm_groupe2.Inferface.Menu;
import Applications.ApplicationEleve;
import ihm_groupe2.Controleur.CtrlDessinEleve;
import ihm_groupe2.Noyau_fonctionnel.Canvas;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueG;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

/**
 * Classe Dessin
 * Permet de gérer la réalisation d'exercices via des dessins
 * Modulable en fonction de l'exercice
 * @author Groupe 2
 */
public class Dessin extends JPanel{
    
    private ApplicationEleve appli;
    private Exercice exoEnCours;
    
    private JButton butValider;
    private JButton butRetour;
    private JButton butAnnuler;
    private JButton butEcrire;
    private JButton butAvancer;
    private JButton butTourner;
    
    private JButton butPlusVite;
    private JButton butMoinsVite;
    
    private JButton butCoulNoir;
    private JButton butCoulRouge;
    private JButton butCoulVert;
    private JButton butCoulRose;
    private JButton butCoulBleu;
    private JButton butCoulJaune;
    private CtrlDessinEleve controleur;
    
    private Realisation laRealisation;
    
    private JLabel labelAction;
    
    
    /**
     * Constructeur de la classe Dessin
     * @param lAppli : Application en cours
     * @param exo : Exercice concerné par la réalisation en cours
     */
    public Dessin(ApplicationEleve lAppli, Exercice exo){
        appli=lAppli;
        exoEnCours = exo;
        exoEnCours.getMaTortue().reset();
        if (exoEnCours.getMaTortue().getClass() == TortueCouleur.class){
            ((TortueCouleur)exoEnCours.getMaTortue()).setCouleur("black");
        }else if(exoEnCours.getMaTortue().getClass() == TortueRapide.class){
            ((TortueRapide)exoEnCours.getMaTortue()).setVitesse(1);
        }
        
        laRealisation = new Realisation(appli.getNumTentativeSuiv(exoEnCours),"","",exoEnCours);
        
        
        /** ssPanel du haut :  bouton terminer (valider),
          bouton retour, bouton anuler action */
        
        JPanel ssPanelHaut = new JPanel(new GridLayout(1,3));
        ssPanelHaut.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        butValider = new JButton(new ImageIcon(getClass().getResource("/Images/valider_1.png")));
        butValider.setBackground(Color.white);
        butValider.setPreferredSize(new Dimension(200,75));
        butRetour = new JButton(new ImageIcon(getClass().getResource("/Images/but_quitter.png")));
        butRetour.setBackground(Color.white);
        butRetour.setPreferredSize(new Dimension(200,75));
        butAnnuler = new JButton(new ImageIcon(getClass().getResource("/Images/annuler.png")));
        butAnnuler.setBackground(Color.white);
        butAnnuler.setPreferredSize(new Dimension(200,75));
        ssPanelHaut.add(butValider);
        ssPanelHaut.add(butRetour);
        ssPanelHaut.add(butAnnuler);
        
        
        /** ssPanel Milieu : canvas */
        JPanel ssPanelMilieu = new JPanel();
        ssPanelMilieu.add (Canvas.getCanvasPanel(), BorderLayout.CENTER);
        ssPanelMilieu.setBackground(Color.white);

        
        /** ssPanel bas : boutons actions : écrire / avancer / tourner */
        JPanel ssPanelBas = new JPanel(new GridLayout(1,3));
        ssPanelBas.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));       
        butEcrire = new JButton(new ImageIcon(getClass().getResource("/Images/ecrit_pas.png")));
        butEcrire.setBackground(Color.white);
        butEcrire.setPreferredSize(new Dimension(200,75));
        butAvancer = new JButton(new ImageIcon(getClass().getResource("/Images/avancer.png")));
        butAvancer.setBackground(Color.white);
        butAvancer.setPreferredSize(new Dimension(200,75));
        butTourner = new JButton(new ImageIcon(getClass().getResource("/Images/tourne.png")));
        butTourner.setBackground(Color.white);
        butTourner.setPreferredSize(new Dimension(200,75));
        controleur = new CtrlDessinEleve(appli,this);
        
        ssPanelBas.add(butEcrire);
        ssPanelBas.add(butAvancer);
        ssPanelBas.add(butTourner);
        

        butAvancer.addActionListener(controleur);
        butTourner.addActionListener(controleur);
        butEcrire.addActionListener(controleur);
        
        if (exoEnCours.getTortueChoisie() == 0){
            // Tortue classique
            
            
        }else if (exoEnCours.getTortueChoisie() == 1){
            // Tortue couleur
            butCoulNoir = new JButton();
            butCoulNoir.setBackground(Color.black);
            butCoulRouge = new JButton();
            butCoulRouge.setBackground(Color.red);
            butCoulVert = new JButton();
            butCoulVert.setBackground(Color.green);
            butCoulRose = new JButton();
            butCoulRose.setBackground(Color.magenta);
            butCoulBleu = new JButton();
            butCoulBleu.setBackground(Color.blue);
            butCoulJaune = new JButton();
            butCoulJaune.setBackground(Color.yellow);
            
            butCoulNoir.addActionListener(controleur);
            butCoulRouge.addActionListener(controleur);
            butCoulVert.addActionListener(controleur);
            butCoulRose.addActionListener(controleur);
            butCoulBleu.addActionListener(controleur);
            butCoulJaune.addActionListener(controleur);
            
            JPanel panelActionCouleur = new JPanel(new GridLayout(2,3));
            panelActionCouleur.add(butCoulNoir);
            panelActionCouleur.add(butCoulRouge);
            panelActionCouleur.add(butCoulVert);
            panelActionCouleur.add(butCoulRose);
            panelActionCouleur.add(butCoulBleu);
            panelActionCouleur.add(butCoulJaune);
            
            ssPanelBas.setLayout(new GridLayout(1,4));
            ssPanelBas.add(panelActionCouleur);
            
        }else{
            // Tortue rapide
            butPlusVite = new JButton(new ImageIcon(getClass().getResource("/Images/rapide.png")));
            butPlusVite.setPreferredSize(new Dimension(200,35));
            butPlusVite.setBackground(Color.white);
            butMoinsVite = new JButton(new ImageIcon(getClass().getResource("/Images/lent.png")));
            butMoinsVite.setPreferredSize(new Dimension(200,35));
            butMoinsVite.setBackground(Color.white);
            butPlusVite.addActionListener(controleur);
            butMoinsVite.addActionListener(controleur);
            
            JPanel panelActionRapide = new JPanel(new GridLayout(2,1));
            panelActionRapide.add(butPlusVite);
            panelActionRapide.add(butMoinsVite);
            
            ssPanelBas.setLayout(new GridLayout(1,4));
            ssPanelBas.add(panelActionRapide);
        }
        
  
        /** ssPanel gauche : liste actions */
        JPanel ssPanelGauche = new JPanel(new BorderLayout());
        ssPanelGauche.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel labelJai = new JLabel("Ma tortue ...                   ");
        labelJai.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,18));
        
        String lesCmd = "";
        
        
        
        labelAction = new JLabel(lesCmd);
        
        JScrollPane scrollF = new JScrollPane(labelAction,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
	    	       JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        ssPanelGauche.add(labelJai, BorderLayout.NORTH);
        ssPanelGauche.add(scrollF, BorderLayout.CENTER);
        
       
        /** ssPanel Centre : ssPanel Milieu / ssPanel haut / ssPanel bas */
        JPanel ssPanelCentre = new JPanel(new BorderLayout());
        ssPanelCentre.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        ssPanelCentre.add(ssPanelHaut, BorderLayout.NORTH);
        ssPanelCentre.add(ssPanelMilieu, BorderLayout.CENTER);
        ssPanelCentre.add(ssPanelBas, BorderLayout.SOUTH);
        
        
        /** ssPanel droite : info exo + model */
        JPanel ssPanelDroite = new JPanel(new BorderLayout());
        ssPanelDroite.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel labTypeTortue = new JLabel();
        labTypeTortue.setHorizontalAlignment(JLabel.CENTER);
        labTypeTortue.setVerticalAlignment(JLabel.CENTER);
        
        if (exoEnCours.getTortueChoisie() == 0){
            labTypeTortue.setText("Tortue Classique");
        }else if (exoEnCours.getTortueChoisie() == 1){
            labTypeTortue.setText("Tortue Couleur");
        }else{
            labTypeTortue.setText("Tortue Rapide");
        }
        labTypeTortue.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,24));
        JLabel labNomExo = new JLabel(exoEnCours.getNom());
        labNomExo.setHorizontalAlignment(JLabel.CENTER);
        labNomExo.setVerticalAlignment(JLabel.CENTER);
        labNomExo.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,22));
        JLabel lab13 = new JLabel("Nouvelle tentative");
        lab13.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,18));
        lab13.setHorizontalAlignment(JLabel.CENTER);
        lab13.setVerticalAlignment(JLabel.CENTER);
        
        JPanel ssPanelDroite2 = new JPanel(new GridLayout(3,1));
        ssPanelDroite2.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        ssPanelDroite2.add(labTypeTortue);
        ssPanelDroite2.add(labNomExo);
        ssPanelDroite2.add(lab13);
        
        JPanel ssPanMonModel = new JPanel(new BorderLayout());
        JLabel labMonModel = new JLabel("Mon modèle :");
        labMonModel.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,18));
        labMonModel.setHorizontalAlignment(JLabel.CENTER);

        JPanel panImage = new JPanel(new BorderLayout());
        JLabel labImageExo = new JLabel();
        labImageExo.setHorizontalAlignment(JLabel.CENTER);
        labImageExo.setVerticalAlignment(JLabel.CENTER);
        ImageIcon iconExo = new ImageIcon((exoEnCours.getImage()).getImage().getScaledInstance(400,400, Image.SCALE_DEFAULT));
        labImageExo.setIcon(iconExo);
        panImage.add(labImageExo, BorderLayout.CENTER);
        
        ssPanMonModel.add(labMonModel, BorderLayout.CENTER);
        ssPanMonModel.add(panImage, BorderLayout.SOUTH);
        ssPanelDroite.setPreferredSize(new Dimension(400,800));
        ssPanelDroite.add(ssPanelDroite2,BorderLayout.NORTH);
        ssPanelDroite.add(ssPanMonModel,BorderLayout.CENTER);
        

        
        
        butRetour.addActionListener(controleur);
        butAnnuler.addActionListener(controleur);
        butValider.addActionListener(controleur);
        
        
        
        
        
        
        
        
       
            
            
        
        this.setLayout(new BorderLayout());
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        this.add(ssPanelGauche, BorderLayout.WEST);
        this.add(ssPanelCentre, BorderLayout.CENTER);
        this.add(ssPanelDroite, BorderLayout.EAST);
        
        
    }
    /**
     * Méthode getButValidation
     * Permet de renvoyer le bouton de Validation du dessin
     * @return butValider: JButton
     */
    public JButton getButValidation(){
        return butValider;
    }
    /**
     * Méthode getButRetour
     * Permet de renvoyer le bouton de retour
     * @return butRetour: JButton
     */
    public JButton getButRetour(){
        return butRetour;
    }
    /**
     * Méthode getButAnnuler
     * Permet de renvoyer le bouton de annuler
     * @return butAnnuler: JButton
     */
    public JButton getButAnnuler(){
        return butAnnuler;
    }
    /**
     * Méthode getButEcrire
     * Permet de renvoyer le bouton de écrir
     * @return butEcrire: JButton
     */
    public JButton getButEcrire(){
        return butEcrire;
    }
    /**
     * Méthode getButAvancer
     * Permet de renvoyer le bouton de Avancer
     * @return butAvancer: JButton
     */
    public JButton getButAvancer(){
        return butAvancer;
    }
    /**
     * Méthode getButTourner
     * Permet de renvoyer le bouton de tourner
     * @return butTourner: JButton
     */
    public JButton getButTourner(){
        return butTourner;
    }
    /**
     * Méthode getButMoinsVite
     * Permet de renvoyer le bouton de moins vite
     * @return butMoinsVite: JButton
     */
    public JButton getButMoinsVite(){
        return butMoinsVite;
    }
    /**
     * Méthode getButPlusVite
     * Permet de renvoyer le bouton de plus vite
     * @return butPlusVite: JButton
     */
    public JButton getButPlusVite(){
        return butPlusVite;
    }
    /**
     * Méthode getButNoir
     * Permet de renvoyer le bouton de couleur noir
     * @return butCoulNoir: JButton
     */
    public JButton getButNoir(){
        return butCoulNoir;
    }
    /**
     * Méthode getButRouge
     * Permet de renvoyer le bouton de couleur rouge
     * @return butCoulRouge: JButton
     */
    public JButton getButRouge(){
        return butCoulRouge;
    }
    /**
     * Méthode getButVert
     * Permet de renvoyer le bouton de couleur vert
     * @return butCoulVert: JButton
     */
    public JButton getButVert(){
        return butCoulVert;
    }
    /**
     * Méthode getButRose
     * Permet de renvoyer le bouton de couleur rose
     * @return butCoulRose: JButton
     */
    public JButton getButRose(){
        return butCoulRose;
    }
    /**
     * Méthode getButBleu
     * Permet de renvoyer le bouton de couleur bleu
     * @return butCoulBleu: JButton
     */
    public JButton getButBleu(){
        return butCoulBleu;
    }
    /**
     * Méthode getButJaune
     * Permet de renvoyer le bouton de couleur jaune
     * @return butCoulJaune: JButton
     */
    public JButton getButJaune(){
        return butCoulJaune;
    }
    
    /**
     * Méthode getExoEnCours
     * Renvoie l'exercice en cours
     * @return exoEnCours: Exercice
     */
    public Exercice getExoEnCours(){
        return exoEnCours;
    }
    /**
     * Méthode getLaTortue
     * Renvoie la tortue de la réalisation en cours
     * @return exoEnCours.getMaTortue() : TortueG
     */
    public TortueG getLaTortue(){
        return exoEnCours.getMaTortue();
    }
    /**
     * Méthode getNewRealisation
     * Renvoie la réalisation faites
     * @return laRealisation: Realisation
     */
    public Realisation getNewRealisation(){
        return laRealisation;
    }
    /**
     * Méthode RefreshListAction
     * Permet de rafraîchir la liste d'action afficher pendant le dessin
     */
    public void RefreshListAction(){
        String lesCmd = "<html>";
        ArrayList<Commande> lesCommandes = laRealisation.getListeCommande();
        int tailleListe = lesCommandes.size();
        for (int i = tailleListe-1; i >= 0 ; i--){
            lesCmd += lesCommandes.get(i).getCommande() + "<br>";
        }
        lesCmd+="</html>";
        labelAction.setText(lesCmd);
        labelAction.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,18));
    }

}

