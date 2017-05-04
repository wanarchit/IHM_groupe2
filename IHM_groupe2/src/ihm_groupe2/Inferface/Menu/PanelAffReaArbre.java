package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlAffReaArbre;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Groupe 2
 */
public class PanelAffReaArbre extends JPanel{
    
    private Realisation rea;
    private ApplicationProf appli;
    private JButton corrigerRea;
    private CtrlAffReaArbre controleur;
    private Eleve eleve;
    
    public PanelAffReaArbre(Realisation laRea, ApplicationProf lAppli, Eleve lEleve){
        appli = lAppli;
        rea = laRea;
        eleve = lEleve;
        
        JLabel textEntete = new JLabel(new ImageIcon(getClass().getResource("/Images/RealisationEleve.png")));
        textEntete.setPreferredSize(new Dimension(250,51));
        
        JPanel panel0 = new JPanel(new BorderLayout());
        panel0.add(textEntete,BorderLayout.CENTER);
        panel0.setBackground(Color.white);         
        
        //NOM REALISATION
        JLabel labelNomRea1 = new JLabel("Exercice : ");
        labelNomRea1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomRea1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));
        
        JLabel labelNomRea2 = new JLabel(rea.getExercice().getNom());
        labelNomRea2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNomRea2.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16));
        
        JPanel panelNom = new JPanel();
        panelNom.add(labelNomRea1);
        panelNom.add(labelNomRea2);
        
        //TENTATIVE
        JLabel labelTenta1 = new JLabel("Tentative n°");
        labelTenta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTenta1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));
          
        JLabel labelTenta2 = new JLabel("" + rea.getNumeroTentative());
        labelTenta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTenta2.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16));
        
        JPanel panelTenta = new JPanel();
        panelTenta.add(labelTenta1);            
        panelTenta.add(labelTenta2);     
        
        //EVALUATION
        JLabel labelEvalRea1 = new JLabel();
        labelEvalRea1.setText("Etat de la tentative : ");
        labelEvalRea1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEvalRea1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));
        
        JLabel labelEvalRea2 = new JLabel();
        labelEvalRea2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEvalRea2.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16));
        
        JPanel panelEval = new JPanel();
        panelEval.add(labelEvalRea1);            
        panelEval.add(labelEvalRea2);         
        
        //NOTE REALISATION
        JLabel labelNoteRea1 = new JLabel();
        labelNoteRea1.setText("Note : ");
        labelNoteRea1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNoteRea1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));  
        
        JLabel labelNoteRea2 = new JLabel();
        labelNoteRea2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelNoteRea2.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16));
        
        JPanel panelNote = new JPanel();
        panelNote.add(labelNoteRea1);            
        panelNote.add(labelNoteRea2);         
        
        //COMMENTAIRE REALISATION
        JLabel labelCommRea1 = new JLabel();
        labelCommRea1.setText("Commentaire : ");
        labelCommRea1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCommRea1.setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,16));  
        
        JLabel labelCommRea2 = new JLabel();
        labelCommRea2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelCommRea2.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16));
        
        JPanel panelComm = new JPanel();
        panelComm.add(labelCommRea1);            
        panelComm.add(labelCommRea2); 
        
        
        if (rea.isACorriger()){
            labelEvalRea2.setText("A corriger");
            labelNoteRea2.setText("Non évaluée");
            labelCommRea2.setText("Non évaluée");
        }else{
            labelEvalRea2.setText("Corrigée");
            labelNoteRea2.setText(rea.getNote());
            labelCommRea2.setText(rea.getCommentaire());
        }
        
        corrigerRea = new JButton(new ImageIcon(getClass().getResource("/Images/Evaluer.png")));
        corrigerRea.setPreferredSize(new Dimension(280,51));
        controleur = new CtrlAffReaArbre(this,rea,appli,eleve);
        corrigerRea.addActionListener(controleur);
        JPanel ssPanel = new JPanel();
        ssPanel.add(corrigerRea);

        
        this.setLayout(new GridLayout(7,1));
        this.add(panel0);
        this.add(panelNom);
        this.add(panelTenta);
        this.add(panelEval);
        this.add(panelNote);
        this.add(panelComm);
        this.add(ssPanel);
        
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
    }
    
    public JButton getButEvaluer(){
        return corrigerRea;
    }
}
