package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlFormExo;
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
 * Classe PanelCreerExo
 * Panel qui contient le formulaire pour pouvoir créer un exercice
 * Il y aura plusieurs champs : Nom exercice, Tortue choisi, Commentaire exercice, ajouter Image exercice
 * Il y aura un boutton de validation du formulaire qui renverra vers le controleur de validation du formulaire d'exercices "ControlFormExo"
 * @author Groupe 2
 */
public class PanelCreerExo extends JPanel{
    
    private ApplicationProf appli;
    private JButton butValidForm;           // Permet d'enregistrer un nouvel exercice
    private CtrlFormExo controleur;
    // Ce boutton va utiliser un controleur qui va vérifier le contenu du fomrulaire et créer un nouvel exercice.
    
    private JTextField textFieldNomExo;     // Permet de renseigner le nom de l'exercice
    private JTextField textFieldCommExo;    // Permet de renseigner le commentaire de l'exercice
    private ButtonGroup groupe;
    private JRadioButton butRadTortueNorm;
    private JRadioButton butRadTortueRap;
    private JRadioButton butRadTortueCoul;
    private JButton butAddImage;
    private ImageIcon imageExo; // Permet de charger l'image de l'exercice
    private JLabel affImageExo;
    private JLabel textAffImage;
    
    public PanelCreerExo(ApplicationProf lAppli){
        appli = lAppli;
        JLabel textEntete = new JLabel(new ImageIcon(getClass().getResource("/Images/CreerExo.png")));
        textEntete.setPreferredSize(new Dimension(250,51));
        
        JPanel panel0 = new JPanel(new BorderLayout());
        panel0.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panel0.add(textEntete,BorderLayout.CENTER);
        panel0.setBackground(Color.white);
        
        JLabel textChampsNomExo = new JLabel("Saisir le nom de l'exercice :");
        textChampsNomExo.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        textChampsNomExo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textFieldNomExo = new JTextField(20);
        
        JPanel panel1 = new JPanel();
        panel1.add(textChampsNomExo);
        panel1.add(textFieldNomExo);
        
        
        JLabel textChampsCommExo = new JLabel("Saisir un commentaire pour cet exercice :");
        textChampsCommExo.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        textChampsCommExo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textFieldCommExo = new JTextField(50);
        
        JPanel panel2 = new JPanel();
        panel2.add(textChampsCommExo);
        panel2.add(textFieldCommExo);
        
        
        JLabel textChoixTortue = new JLabel("Choissisez votre tortue :");
        textChoixTortue.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        textChoixTortue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        
        groupe =  new ButtonGroup();
        butRadTortueNorm = new JRadioButton("Tortue Normale");
        butRadTortueNorm.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butRadTortueNorm.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        butRadTortueRap = new JRadioButton("Tortue Rapide");
        butRadTortueRap.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butRadTortueRap.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
        butRadTortueCoul = new JRadioButton("Tortue Couleur");
        butRadTortueCoul.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        butRadTortueCoul.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));
    // ajout des boutons radio dans le groupe bg
        groupe.add(butRadTortueNorm);
        groupe.add(butRadTortueRap);
        groupe.add(butRadTortueCoul);
        
        JPanel panel3 = new JPanel(new GridLayout(2,3));
        //panel3.add(textChoixTortue);
        panel3.add(butRadTortueNorm);
        panel3.add(butRadTortueRap);
        panel3.add(butRadTortueCoul);
        panel3.add(new JLabel(new ImageIcon(getClass().getResource("/Images/TortueSimple.png"))));
        panel3.add(new JLabel(new ImageIcon(getClass().getResource("/Images/TortueRapide.png"))));
        panel3.add(new JLabel(new ImageIcon(getClass().getResource("/Images/TortueCouleur.png"))));
        
       
        imageExo = new ImageIcon();
        textAffImage = new JLabel("<html>Choisisez votre image <br> Le temps de chargement de l'image est d'environ 8 secondes </html>");
        textAffImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textAffImage.setFont(new java.awt.Font(Font.DIALOG,Font.ITALIC,16));

        affImageExo = new JLabel();
        affImageExo.setIcon(imageExo);

        JPanel panel4 = new JPanel();
        panel4.add(textAffImage);
        panel4.add(affImageExo);
        
        butAddImage = new JButton(new ImageIcon(getClass().getResource("/Images/Recherche.png")));
        butAddImage.setPreferredSize(new Dimension(222,50));
        controleur = new CtrlFormExo(this,appli);
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
    
    public JLabel getLabApercuImg(){
        return textAffImage;
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
