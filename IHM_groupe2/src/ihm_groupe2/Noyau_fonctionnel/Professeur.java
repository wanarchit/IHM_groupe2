package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Classe Professeur, classe fille de la classe Personne
 * Permet de créer un professeur qui pourra être le référent d'une classe
 * Un professeur est composé d'un login, d'un mot de passe ainsi que 
 * d'une liste de classe pour laquelle il est référent
 * 
 * @author Groupe 2
 */
public class Professeur extends Personne{
    
    private String login;
    private String motDePasse;
    private ArrayList listeClasse;
    
    /**
     * Constructeur de la classe Professeur
     * Permet la création d'un professeur
     * @param log : login du professeur pour qu'il se connecte au programme
     * @param mdp : mot de passe du professeur pour qu'il se connecte
     * @param nom : nom du professeur
     * @param prenom prénom du professeur
     */
    public Professeur(String log, String mdp, String nom, String prenom) {
        super(nom,prenom);
        login = log;
        motDePasse = mdp;
        listeClasse = new ArrayList<Classe>();
    }
    
    /**
     * Méthode getLogin
     * Permet de récupérer le login du professeur
     * @return login du professeur : de type String
     */
    public String getLogin() {
        return login;
    }

    /**
     * Méthode getMotDePasse
     * Permet de récupérer le mot de passe du professeur
     * @return motDePasse du professeur : de type String
     */
    public String getMotdePasse() {
        return motDePasse;
    }    
    
    /**
     * Méthode getLesClasses
     * Permet de récupérer toutes les classes dont s'occupe le professeur
     * @return listeClasse : Array List contenant des objets de type Classe
     */
    public ArrayList<Classe> getLesClasses() {
        return listeClasse;
    }
    
    /**
     * Méthode setLogin
     * Méthode permettant de modifier le login du professeur
     * @param newLogin : le nouveau login (String)
     */
    public void setLogin(String newLogin) {
        this.login = newLogin;
    }
    
    /**
     * Méthode setMotDePasse
     * Méthode permettant de modifier le mot de passe du professeur
     * @param newMotDePasse : le nouveau mot de passe (String)
     */
    public void setMotDePasse(String newMotDePasse) {
        this.motDePasse = newMotDePasse;
    }
    
    /**
     * Méthode addClasse
     * Permet d'ajouter une classe dans la liste des classes dont s'occupe le professeur
     * On ne peut pas ajouter deux fois la même classe
     * @param laClasse : classe à ajouter
     */
    public void addClasse(Classe laClasse){
        boolean dejaProf = false;
        for (int i=0; i<listeClasse.size();i++){
            if (laClasse.equals(listeClasse.get(i))){
                dejaProf = true;
                break;
            }
        }
        if (!dejaProf){
        listeClasse.add(laClasse);
        }
    }
}
