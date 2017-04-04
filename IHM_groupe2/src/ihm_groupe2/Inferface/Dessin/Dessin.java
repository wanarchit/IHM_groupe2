/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Inferface.Dessin;

import Applications.ApplicationEleve;
import ihm_groupe2.Controleur.CtrlDessinEleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Paul
 */
public class Dessin extends JPanel{
    
    private ApplicationEleve appli;
    private Exercice exoEnCours;
    
    private JButton butValider;
    private JButton butRetour;
    private JButton butAnnuler;
    private JButton butEcrire;
    private JButton butAvancer;
    private JButton butTourner;
    
    private CtrlDessinEleve controleur;
    
    
    public Dessin(ApplicationEleve lAppli, Exercice exo){
        appli=lAppli;
        exoEnCours = exo;
        
        
        /** ssPanel du haut :  bouton terminer (valider),
          bouton retour, bouton anuler action */
        
        JPanel ssPanelHaut = new JPanel(new GridLayout(1,3));
        ssPanelHaut.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        butValider = new JButton("J'ai fini");
        butRetour = new JButton("Retour");
        butAnnuler = new JButton("J'annule");
        ssPanelHaut.add(butValider);
        ssPanelHaut.add(butRetour);
        ssPanelHaut.add(butAnnuler);
        
        /** ssPanel Milieu : canvas */
        JPanel ssPanelMilieu = new JPanel();
        ssPanelMilieu.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel lab8 = new JLabel("toto");
        ssPanelMilieu.add(lab8);
        
        /** ssPanel bas : boutons actions : écrire / avancer / tourner */
        JPanel ssPanelBas = new JPanel(new GridLayout(1,3));
        ssPanelBas.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        butEcrire = new JButton("Ecrire");
        butAvancer = new JButton("Avancer");
        butTourner = new JButton("Tourner");
        ssPanelBas.add(butEcrire);
        ssPanelBas.add(butAvancer);
        ssPanelBas.add(butTourner);
        
        
        /** ssPanel gauche : liste actions */
        JPanel ssPanelGauche = new JPanel(new BorderLayout());
        ssPanelGauche.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel labelJai = new JLabel("J'ai ...      ");
        JLabel labelAction = new JLabel("Avancé");
        ssPanelGauche.add(labelJai, BorderLayout.NORTH);
        ssPanelGauche.add(labelAction, BorderLayout.CENTER);
        
       
        /** ssPanel Centre : ssPanel Milieu / ssPanel haut / ssPanel bas */
        JPanel ssPanelCentre = new JPanel(new BorderLayout());
        ssPanelCentre.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        ssPanelCentre.add(ssPanelHaut, BorderLayout.NORTH);
        ssPanelCentre.add(ssPanelMilieu, BorderLayout.CENTER);
        ssPanelCentre.add(ssPanelBas, BorderLayout.SOUTH);
        
        
        /** ssPanel droite : info exo + model */
        JPanel ssPanelDroite = new JPanel(new BorderLayout());
        ssPanelDroite.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        JLabel labTypeTortue = new JLabel();
        labTypeTortue.setHorizontalAlignment(JLabel.CENTER);
        labTypeTortue.setVerticalAlignment(JLabel.CENTER);
        
        if (exoEnCours.getTortueChoisie() == 0){
            labTypeTortue.setText("Tortue Classique");
        }else if (exoEnCours.getTortueChoisie() == 1){
            labTypeTortue.setText("Tortue Couleur");
        }else{
            labTypeTortue.setText("Tortue Rapide");
        }
        
        JLabel labNomExo = new JLabel(exoEnCours.getNom());
        labNomExo.setHorizontalAlignment(JLabel.CENTER);
        labNomExo.setVerticalAlignment(JLabel.CENTER);
        JLabel lab13 = new JLabel("tentative 1");
        lab13.setHorizontalAlignment(JLabel.CENTER);
        lab13.setVerticalAlignment(JLabel.CENTER);
        
        JPanel ssPanelDroite2 = new JPanel(new GridLayout(3,1));
        ssPanelDroite2.add(labTypeTortue);
        ssPanelDroite2.add(labNomExo);
        ssPanelDroite2.add(lab13);
        
        JPanel ssPanMonModel = new JPanel(new BorderLayout());
        JLabel labMonModel = new JLabel("Mon model :");
        
        JPanel panImage = new JPanel(new BorderLayout());
        panImage.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        panImage.setPreferredSize(new Dimension(200,200));
        JLabel labImageExo = new JLabel();
        labImageExo.setHorizontalAlignment(JLabel.CENTER);
        labImageExo.setVerticalAlignment(JLabel.CENTER);
        ImageIcon iconExo = exoEnCours.getImage();
        labImageExo.setIcon(iconExo);
        panImage.add(labImageExo, BorderLayout.CENTER);
        
        ssPanMonModel.add(labMonModel, BorderLayout.NORTH);
        ssPanMonModel.add(panImage, BorderLayout.CENTER);
        
        ssPanelDroite.add(ssPanelDroite2,BorderLayout.NORTH);
        ssPanelDroite.add(ssPanMonModel,BorderLayout.CENTER);
        

        
        
        
        
        
        
        
        controleur = new CtrlDessinEleve(appli,this);
        butRetour.addActionListener(controleur);
        
        this.setLayout(new BorderLayout());
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
        this.add(ssPanelGauche, BorderLayout.WEST);
        this.add(ssPanelCentre, BorderLayout.CENTER);
        this.add(ssPanelDroite, BorderLayout.EAST);
        //this.add(butRetour);
        
        
    }
    
    public JButton getButValidation(){
        return butValider;
    }
    
    public JButton getButRetour(){
        return butRetour;
    }
    
    public JButton getButAnnuler(){
        return butAnnuler;
    }
    
    public JButton getButEcrire(){
        return butEcrire;
    }
    
    public JButton getButAvancer(){
        return butAvancer;
    }
    
    public JButton getButTourner(){
        return butTourner;
    }
    
    public Exercice getExoEnCours(){
        return exoEnCours;
    }
}

