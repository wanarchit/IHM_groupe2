package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.PanelCreerExo;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.FiltreSimple;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
    private ApplicationProf appli;
    
    public CtrlFormExo(PanelCreerExo lePanel, ApplicationProf lAppli){
        panelFormExo = lePanel;
        appli = lAppli;
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
                    //panelFormExo.getLabAffImage().setIcon(new ImageIcon(image));
                } catch (IOException ex) {
                    Logger.getLogger(CtrlFormExo.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            
        } else if (e.getSource() == panelFormExo.getButValidForm()){
            // Validation des informations


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
                            //Boîte du message d'information.
                            JOptionPane boiteDial = new JOptionPane();
                            boiteDial.showMessageDialog(null, "Vous devez choisir une tortue", "Création exercice", JOptionPane.INFORMATION_MESSAGE);
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
                            //Boîte du message d'information.
                            JOptionPane boiteDial = new JOptionPane();
                            boiteDial.showMessageDialog(null, "Vous devez choisir une tortue", "Création exercice", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }else{
                    validation = false;
                    //Boîte du message d'information.
                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "Vous devez ajouter une image à cet exercice", "Création exercice", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                validation = false;
                //Boîte du message d'information.
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "Vous devez renseigner le nom de l'exercice", "Création exercice", JOptionPane.INFORMATION_MESSAGE);
            }
            if (validation){
                Exercice newExo = new Exercice(nomExo,comExo,choixTortue,imageExo);
                appli.getListeExo().add(newExo);
                appli.afficheExercices();
            }
        }
    }
}