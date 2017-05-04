package ihm_groupe2.Noyau_fonctionnel;

/**
 * Classe Personne
 * Classe mère pour les héritiés Professeur et Eleve
 * @author Groupe 2
 */
public class Personne {
    protected String nomPersonne;
    protected String prenomPersonne;
    
    /**
     * Constructeur de la classe mère Personne
     * @param leNom : nom de la personne à créer
     * @param lePrenom : prénom de la personne à créer
     */
    public Personne(String leNom, String lePrenom){
        nomPersonne=leNom;
        prenomPersonne=lePrenom; 
    }
    
    /**
     * Function getNomPersonne
     * Permet de récupérer le nom de la personne
     * @return nomPersonne : le nom de la personne
     */
    public String getNomPersonne() {
        return nomPersonne;
    }
    
    /**
     * Function setNomPersonne
     * Permet de modifier le nom de la personne
     * @param newNnom : le nom de la personne
     */
    public void setNomPersonne(String newNnom) {
        this.nomPersonne = newNnom;
    }
    
    /**
     * Function getPrenomPersonne
     * Permet de récupérer le prénom de la personne
     * @return prenomPersonne : le prénom de la personne
     */
    public String getPrenomPersonne() {
        return prenomPersonne;
    }
    
    /**
     * Function setPrenomPersonne
     * Permet de modifier le prénom de la personne
     * @param newPrenom : le prénom de la personne
     */
    public void setPrenomPersonne(String newPrenom) {
        this.prenomPersonne = newPrenom;
    }
    
    
         
}
