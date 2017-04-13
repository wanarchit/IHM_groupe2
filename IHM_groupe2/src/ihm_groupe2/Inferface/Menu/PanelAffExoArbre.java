package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Noyau_fonctionnel.Exercice;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Paul
 */
public class PanelAffExoArbre extends JPanel{
    
    private Exercice exercice;
    
    public PanelAffExoArbre(Exercice lExo){
        exercice = lExo;
        
        JLabel labelNomExo = new JLabel("Nom exercice : "+exercice.getNom());
        labelNomExo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel labelComExo = new JLabel("Commentaire exercice : "+exercice.getCommentaire());
        labelComExo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        int tortueChoisie = exercice.getTortueChoisie();
        JLabel labelTortueExo = new JLabel();
        labelTortueExo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if (tortueChoisie == 0){    // Tortue classique 
            labelTortueExo.setText("Tortue choisie : Tortue classique");
        }else if (tortueChoisie == 1){  // Tortue couleur
            labelTortueExo.setText("Tortue choisie : Tortue couleur");
        }else{  // Tortue Rapide
            labelTortueExo.setText("Tortue choisie : Tortue rapide");
        }
        
        JPanel ssPanel1 = new JPanel(new GridLayout(3,1));
        ssPanel1.add(labelNomExo);
        ssPanel1.add(labelComExo);
        ssPanel1.add(labelTortueExo);
                
        
        ImageIcon imageExo = new ImageIcon((lExo.getImage()).getImage().getScaledInstance(300,300, Image.SCALE_DEFAULT));
        JLabel textAffImage = new JLabel("Dessin à réaliser :   ");
        textAffImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel affImageExo = new JLabel();
        affImageExo.setIcon(imageExo);

        JPanel ssPanel2 = new JPanel(new GridLayout(1,2));
        ssPanel2.add(textAffImage);
        ssPanel2.add(affImageExo);
        
        this.setLayout(new BorderLayout());
        this.add(ssPanel1,BorderLayout.NORTH);
        this.add(ssPanel2,BorderLayout.CENTER);
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        
        
    }
}
