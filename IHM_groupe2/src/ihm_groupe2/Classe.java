/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2;

import java.util.ArrayList;

/**
 *
 * @author Marin
 */
public class Classe {
    private String nomClasse;
    private ArrayList<Eleve> listeEleve;
    private Professeur professeur;
    
    public Classe(String nomCl,Professeur leProf){
        nomClasse=nomCl;
        professeur=leProf;
    }
    
    public void ajoutEleve(Eleve monEleve){
        listeEleve.add(monEleve);
    }
    
    public void suppEleve(Eleve monEleve){
        for(Eleve el:listeEleve){
            if (el.equals(monEleve)){
                listeEleve.remove(el);
            }
        }
    }
    
    public
}

