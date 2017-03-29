package ihm_groupe2.Noyau;

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

    public Classe getLaClasse() {
        return laClasse;
    }

    public void setLaClasse(Classe laClasse) {
        this.laClasse = laClasse;
    }

    public ArrayList<Realisation> getLesRealisations() {
        return lesRealisations;
    }

    public void setLesRealisations(ArrayList<Realisation> lesRealisations) {
        this.lesRealisations = lesRealisations;
    }
    
}
