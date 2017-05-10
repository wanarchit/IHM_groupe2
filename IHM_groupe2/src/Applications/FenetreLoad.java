package Applications;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe FenetreLoad : Permet d'afficher une fenêtre de chargement de la base de donnée
 * @author Groupe 2
 */
public class FenetreLoad extends JFrame{
    
    // Label du texte affiché dans la fenêtre
    private JLabel labelText;
    
    /**
     * Constructeur de FenetreLoad
     * @param monString : Nom du texte a afficher dans la fenêtre : soit chargement, soit mise a jour des données
     */
    public FenetreLoad(String monString){
        labelText = new JLabel(monString);
        labelText.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,20));
        labelText.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JPanel panelText = new JPanel();
        panelText.add(labelText);
        JPanel panelGlobal = new JPanel(new BorderLayout());
        panelGlobal.add(panelText,BorderLayout.CENTER);
        
        this.add(panelGlobal);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.setTitle("Chargement ...");
        this.setSize(500, 120);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    /**
     * Permet de fermer la fenêtre de chargement
     */
    public void closeFrameLoad(){
        this.dispose();
    }

}
