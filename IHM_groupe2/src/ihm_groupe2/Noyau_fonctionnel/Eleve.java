package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;


/**
 * Classe Eleve
 * Héritée de la classe personne
 * Permet de créer un élève, d'avoir accès à la classe à laquelle l'élève appartient, avoir accès aux réalisations
 * de l'élève
 * 
 * @author Paul
 */
public class Eleve extends Personne{
    
    private Classe laClasse;
    private ArrayList<Realisation> lesRealisations;
    
    /**
     * Constructeur de la classe Eleve, permet de créer un élève
     * 
     * @param classe : la classe à laquelle l'élève appartient
     * @param realisations : la liste des réalisations de l'élève
     * @param leNom : le nom de l'élève
     * @param lePrenom  : le prénom de l'élève
     */
    public Eleve(Classe classe,ArrayList<Realisation> realisations, String leNom, String lePrenom){
        super(leNom,lePrenom);
        laClasse = classe;
        lesRealisations = realisations;
    }
    
    /**
     * Function getLaClasse
     * Permet de renvoyer la classe a laquelle apratient l'élève
     * @return laClasse : objet de type Classe
     */
    public Classe getLaClasse() {
        return laClasse;
    }
    
    /**
     * Function setLaClasse
     * Permet de modifier la classe de l'élève
     * @param laClasse : la nouvelle classe de l'élève
     */
    public void setLaClasse(Classe laClasse) {
        this.laClasse = laClasse;
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
     * Function addRealisation
     * Permet d'ajouter une réalisation dans la liste des réalisations faites par l'élève
     * @param laReal : faite par l'élève
     */
    public void addRealisation(Realisation laReal){
        lesRealisations.add(laReal);
    }
    
    /**
     * Function delRealisation
     * Permet de supprimer une réalisation faite par l'élève
     * @param laReal qui doit être supprimée
     */
    public void delRealisation(Realisation laReal){
        lesRealisations.remove(laReal);
    }
    
}
