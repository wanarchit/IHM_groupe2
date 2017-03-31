/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.MenuProf;
import ihm_groupe2.Inferface.Menu.PanelCreerExo;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    
    
    private Professeur professeur;
    private MenuProf menuProfesseur;
    
    /**
     * Constructeur de la classe CtrlMenuProf
     * @param leProf qui est connecté au menu
     * @param leMenu du professeur qu'on va modifier
     */
    public CtrlMenuProf(Professeur leProf, MenuProf leMenu){
        professeur=leProf;
        menuProfesseur = leMenu;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //menuProfesseur.getPanelDroite(); (maj du panel de droite)
        if (e.getSource() == menuProfesseur.getButtonCreerExo()){
            menuProfesseur.remove(menuProfesseur.getPanelDroite());
            
            // On fera appel à un new PanelCreerExo
            JPanel newPanelDroite = new PanelCreerExo();
            menuProfesseur.add(newPanelDroite,BorderLayout.CENTER);
            menuProfesseur.validate();
            
        }else if (e.getSource() == menuProfesseur.getButtonExo()){
            menuProfesseur.remove(menuProfesseur.getPanelDroite());
            
            // On fera appel à un panel new ListeExercice
            
            
            JLabel monLabel1 = new JLabel("Liste des exercices");
            JPanel newPanelDroite = new JPanel();
            newPanelDroite.add(monLabel1);
            menuProfesseur.add(newPanelDroite,BorderLayout.CENTER);
            menuProfesseur.validate();
            
        }else if (e.getSource() == menuProfesseur.getButtonEleve()){
            menuProfesseur.remove(menuProfesseur.getPanelDroite());
            
            // On fera appel à un panel new ListeEleve
            
            
            JLabel monLabel1 = new JLabel("Liste des élèves");
            JPanel newPanelDroite = new JPanel();
            newPanelDroite.add(monLabel1);
            menuProfesseur.add(newPanelDroite,BorderLayout.CENTER);
            menuProfesseur.validate();
            
        }else if (e.getSource() == menuProfesseur.getButtonClasse()){
            menuProfesseur.remove(menuProfesseur.getPanelDroite());
            
            // On fera appel à un panel new ListeClasse
            
            
            JLabel monLabel1 = new JLabel("Liste des classes");
            JPanel newPanelDroite = new JPanel();
            newPanelDroite.add(monLabel1);
            menuProfesseur.add(newPanelDroite,BorderLayout.CENTER);
            menuProfesseur.validate();
        }
        
    }
}
