package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlFormExo;
import ihm_groupe2.Controleur.CtrlModifExo;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueG;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
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
    
    private JButton butValidForm;           // Permet d'enregistrer un nouvel exercice
    private CtrlModifExo controleur;
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
    
    public PanelModifExo(Exercice e){
        
        JLabel textEntete = new JLabel("MODIFICATION D'UN EXERCICE : ");
        textEntete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        JPanel panel0 = new JPanel(new BorderLayout());
        panel0.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panel0.add(textEntete,BorderLayout.CENTER);
        
        JLabel textChampsNomExo = new JLabel("Entrer le nom de l'exercice :");
        textFieldNomExo = new JTextField(20);
        textFieldNomExo.setText(e.getNom());
        
        JPanel panel1 = new JPanel();
        panel1.add(textChampsNomExo);
        panel1.add(textFieldNomExo);
        
        
        JLabel textChampsCommExo = new JLabel("Entrer un commentaire pour cet exercice :");
        textFieldCommExo = new JTextField(20);
        textFieldCommExo.setText(e.getCommentaire());
        
        JPanel panel2 = new JPanel();
        panel2.add(textChampsCommExo);
        panel2.add(textFieldCommExo);
        
        
        JLabel textChoixTortue = new JLabel("Choissisez votre tortue :");
        
        
        groupe =  new ButtonGroup();
        if (e.getMaTortue().getClass().equals(TortueRapide.class)){
            butRadTortueNorm = new JRadioButton("Tortue Normale");
            butRadTortueRap = new JRadioButton("Tortue Rapide",true);
            butRadTortueCoul = new JRadioButton("Tortue Couleur");
        }else if(e.getMaTortue().getClass().equals(TortueCouleur.class)){
            butRadTortueNorm = new JRadioButton("Tortue Normale");
            butRadTortueRap = new JRadioButton("Tortue Rapide");
            butRadTortueCoul = new JRadioButton("Tortue Couleur",true);
        }else{
            butRadTortueNorm = new JRadioButton("Tortue Normale",true);
            butRadTortueRap = new JRadioButton("Tortue Rapide");
            butRadTortueCoul = new JRadioButton("Tortue Couleur");
        }
        
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
        controleur = new CtrlModifExo(this);
        butAddImage.addActionListener(controleur);
        
               
        imageExo = e.getImage();
        JLabel textAffImage = new JLabel("Aperçu de votre image :   ");
        affImageExo = new JLabel();
        affImageExo.setIcon(imageExo);
        
        JPanel panel4 = new JPanel();
        panel4.add(butAddImage);
        panel4.add(textAffImage);
        panel4.add(affImageExo);
        
        
        JPanel panel5 = new JPanel();
        butValidForm = new JButton("Valider la modification de l'exercice");
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
