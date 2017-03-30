package ihm_groupe2.Noyau_fonctionnel;

/**
 * Classe Evaluation
 * Permet de relier un exercice et un elève et donne une validation (true/false) dès que l'élève tente un exercice
 * @author Paul
 */
public class Evaluation {
    
    private Eleve monEleve;
    private Exercice monExercice;
    private Boolean validation;
    
    /**
     *  Constructeur de la classe Evaluation
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
     * function getMonEleve
     * Permet de récupérer l'élève
     * @return monEleve
     */
    public Eleve getMonEleve() {
        return monEleve;
    }

    /**
     * function getMonExercice
     * Permet de récupérer l'exercice
     * @return monExercice
     */
    public Exercice getMonExercice() {
        return monExercice;
    }

    /**
     * function getValidation
     * Permet de récupérer le statut de l'évaluation : exercice validé ou non par l'élève
     * @return validation
     */
    public Boolean getValidation() {
        return validation;
    }

    /**
     * function setValidation
     * Permet de modifier l'évaluation de l'élève pour l'exercice
     * On controlera que le passage pour se faire uniquement de False -> True et pas l'inverse
     * @param validation 
     */
    public void setValidation(Boolean validation) {
        if (!this.validation){  // on ne pourra pas passer "false" un exercice validé
            this.validation = validation;
        }        
    }
    
    
}
