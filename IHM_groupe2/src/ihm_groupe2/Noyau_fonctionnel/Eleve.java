package ihm_groupe2.Noyau_fonctionnel;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Classe Eleve
 * Héritée de la classe Personne
 * Permet de créer un élève. 
 * Il est composé en plus d'un nom et prénom (hérité de Personne), d'une classe et d'une liste de réalisations
 * 
 * @author Groupe 2
 */
public class Eleve extends Personne{
    
    private ArrayList<Realisation> lesRealisations;
    private Classe laClasse;
    private ImageIcon image;
    
    /**
     * Constructeur de la classe Eleve
     * Permet de créer un élève
     * 
     * @param maClasse : la classe à laquelle l'élève appartient
     * @param leNom : le nom de l'élève
     * @param lePrenom  : le prénom de l'élève
     * @param pict : image de l'élève
     */
    public Eleve(Classe maClasse, String leNom, String lePrenom, ImageIcon pict){
        super(leNom,lePrenom);
        laClasse = maClasse;
        lesRealisations = new ArrayList<Realisation>();
        laClasse.ajoutEleve(this);
        image = new ImageIcon((pict).getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT));
    }
      
    /**
     * Méthode getLesRealisations
     * Permet de récupérer toutes les réalisations de l'élève
     * @return lesRealisations : Array List contenant des objets de type Réalisation
     */
    public ArrayList<Realisation> getLesRealisations() {
        return lesRealisations;
    }
    
    /**
     * Méthode getLaClasse
     * Permet de renvoyer la classe a laquelle appartient l'élève
     * @return laClasse : objet de type Classe
     */
    public Classe getLaClasse() {
        return laClasse;
    }
    
    /**
     * Méthode getIconEleve
     * Permet de renvoyer l'image icone de l'élève
     * @return image : de type ImageIcon
     */
    public ImageIcon getIconEleve(){
        return image;
    }
    
    /**
     * Méthode addRealisation
     * Permet d'ajouter une réalisation dans la liste des réalisations faites par l'élève
     * On ne peut pas ajouter deux fois la même réalisation 
     * @param laReal : faite par l'élève
     */
    public void addRealisation(Realisation laReal){
        boolean nouvelle = true;
        for (int i=0; i<lesRealisations.size();i++){
            if (laReal.equals(lesRealisations.get(i))){
                nouvelle = false;
                break;
            }
        }
        if (nouvelle){
        lesRealisations.add(laReal);
        }   
    } 
}
