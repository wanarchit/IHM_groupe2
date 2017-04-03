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
    public Classe(String nomCl,Professeur leProf){
        nomClasse=nomCl;
        professeur=leProf;
        listeEleve=new ArrayList<Eleve>();
    }
    
    /**
     * Function getNomClasse
     * Permet de récupérer le nom de la classe
     * @return nomClasse: Objet de type string
     */
    public String getNomClasse() {
        return nomClasse;
    }
    
    /**
     * Function setNomClasse
     * Permet de modifier le nom de la classe
     * @param nomClasse : Objet de type string
     */
    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
    
    /**
     * Function getProfesseur
     * Permet de récupérer le professeur référent de la classe
     * @return professeur : Objet de type professeur
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
     * Permet d'ajouter un élève dans la liste d'élève (donc dans la classe), si il n'est pas déjà dedans
     * @param monEleve : Objet de type eleve
     */
    public void ajoutEleve(Eleve monEleve){
        listeEleve.add(monEleve);
    }
    
    /**
     * Function suppEleve
     * Permet de supprimer un eleve d'une classe
     * @param monEleve : l'élève à supprimer (type eleve)
     */
    public void suppEleve(Eleve monEleve){
        if (listeEleve.size()!=0){
            for(Eleve el:listeEleve){
                if (el.equals(monEleve)){
                    listeEleve.remove(el);
                }
            }
        }
    }
    
    public ArrayList<Eleve> getListEleveClasse(){
        return listeEleve;
    }
    
    public int getSizeClasse() {
        return (listeEleve.size());
    }
    
}