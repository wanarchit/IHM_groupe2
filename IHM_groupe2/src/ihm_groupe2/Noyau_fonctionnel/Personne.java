package ihm_groupe2.Noyau_fonctionnel;

/**
 * Classe Personne
 * Il s'agit d'une classe mère pour les classes Professeur et Elève
 * Une personne est composée d'un nom et d'un prénom
 * Le nom et le prénom d'une personne ne sont pas modifiables
 * 
 * @author Groupe 2
 */
public class Personne {
    protected String nomPersonne;
    protected String prenomPersonne;
    
    /**
     * Constructeur de la classe mère Personne
     * Permet la création d'une personne
     * @param leNom : nom de la personne à créer
     * @param lePrenom : prénom de la personne à créer
     */
    public Personne(String leNom, String lePrenom){
        nomPersonne=leNom;
        prenomPersonne=lePrenom; 
    }
    
    /**
     * Méthode getNomPersonne
     * Permet de récupérer le nom de la personne
     * @return nomPersonne : de type String
     */
    public String getNomPersonne() {
        return nomPersonne;
    }
    
    /**
     * Méthode getPrenomPersonne
     * Permet de récupérer le prénom de la personne
     * @return prenomPersonne : de type String
     */
    public String getPrenomPersonne() {
        return prenomPersonne;
    }     
}
