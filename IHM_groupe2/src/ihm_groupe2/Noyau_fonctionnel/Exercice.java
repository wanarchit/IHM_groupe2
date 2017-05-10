package ihm_groupe2.Noyau_fonctionnel;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Classe exercice, permet de créer et modfier des exercices
 * Un exercice est constitué d'un nom, d'un commentaire éventuel, 
 * d'une tortue utilisée et d'une image qui est le modèle de l'exercice
 * 
 * @author Groupe 2
 */

public class Exercice {
    private String nom;
    private String commentaire;
    private int tortue;
    private ImageIcon image;
    private boolean modifiable;
    private TortueG maTortue;
    private String nomImage;

    /**
     * Constructeur de la classe exercice
     * Permet la création d'un exercice
     * A la création un exercice est modifiable puisqu'aucun élève ne l'a encore fait
     * @param nomEx: nom donné à l'exercice
     * @param commEx: commentaire du professeur à propos de l'exercice
     * @param choixTortue : tortue imposée pour l'exercice 0 : Tortue classique / 1 : Tortue couleur / 2 : Tortue rapide
     * @param image : image représentant l'exercice à faire
     */
    public Exercice(String nomEx, String commEx, int choixTortue, String nomImg){
        this.nom=nomEx;
        this.commentaire=commEx;
        tortue = choixTortue;
        if (choixTortue == 1){
            maTortue = new TortueCouleur();
        }else if(choixTortue == 2){
            maTortue = new TortueRapide();
        }else{
            maTortue = new TortueG();
        }
        nomImage = nomImg;

        try{
            image = new ImageIcon(getClass().getResource("/Images/"+nomImage));
        }catch (NullPointerException nullExp){
            try {
                BufferedImage buttonIcon = ImageIO.read(new File("img/"+nomImage));
                image = new ImageIcon(buttonIcon);
            } catch (IOException ex) {
                Logger.getLogger(Exercice.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        this.modifiable = true;
    }
    
    /**
     * Méthode getNom
     * Renvoi le nom de l'exercice
     * @return nom : objet de type string
     */
    public String getNom(){
        return this.nom;
    }
    
    /**
     * Méthode getCommentaire
     * Permet de retourner le commentaire d'un exercice
     * @return commentaire: objet de type string
     */
    public String getCommentaire(){
        return this.commentaire;
    }
    
    /**
     * Méthode getImage
     * Permet de renvoyer l'image de l'exercice
     * @return image : Objet de type ImageIcon
     */
    public ImageIcon getImage(){
        return this.image;
    }
    
    public String getNomImage(){
        return nomImage;
    }
    
    public void setNomImage(String nomImg){
        nomImage = nomImg;
        image = new ImageIcon(getClass().getResource(nomImage));
    }
    
    /**
     * Méthode isModifiable
     * Permet de renvoyer si l'exercice est modifiable ou non
     * @return modifiable : booléen vrai ou faux
     * Vrai : l'exercice est modifiable
     */
    public boolean isModifiable(){
        return modifiable;
    }
    
    /**
     * Méthode getTortueChoisie
     * Permert de renvoyer le nombre correspondant au type de tortue utilisée
     * @return tortue : integer 
     * 0 : Tortue classique / 1 : Tortue couleur / 2 : Tortue rapide
     */
    public int getTortueChoisie(){
        return tortue;
    }
    
    /**
     * Méthode getMaTortue
     * Permert de renvoyer la tortue utilisée
     * @return maTortue : objet de type TortueG
     */
    public TortueG getMaTortue(){
        return maTortue;
    }
    
    /**
     * Méthode setCommentaire
     * Permet de modifier le commentaire de l'exercice
     * @param commentaire: nouveau commentaire de type string
     */
    public void setCommentaire(String commentaire){
        if (commentaire.length() < 250){
            this.commentaire=commentaire;
        }
    }
    
    /**
     * Méthode setModifiable
     * Permet de changer la valeur du booléen modifiable
     * Dès lors qu'un élève à fait une réalisation pour cet exercice
     * @param newModif : nouvelle valeur pour le booléen modifiable (vrai ou faux)
     */
    public void setModifiable(boolean newModif){
        modifiable = newModif;
    }
}
