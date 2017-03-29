package ihm_groupe2.Noyau;

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
}
