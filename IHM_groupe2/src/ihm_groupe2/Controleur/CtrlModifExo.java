package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.PanelModifExo;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.FiltreSimple;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileSystemView;

/**
 * Classe CtrlModifExo
 * Controleur permettant de gérer les actions liés au menu 
 * de modification d'un exercice
 * 
 * @author Groupe 2
 */
public class CtrlModifExo implements ActionListener {
    private ApplicationProf appli;
    private PanelModifExo panelFormExo;
    private String nomImg;
    
    /**
     * Constructeur du controleur CtrlModifExo
     * @param lePanel : panel de modification d'exercice
     * @param lAppli : application utilisée
     */
    public CtrlModifExo(PanelModifExo lePanel, ApplicationProf lAppli){
        appli = lAppli;
        panelFormExo = lePanel;
    }
    
    @Override
    /**
     * Méthode actionPerformed
     * Permet d'appeler la fonction voulue ou de faire les actions souhaitées 
     * en fonction du bouton sélectionné par l'utilisateur
     * Les choix possibles sont ici : changer l'image de l'exercice -
     * valider les changements apportés
     * @param e : action event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == panelFormExo.getButAddImage()){ //AJOUTER UNE IMAGE
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
                    String repCourant = new java.io.File("").getAbsolutePath();
                    repCourant+=".\\img\\";
                    String[] nomImage = monFichier.toString().split("\\\\");
                    nomImg = nomImage[nomImage.length-1];
                    String destination = repCourant+nomImage[nomImage.length-1];
                    File maDest = new File(destination);
                    copier(monFichier,maDest);
                    Thread currentThread = Thread.currentThread();
                    
                    int n =  0 ; 
                    while (n++ <  20) {
                       try {
                         currentThread.sleep(400) ;
                      }  catch (InterruptedException exp) {
                          // gestion de l'erreur
                      }
                    }
                    image = ImageIO.read(maDest);
                    BufferedImage buttonIcon = ImageIO.read(new File(repCourant+nomImage[nomImage.length-1]));
                    ImageIcon imageExo = new ImageIcon(buttonIcon);
                    panelFormExo.setImageExo(imageExo);
                } catch (IOException ex) {
                    Logger.getLogger(CtrlFormExo.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
            
        } else if (e.getSource() == panelFormExo.getButValidForm()){ //VALIDER EXERCICE
            Boolean validation = true;
            int choixTortue = -1;
            String comExo = "";
            String nomExo = "";
            ImageIcon imageExo = null;
            // VERIFIE QUE TOUTE LES CONDITIONS SONT REMPLIES
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
                            boiteDial.showMessageDialog(null, "Vous devez choisir une tortue", "Modification exercice", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }else{
                        comExo = "Pas de commentaire";
                        if (panelFormExo.getRadTortNorm().isSelected()){
                            choixTortue=0;
                        }else if (panelFormExo.getRadTortRap().isSelected()){
                            choixTortue=2;
                        }else if (panelFormExo.getRadTortCoul().isSelected()){
                            choixTortue=1;
                        }else{ // SI PAS DE TORTUE CHOISIE
                            validation = false;
                            //Boîte du message d'information.
                            JOptionPane boiteDial = new JOptionPane();
                            boiteDial.showMessageDialog(null, "Vous devez choisir une tortue", "Modification exercice", JOptionPane.INFORMATION_MESSAGE);                            
                        }
                    }
                }else{ // SI PAS IMAGE
                    validation = false;
                    //Boîte du message d'information.
                    JOptionPane boiteDial = new JOptionPane();
                    boiteDial.showMessageDialog(null, "Vous devez ajouter une image à cet exercice", "Modification exercice", JOptionPane.INFORMATION_MESSAGE);                    
                }
            }else{ //SI PAS DE NOM 
                validation = false;
                //Boîte du message d'information.
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "Vous devez renseigner le nom de l'exercice", "Modification exercice", JOptionPane.INFORMATION_MESSAGE);                
            }
            if (validation){
                Exercice newExo = new Exercice(nomExo,comExo,choixTortue,nomImg);
                appli.getListeExo().remove(panelFormExo.getExoModif());
                appli.getListeExo().add(newExo);
                appli.afficheExercices();
            }
        }
    }
    
    public static boolean copier(File source, File dest) { 
        try (InputStream sourceFile = new java.io.FileInputStream(source);  
                OutputStream destinationFile = new FileOutputStream(dest)) { 
            // Lecture par segment de 0.5Mo  
            byte buffer[] = new byte[512 * 1024]; 
            int nbLecture; 
            while ((nbLecture = sourceFile.read(buffer)) != -1){ 
                destinationFile.write(buffer, 0, nbLecture); 
            } 
        } catch (IOException e){ 
            e.printStackTrace(); 
            return false; // Erreur 
        } 
        return true; // Résultat OK   
    }
}