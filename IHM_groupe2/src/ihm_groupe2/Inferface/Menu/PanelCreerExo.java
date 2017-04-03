package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlFormExo;
import java.awt.BorderLayout;
import java.awt.GridLayout;
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
 * @author Paul
 */
public class PanelCreerExo extends JPanel{
    
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
    
    public PanelCreerExo(){
        
        JLabel textEntete = new JLabel("CREATION D'UN EXERCICE : ");
        textEntete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        JPanel panel0 = new JPanel(new BorderLayout());
        panel0.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panel0.add(textEntete,BorderLayout.CENTER);
        
        JLabel textChampsNomExo = new JLabel("Entrer le nom de l'exercice :");
        textFieldNomExo = new JTextField(20);
        
        JPanel panel1 = new JPanel();
        panel1.add(textChampsNomExo);
        panel1.add(textFieldNomExo);
        
        
        JLabel textChampsCommExo = new JLabel("Entrer un commentaire pour cet exercice :");
        textFieldCommExo = new JTextField(20);
        
        JPanel panel2 = new JPanel();
        panel2.add(textChampsCommExo);
        panel2.add(textFieldCommExo);
        
        
        JLabel textChoixTortue = new JLabel("Choissisez votre tortue :");
        
        
        groupe =  new ButtonGroup();
        butRadTortueNorm = new JRadioButton("Tortue Normale");
        butRadTortueRap = new JRadioButton("Tortue Rapide");
        butRadTortueCoul = new JRadioButton("Tortue Couleur");
    // ajout des boutons radio dans le groupe bg
        groupe.add(butRadTortueNorm);
        groupe.add(butRadTortueRap);
        groupe.add(butRadTortueCoul);
        
        JPanel panel3 = new JPanel();
        panel3.add(textChoixTortue);
        panel3.add(butRadTortueNorm);
        panel3.add(butRadTortueRap);
        panel3.add(butRadTortueCoul);
        
        
        
        butAddImage = new JButton("Chercher une image");
        controleur = new CtrlFormExo(this);
        butAddImage.addActionListener(controleur);
               
        imageExo = new ImageIcon();
        JLabel textAffImage = new JLabel("Aperçu de votre image :   ");
        affImageExo = new JLabel();
        affImageExo.setIcon(imageExo);
        
        JPanel panel4 = new JPanel();
        panel4.add(butAddImage);
        panel4.add(textAffImage);
        panel4.add(affImageExo);
        
        
        JPanel panel5 = new JPanel();
        butValidForm = new JButton("Valider la création de l'exercice");
        butValidForm.addActionListener(controleur);
        panel5.add(butValidForm);
        
        this.setLayout(new GridLayout(6,1));
        this.add(panel0);
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.add(panel4);
        this.add(panel5);
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
        imageExo = newImage;
    }
    
    public JLabel getLabAffImage(){
        return affImageExo;
    }
}
