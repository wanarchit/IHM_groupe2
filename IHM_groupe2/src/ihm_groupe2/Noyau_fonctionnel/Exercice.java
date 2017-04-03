package ihm_groupe2.Noyau_fonctionnel;

import javax.swing.ImageIcon;

/**
 * Classe exercice, permet au professeur de créer et modfier des exercices afin de les attribuer aux élèves
 * @author Marin
 */
public class Exercice {
    private String nom;
    private String commentaire;
    private TortueG tortue;
    private ImageIcon image;
    private boolean modifiable;
    
    /**
     * Constructeur de la classe exercice, permet de créer un exercice
     * @param nomEx: nom donné à l'exercice
     * @param commEx: commentaire du professeur à propos de l'exercice
     * @param choixTortue Tortue imposée pour l'exercice 1: Tortue couleur / 2:Tortue rapide
     * @param image : Image représentant l'exercice à faire
     * @param modif : si l'exercice est modifiable
     */
    public Exercice(String nomEx, String commEx, int choixTortue, ImageIcon image){
        this.nom=nomEx;
        this.commentaire=commEx;
        if (choixTortue==1){
            tortue=new TortueCouleur();
        }else if(choixTortue==2){
            tortue=new TortueRapide();
        }else{
            tortue=new TortueG();
        }
        this.image=image;
        this.modifiable = true;
    }
    /**
     * Function getNom
     * Renvoi le nom de l'exercice
     * @return nom : objet de type string
     */
    public String getNom(){
        return this.nom;
    }
    /**
     * Function setCommentaire
     * Permet de modifier le commentaire de l'exercice
     * @param commentaire: Commentaire qu'on modifie de type string
     */
    public void setCommentaire(String commentaire){
        if (commentaire.length() < 250){
            this.commentaire=commentaire;
        }
    }
    /**
     * Function getCommentaire
     * Permet de mofidier le commentaire d'un exercice
     * @return commentaire: objet de type string
     */
    public String getCommentaire(){
        return this.commentaire;
    }
    /**
     * Function getImage
     * Permet de renvoyer l'image de l'exercice
     * @return image : Objet de type ImageIcon
     */
    public ImageIcon getImage(){
        return this.image;
    }
    
    public boolean isModifiable(){
        return modifiable;
    }
    
    public void setModifiable(boolean newModif){
        modifiable = newModif;
    }
}
