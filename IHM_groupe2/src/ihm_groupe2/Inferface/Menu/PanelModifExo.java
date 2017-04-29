package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlModifExo;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

/**
 * Classe PanelModifExo
 * Panel qui contient le formulaire pour pouvoir modifier un exercice
 * Il y aura plusieurs champs : Nom exercice, Tortue choisi, Commentaire exercice, modifier Image exercice
 * Les champs seront préremplis avec les information de l'exercice selectionné
 * Il y aura un bouton de validation du formulaire qui renverra vers le controleur de validation du formulaire d'exercices
 * S'il n'y a aucune modification alors l'utilisateur sera simplement renvoyé vers la page de la liste des exercices
 * Sinon il y aura un controle des champs via le controleur "ControlFormExo"
 * @author Paul
 */
public class PanelModifExo extends JPanel{
    
    private ApplicationProf appli;
    private JButton butValidForm;           // Permet d'enregistrer un nouvel exercice
    private CtrlModifExo controleur;   
    private JTextField textFieldNomExo;     // Permet de renseigner le nom de l'exercice
    private JTextField textFieldCommExo;    // Permet de renseigner le commentaire de l'exercice
    private ButtonGroup groupe;
    private JRadioButton butRadTortueNorm;
    private JRadioButton butRadTortueRap;
    private JRadioButton butRadTortueCoul;
    private JButton butAddImage;
    private ImageIcon imageExo; // Permet de charger l'image de l'exercice
    private JLabel affImageExo;
    private Exercice lExo;
    
    public PanelModifExo(Exercice exerciceModifie, ApplicationProf lAppli){
        appli = lAppli;
        lExo = exerciceModifie;
        JLabel textEntete = new JLabel(new ImageIcon(getClass().getResource("/Images/ModifExo.png")));
        textEntete.setPreferredSize(new Dimension(250,51));
        
        JPanel panel0 = new JPanel(new BorderLayout());
        panel0.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panel0.add(textEntete,BorderLayout.CENTER);
        panel0.setBackground(Color.white);
        
        JLabel textChampsNomExo = new JLabel("Saisir le nom de l'exercice :");
        textChampsNomExo.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        textChampsNomExo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textFieldNomExo = new JTextField(20);
        textFieldNomExo.setText(lExo.getNom());
        
        JPanel panel1 = new JPanel();
        panel1.add(textChampsNomExo);
        panel1.add(textFieldNomExo);
        
        
        JLabel textChampsCommExo = new JLabel("Saisir un commentaire pour cet exercice :");
        textChampsCommExo.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        textChampsCommExo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textFieldCommExo = new JTextField(50);
        textFieldCommExo.setText(lExo.getCommentaire());
        
        JPanel panel2 = new JPanel();
        panel2.add(textChampsCommExo);
        panel2.add(textFieldCommExo);
        
        
        JLabel textChoixTortue = new JLabel("Choissisez votre tortue :");
        textChoixTortue.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        textChoixTortue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        groupe =  new ButtonGroup();
        if (lExo.getMaTortue().getClass().equals(TortueRapide.class)){
            butRadTortueNorm = new JRadioButton("Tortue Normale");
            butRadTortueRap = new JRadioButton("Tortue Rapide",true);
            butRadTortueCoul = new JRadioButton("Tortue Couleur");
        }else if(lExo.getMaTortue().getClass().equals(TortueCouleur.class)){
            butRadTortueNorm = new JRadioButton("Tortue Normale");
            butRadTortueRap = new JRadioButton("Tortue Rapide");
            butRadTortueCoul = new JRadioButton("Tortue Couleur",true);
        }else{
            butRadTortueNorm = new JRadioButton("Tortue Normale",true);
            butRadTortueRap = new JRadioButton("Tortue Rapide");
            butRadTortueCoul = new JRadioButton("Tortue Couleur");
        }
        butRadTortueNorm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butRadTortueNorm.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        butRadTortueRap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butRadTortueRap.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        butRadTortueCoul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butRadTortueCoul.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        
    // ajout des boutons radio dans le groupe bg
        groupe.add(butRadTortueNorm);
        groupe.add(butRadTortueRap);
        groupe.add(butRadTortueCoul);
        
        JPanel panel3 = new JPanel(new GridLayout(2,3));
        panel3.add(butRadTortueNorm);
        panel3.add(butRadTortueRap);
        panel3.add(butRadTortueCoul);
        panel3.add(new JLabel(new ImageIcon(getClass().getResource("/Images/TortueSimple.png"))));
        panel3.add(new JLabel(new ImageIcon(getClass().getResource("/Images/TortueRapide.png"))));
        panel3.add(new JLabel(new ImageIcon(getClass().getResource("/Images/TortueCouleur.png"))));
        
        
        imageExo = new ImageIcon((lExo.getImage()).getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT));
        JLabel textAffImage = new JLabel("Aperçu de votre image :   ");
        textAffImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textAffImage.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        affImageExo = new JLabel();
        affImageExo.setIcon(imageExo);

        JPanel panel4 = new JPanel();
        panel4.add(textAffImage);
        panel4.add(affImageExo);
        
        
        butAddImage = new JButton(new ImageIcon(getClass().getResource("/Images/Recherche.png")));
        butAddImage.setPreferredSize(new Dimension(222,50));
        controleur = new CtrlModifExo(this,appli);
        butAddImage.addActionListener(controleur);

        
        JPanel panel5 = new JPanel();
        butValidForm = new JButton(new ImageIcon(getClass().getResource("/Images/Valider.png")));
        butValidForm.setPreferredSize(new Dimension(222,50));
        butValidForm.addActionListener(controleur);
        panel5.add(butAddImage);
        panel5.add(butValidForm);
        
        JPanel globalPan1 = new JPanel(new BorderLayout());
        globalPan1.add(panel1, BorderLayout.NORTH);
        globalPan1.add(panel2, BorderLayout.CENTER);
        globalPan1.add(panel3, BorderLayout.SOUTH);
        
        JPanel globalPan = new JPanel(new BorderLayout());
        globalPan.add(globalPan1,BorderLayout.NORTH);
        globalPan.add(panel4,BorderLayout.CENTER);
        this.setLayout(new BorderLayout());
        this.add(panel0,BorderLayout.NORTH);
        this.add(globalPan,BorderLayout.CENTER);
        this.add(panel5,BorderLayout.SOUTH);
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        
        
    }
    
    public Exercice getExoModif(){
        return lExo;
    }
    
    public JButton getButAddImage(){
        return butAddImage;
    }
    
    public JButton getButValidForm(){
        return butValidForm;
    }
    
    public ImageIcon getImageExo(){
        return imageExo;
    }
    
    public void setImageExo(ImageIcon newImage){
        imageExo=newImage;
        affImageExo.setIcon(new ImageIcon((newImage).getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT)));
    }
    
    public JLabel getLabAffImage(){
        return affImageExo;
    }
    
    public JTextField getTextNomExo(){
        return textFieldNomExo;
    }
    
    public JTextField getTextComExo(){
        return textFieldCommExo;
    }
    
    public JRadioButton getRadTortNorm(){
        return butRadTortueNorm;
    }
    
    public JRadioButton getRadTortRap(){
        return butRadTortueRap;
    }
    
    public JRadioButton getRadTortCoul(){
        return butRadTortueCoul; 
    }
}
