package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.PanelCreerExo;
import ihm_groupe2.Noyau_fonctionnel.FiltreSimple;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * Classe CtrlFormExo
 Permet de controler les actions faites dans le formulaire de création ou de modification d'exercice
 Verifie s'il y a une modification ou non.
 * Si tous les champs sont bons et que l'exercice est créer, l'utilisateur est redirigé vers la liste des exercices (JTable)
 * @author Paul
 */
public class CtrlFormExo implements ActionListener{
    
    private PanelCreerExo panelFormExo;
    
    public CtrlFormExo(PanelCreerExo lePanel){
        panelFormExo = lePanel;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelFormExo.getButAddImage()){
            // Permet de chercher un fichier à partir du Bureau
            FileSystemView vueSysteme = FileSystemView.getFileSystemView(); 
            File home = vueSysteme.getHomeDirectory();
            JFileChooser homeChooser = new JFileChooser(home);

            // Permet de filtrer les choix possibles de fichiers (que les images)
            FileFilter png = new FiltreSimple("Fichiers PNG",".png"); 
            FileFilter jpeg = new FiltreSimple("Fichiers JPEG",".jpeg"); 
            FileFilter jpg = new FiltreSimple("Fichiers JPG",".jpg");   
            FileFilter gif = new FiltreSimple("Fichiers GIF",".gif");
            FileFilter tiff = new FiltreSimple("Fichiers TIFF",".tiff");
            FileFilter tif = new FiltreSimple("Fichiers TIF",".tif");
            homeChooser.setAcceptAllFileFilterUsed(false);
            homeChooser.addChoosableFileFilter(png); 
            homeChooser.addChoosableFileFilter(jpeg); 
            homeChooser.addChoosableFileFilter(jpg);
            homeChooser.addChoosableFileFilter(gif);
            homeChooser.addChoosableFileFilter(tiff);
            homeChooser.addChoosableFileFilter(tif);

            // On récupère l'image
            int retour=homeChooser.showOpenDialog(null);
            if (retour == JFileChooser.APPROVE_OPTION)
            {
                File monFichier = homeChooser.getSelectedFile();
                BufferedImage image;
                try {
                    image = ImageIO.read(monFichier);
                    panelFormExo.setImageExo(new ImageIcon(image));
                    panelFormExo.getLabAffImage().setIcon(new ImageIcon(image));
                } catch (IOException ex) {
                    Logger.getLogger(CtrlFormExo.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            
        } else if (e.getSource() == panelFormExo.getButValidForm()){
            // Validation des informations 
            // Ajout dans la base de donnée du nouvelle exercice
            // Redirection de l'utilisateur vers le panel "ListeExercice"
        }
    }
}
