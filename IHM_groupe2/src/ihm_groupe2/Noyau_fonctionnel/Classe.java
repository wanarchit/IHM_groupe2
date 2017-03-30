package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Classe Classe
 * Permet de créer l'objet Classe qui contient des élèves et qui est géré par un Professeur
 * Des exercices pourront être ajouter aux classes
 * @author Marin
 */
public class Classe {

    private String nomClasse;
    private ArrayList<Eleve> listeEleve;
    private Professeur professeur;
    
    /**
     * Constructeur de la classe Classe
     * Permet d'initialiser une classe
     * @param nomCl : nom de la classe (niveau)
     * @param leProf : professeur qui gère la classe
     * @param lesEleves : liste des élèves de la classe
     */
    public Classe(String nomCl,Professeur leProf, ArrayList<Eleve> lesEleves ){
        nomClasse=nomCl;
        professeur=leProf;
        listeEleve=lesEleves;
    }
    
    /**
     * Function getNomClasse
     * Permet de récupérer le nom de la classe
     * @return 
     */
    public String getNomClasse() {
        return nomClasse;
    }
    
    /**
     * Function setNomClasse
     * Permet de modifier le nom de la classe
     * @param nomClasse 
     */
    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    
    /**
     * Function getProfesseur
     * Permet de récupérer le professeur référent de la classe
     * @return professeur : le professeur référent
     */
    public Professeur getProfesseur() {
        return professeur;
    }

    /**
     * Function setProfesseur
     * Permet de modifier le professeur référent de la classe
     * @param professeur
     */
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
        
    /**
     * Function ajoutEleve
     * Permet d'ajouter un élève dans la liste d'élève (donc dans la classe)
     * @param monEleve 
     */
    public void ajoutEleve(Eleve monEleve){
        listeEleve.add(monEleve);
    }
    
    /**
     * Function suppEleve
     * Permet de supprimer un eleve d'une classe
     * @param monEleve : l'élève à supprimer
     */
    public void suppEleve(Eleve monEleve){
        for(Eleve el:listeEleve){
            if (el.equals(monEleve)){
                listeEleve.remove(el);
            }
        }
    }
    
}