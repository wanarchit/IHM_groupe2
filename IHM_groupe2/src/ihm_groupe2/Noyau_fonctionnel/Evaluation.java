package ihm_groupe2.Noyau_fonctionnel;

/**
 * Classe Evaluation
 * Permet de relier un exercice et un élève et donne une validation (true/false) dès que l'élève tente un exercice
 * Elle est composée d'un élève, d'un exercice et d'un booléen validation
 * 
 * @author Groupe 2
 */
public class Evaluation {
    
    private Eleve monEleve;
    private Exercice monExercice;
    private Boolean validation;
    
    /**
     * Constructeur de la classe Evaluation
     * @param lEleve : l'élève concerné par l'évaluation
     * @param lExo : l'exercice concerné par l'exercice
     * @param valide : boolean pour la validation de l'exercice pour cet élève
     */
    public Evaluation(Eleve lEleve, Exercice lExo, Boolean valide){
        monEleve = lEleve;
        monExercice = lExo;
        validation = valide;       
    }

    /**
     * Méthode getMonEleve
     * Permet de récupérer l'élève
     * @return monEleve : objet de type Eleve
     */
    public Eleve getMonEleve() {
        return monEleve;
    }

    /**
     * Méthode getMonExercice
     * Permet de récupérer l'exercice
     * @return monExercice : objet de type Exercice
     */
    public Exercice getMonExercice() {
        return monExercice;
    }

    /**
     * Méthode getValidation
     * Permet de récupérer le statut de l'évaluation : exercice validé ou non par l'élève
     * @return validation : de type booléen
     */
    public Boolean getValidation() {
        return validation;
    }

    /**
     * Méthode setValidation
     * Permet de modifier l'évaluation de l'élève pour l'exercice
     * Le passage peut se faire uniquement de False -> True et non l'inverse
     * @param validation : booléen --> vrai ou faux
     */
    public void setValidation(Boolean validation) {
        if (!this.validation){  // on ne pourra pas passer "false" un exercice validé
            this.validation = validation;
        }        
    }
}
