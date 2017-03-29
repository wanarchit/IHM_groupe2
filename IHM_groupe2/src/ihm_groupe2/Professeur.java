/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2;

import java.util.ArrayList;

/**
 *
 * @author Jonathan
 */
public class Professeur extends Personne{
    private String login;
    private String motDePasse;
    private ArrayList listeClasse;
    
    public Professeur(String log, String mdp, String nom, String prenom) {
        login = log;
        motDePasse = mdp;
        super.nom;
        super.prenom;
    }
}
