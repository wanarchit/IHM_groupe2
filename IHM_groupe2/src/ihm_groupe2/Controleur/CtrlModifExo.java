package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.PanelModifExo;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
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
 *
 * @author Jonathan
 */
public class CtrlModifExo implements ActionListener {
    private ApplicationProf appli;
    private PanelModifExo panelFormExo;
    
    public CtrlModifExo(PanelModifExo lePanel, ApplicationProf lAppli){
        appli = lAppli;
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
                } catch (IOException ex) {
                    Logger.getLogger(CtrlFormExo.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            
        } else if (e.getSource() == panelFormExo.getButValidForm()){
            Boolean validation = true;
            int choixTortue = -1;
            String comExo = "";
            String nomExo = "";
            ImageIcon imageExo = null;
            if (!panelFormExo.getTextNomExo().getText().isEmpty()){
                nomExo = panelFormExo.getTextNomExo().getText();
                if (panelFormExo.getLabAffImage().getIcon().getIconHeight()!=-1){
                    imageExo = panelFormExo.getImageExo();                
                    if (!panelFormExo.getTextComExo().getText().isEmpty()){
                        comExo = panelFormExo.getTextComExo().getText();
                        if (panelFormExo.getRadTortNorm().isSelected()){
                            choixTortue=0;
                        }else if (panelFormExo.getRadTortRap().isSelected()){
                            choixTortue=2;
                        }else if (panelFormExo.getRadTortCoul().isSelected()){
                            choixTortue=1;
                        }else{
                            validation = false;
                            System.out.println("Vous devez choisir une tortue");
                        }
                    }else{
                        comExo = "Pas de commentaire";
                        if (panelFormExo.getRadTortNorm().isSelected()){
                            choixTortue=0;
                        }else if (panelFormExo.getRadTortRap().isSelected()){
                            choixTortue=2;
                        }else if (panelFormExo.getRadTortCoul().isSelected()){
                            choixTortue=1;
                        }else{
                            validation = false;
                            System.out.println("Vous devez choisir une tortue");
                        }
                    }
                }else{
                    validation = false;
                    System.out.println("Vous devez ajouter une image pour cet exercice");
                }
            }else{
                validation = false;
                System.out.println("Vous devez renseigner le nom de l'exercice");
            }
            if (validation){
                Exercice newExo = new Exercice(nomExo,comExo,choixTortue,imageExo);
                appli.getListeExo().remove(panelFormExo.getExoModif());
                appli.getListeExo().add(newExo);
                appli.afficheExercices();
            }
        }
    }
}
