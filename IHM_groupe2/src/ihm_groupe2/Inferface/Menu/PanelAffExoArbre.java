package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Noyau_fonctionnel.Exercice;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 * Classe PanelAffExoArbre
 * Permet de gérer l'affichage de la création d'exercice
 * @author Groupe 2
 */
public class PanelAffExoArbre extends JPanel{
    
    private Exercice exercice;
    /**
     * Constructeur de la classe PanelAffExoArbre
     * @param lExo Exercice en cours
     */
    public PanelAffExoArbre(Exercice lExo){
        exercice = lExo;
        
        JLabel textEntete = new JLabel(new ImageIcon(getClass().getResource("/Images/VisualisationEleve.png")));
        textEntete.setPreferredSize(new Dimension(250,51));
        
        JPanel panel0 = new JPanel(new BorderLayout());
        panel0.add(textEntete,BorderLayout.CENTER);
        panel0.setBackground(Color.white); 
        
        //PARTIE NOM EXO
        JLabel labelNomExo1 = new JLabel("Nom exercice : ");
        labelNomExo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomExo1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));
        
        JLabel labelNomExo2 = new JLabel(exercice.getNom());
        labelNomExo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomExo2.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16));
        
        JPanel panelNom = new JPanel();
        panelNom.add(labelNomExo1);
        panelNom.add(labelNomExo2);
        
        // PARTIE COMMENTAIRE EXO
        JLabel labelComExo1 = new JLabel("Commentaire exercice : ");
        labelComExo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComExo1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));
        
        JLabel labelComExo2 = new JLabel(exercice.getCommentaire());
        labelComExo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelComExo2.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16));
        
        JPanel panelComm = new JPanel();
        panelComm.add(labelComExo1);
        panelComm.add(labelComExo2);
        
        
        //TORTUE CHOISIE
        int tortueChoisie = exercice.getTortueChoisie();
        JLabel labelTortueExo1 = new JLabel();
        labelTortueExo1.setText("Tortue choisie : ");
        labelTortueExo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTortueExo1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));
        
        JLabel labelTortueExo2 = new JLabel();
        labelTortueExo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTortueExo2.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16));      
        
        if (tortueChoisie == 0){    // Tortue classique 
            labelTortueExo2.setText("Tortue classique");
        }else if (tortueChoisie == 1){  // Tortue couleur
            labelTortueExo2.setText("Tortue couleur");
        }else{  // Tortue Rapide
            labelTortueExo2.setText("Tortue rapide");
        }
        
        JPanel panelTortue = new JPanel();
        panelTortue.add(labelTortueExo1);
        panelTortue.add(labelTortueExo2);
        
        JPanel ssPanel1 = new JPanel(new GridLayout(3,1));
        ssPanel1.add(panelNom);
        ssPanel1.add(panelComm);
        ssPanel1.add(panelTortue);  
                
        
        ImageIcon imageExo = new ImageIcon((lExo.getImage()).getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT));
        JLabel textAffImage = new JLabel("Dessin à réaliser :   ");
        textAffImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textAffImage.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16)); 
        
        JLabel affImageExo = new JLabel();
        affImageExo.setIcon(imageExo);

        JPanel ssPanel2 = new JPanel(new GridLayout(1,2));
        ssPanel2.add(textAffImage);
        ssPanel2.add(affImageExo);
        
        this.setLayout(new BorderLayout());
        this.add(panel0,BorderLayout.NORTH);
        this.add(ssPanel1,BorderLayout.CENTER);
        this.add(ssPanel2,BorderLayout.SOUTH);
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        
        
    }
}
