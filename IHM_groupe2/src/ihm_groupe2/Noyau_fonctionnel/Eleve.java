package ihm_groupe2.Noyau_fonctionnel;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;


/**
 * Classe Eleve
 * Héritée de la classe personne
 * Permet de créer un élève, d'avoir accès à la classe à laquelle l'élève appartient, avoir accès aux réalisations
 * de l'élève
 * 
 * @author Paul
 */
public class Eleve extends Personne{
    
    private ArrayList<Realisation> lesRealisations;
    private Classe laClasse;
    private ImageIcon image;
    
    /**
     * Constructeur de la classe Eleve, permet de créer un élève
     * 
     * @param maClasse : la classe à laquelle l'élève appartient
     * @param leNom : le nom de l'élève
     * @param lePrenom  : le prénom de l'élève
     */
    public Eleve(Classe maClasse, String leNom, String lePrenom, ImageIcon pict){
        super(leNom,lePrenom);
        laClasse = maClasse;
        lesRealisations = new ArrayList<Realisation>();
        laClasse.ajoutEleve(this);
        image = new ImageIcon((pict).getImage().getScaledInstance(120,120, Image.SCALE_DEFAULT));
    }
    
    
    /**
     * Function getLesRealisations
     * Permet de récupérer toutes les réalistions de l'élève
     * @return lesRealisations de l'élève
     */
    public ArrayList<Realisation> getLesRealisations() {
        return lesRealisations;
    }
    
    /**
     * Function getLaClasse
     * Permet de renvoyer la classe a laquelle apratient l'élève
     * @return laClasse : objet de type Classe
     */
    public Classe getLaClasse() {
        return laClasse;
    }
    
    public ImageIcon getIconEleve(){
        return image;
    }
    
    /**
     * Function addRealisation
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
