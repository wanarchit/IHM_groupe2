package ihm_groupe2.Noyau_fonctionnel;

import javax.swing.ImageIcon;

/**
 *
 * @author Paul
 */
public class Exercice {
    private String nom;
    private String commentaire;
    private TortueG tortue;
    private ImageIcon image;
    
    /**
     * 
     * @param nomEx
     * @param commEx
     * @param choixTortue 1: Tortue couleur / 2:Tortue rapide
     * @param image 
     */
    public Exercice(String nomEx, String commEx, int choixTortue, ImageIcon image){
        this.nom=nomEx;
        this.commentaire=commEx;
        if (choixTortue==1){
            tortue=new TortueCouleur();
        }else {
            tortue=new TortueRapide();
        }
        this.image=image;
    }
    /**
     * 
     * @return nom de l'exercice as string
     */
    public String getNom(){
        return this.nom;
    }
    /**
     * 
     * @param commentaire a ajouter/modifier
     */
    public void setCommentaire(String commentaire){
        if (commentaire.length() < 300){
            this.commentaire=commentaire;
        }
    }
    /**
     * 
     * @return commentaire as string
     */
    public String getCommentaire(){
        return this.commentaire;
    }
    /**
     * 
     * @return image de l'exercice as ImageIcon
     */
    public ImageIcon getImage(){
        return this.image;
    }
}
