package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Classe Classe
 * Permet de créer l'objet Classe qui contient des élèves et qui est géré par un Professeur.
 * Elle est composée d'un nom de classe, d'une liste d'élèves et d'un professeur référent
 * Le nom de la classe n'est pas modifiable
 * @author Groupe 2
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
     */
    public Classe(String nomCl,Professeur leProf){
        nomClasse=nomCl;
        professeur=leProf;
        listeEleve=new ArrayList<Eleve>();
        leProf.addClasse(this);
    }
    
    /**
     * Méthode getNomClasse
     * Permet de récupérer le nom de la classe
     * @return nomClasse: Objet de type string
     */
    public String getNomClasse() {
        return nomClasse;
    }
    
    /**
     * Méthode getProfesseur
     * Permet de récupérer le professeur référent de la classe
     * @return professeur : Objet de type professeur
     */
    public Professeur getProfesseur() {
        return professeur;
    }
    
    /**
     * Méthode getListEleveClasse
     * Permet de récupérer la liste d'élèves de cette classe
     * @return listeEleve : objet de type Array List contenant des élèves
     */
    public ArrayList<Eleve> getListEleveClasse(){
        return listeEleve;
    } 

    /**
     * Méthode setProfesseur
     * Permet de modifier le professeur référent de la classe
     * @param professeur
     */
    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }
        
    /**
     * Méthode ajoutEleve
     * Permet d'ajouter un élève dans la liste d'élève (donc dans la classe), si il n'est pas déjà dedans
     * @param monEleve : Objet de type eleve
     */
    public void ajoutEleve(Eleve monEleve){ 
        boolean absent = true;
        for (int i=0; i<listeEleve.size();i++){
            if (monEleve.equals(listeEleve.get(i))){
                absent = false;
                break;
            }
        }
        if (absent){
            listeEleve.add(monEleve);
        }
    }
}