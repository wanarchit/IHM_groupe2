package ihm_groupe2.Noyau_fonctionnel;

import java.util.ArrayList;

/**
 * Classe Professeur
 * Permet de créer un professeur qui pourra être le référent d'une classe, créer des exercices
 * corriger des exercices et les évaluer
 * @author Jonathan
 */
public class Professeur extends Personne{
    
    private String login;
    private String motDePasse;
    private ArrayList listeClasse;
    
    /**
     * Constructeur de la classe Professeur
     * @param log : login du professeur pour qu'il se connecte au programme
     * @param mdp : mot de passe du professeur pour qu'il se connecte
     * @param nom : nom du professeur
     * @param prenom prénom du professeur
     */
    public Professeur(String log, String mdp, String nom, String prenom) {
        super(nom,prenom);
        login = log;
        motDePasse = mdp;
    }
    
    /**
     * Function getLogin
     * Permet de récupérer le login du professeur
     * @return login du professeur
     */
    public String getLogin() {
        return login;
    }

    /**
     * Function getMotDePasse
     * Permet de récupérer le mot de passe du professeur
     * @return motDePasse du professeur
     */
    public String getMotdePasse() {
        return motDePasse;
    }    
    
    /**
     * Function setLogin
     * Méthode permettant de modifier le login du professeur
     * @param newLogin : le nouveau login
     */
    public void setLogin(String newLogin) {
        this.login = newLogin;
    }
    
    /**
     * Function setMotDePasse
     * Méthode permettant de modifier le mot de passe du professeur
     * @param newMotDePasse : le nouveau mot de passe
     */
    public void setMotDePasse(String newMotDePasse) {
        this.motDePasse = newMotDePasse;
    }
    
    /**
     * Function getLesClasses
     * Permet de récupérer toutes les classes dont s'occupe le professeur
     * @return listeClasse du professeur
     */
    public ArrayList<Classe> getLesClasses() {
        return listeClasse;
    }
    
    /**
     * Function addClasse
     * Permet d'ajouter une classe dans la liste des classes dont s'occupe le professeur
     * On ne peut pas ajouter deux fois la même classe
     * @param laClasse : classe à ajouter
     */
    public void addClasse(Classe laClasse){
        listeClasse.add(laClasse);
    }
    
    /**
     * Function delClasse
     * Permet de supprimer le proffesseur d'une de ses classes
     * Il est nécessaire de vérifier que la classe que l'on veut supprimer est dans la liste listeClasse
     * @param laClasse qui doit être supprimée
     */
    public void delClasse(Classe laClasse){
        listeClasse.remove(laClasse);
    }
    
    
}
