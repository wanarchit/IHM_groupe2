/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Controleur;

import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Classe CtrlMenuProf
 * Permet de gérer les choix du professeur dans le menuProf
 * Il affichera les panels en fonction des choix que l'utilisateur fait
 * 
 * @author Paul
 */
public class CtrlMenuProf implements ActionListener{
    
    
    private Professeur professeur;
    
    /**
     * Constructeur de la classe CtrlMenuProf
     * @param leProf qui est connecté au menu
     */
    public CtrlMenuProf(Professeur leProf){
        professeur=leProf;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
}
