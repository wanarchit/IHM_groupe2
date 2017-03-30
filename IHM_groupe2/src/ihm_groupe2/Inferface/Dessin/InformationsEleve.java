package ihm_groupe2.Inferface.Dessin;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marin
 * Classe permettant l'affichage des informations lors de la réalisation d'un exercice
 */
public class InformationsEleve extends JPanel{  
    
    private JLabel labNomExo = new JLabel();
    private JLabel labNumTent = new JLabel();
    private ImageIcon imgExo= new ImageIcon();
    
    
    /**
     * Constructeur du JPanel InformationsEleve
     */
    public InformationsEleve(){
        
    }
    
    /**
     * Function getNomExo
     * @return labNomExo : Objet de type label
     */
    public JLabel getNomExo(){
        return labNomExo;
    }
    /**
     * Function getNumTent
     * @return labNumTent: Objet de type label
     */
    public JLabel getNumTent(){
        return labNumTent;
    }
    /**
     * Function getImgExo
     * @return imgExo: Objet de type ImageIcon
     */
    public ImageIcon getImgExo(){
        return imgExo;
    }
    
}
