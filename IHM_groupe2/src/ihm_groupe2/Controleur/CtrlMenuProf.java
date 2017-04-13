/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.ListeEleves;
import ihm_groupe2.Inferface.Menu.MenuProf;
import ihm_groupe2.Inferface.Menu.PanelCreerExo;
import ihm_groupe2.Inferface.Menu.PanelModifExo;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe CtrlMenuProf
 * Permet de gérer les choix du professeur dans le menuProf
 * Il affichera les panels en fonction des choix que l'utilisateur fait
 * 
 * @author Paul
 */
public class CtrlMenuProf implements ActionListener{
    
    
    private ApplicationProf appli;
    private MenuProf menuProfesseur;
    
    /**
     * Constructeur de la classe CtrlMenuProf
     * @param leProf qui est connecté au menu
     * @param leMenu du professeur qu'on va modifier
     */
    public CtrlMenuProf(ApplicationProf lAppli, MenuProf leMenu){
        appli = lAppli;
        menuProfesseur = leMenu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //menuProfesseur.getPanelDroite(); (maj du panel de droite)
        if (e.getSource() == menuProfesseur.getButtonCreerExo()){
            appli.creerExercice();
        }else if (e.getSource() == menuProfesseur.getButtonExo()){           
            appli.afficheExercices();
        }else if (e.getSource() == menuProfesseur.getButtonEleve()){
            appli.afficheEleves();
        }else if (e.getSource() == menuProfesseur.getButtonClasse()){
            appli.afficheClasses();
        }else if (e.getSource() == menuProfesseur.getButtonDeco()){
            appli.seDeconnecter();
        }
        
    }
}
