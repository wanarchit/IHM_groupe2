package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlAffReaArbre;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

/**
 *
 * @author Paul
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
        
        JLabel labelNomRea = new JLabel("Exercice : "+rea.getExercice().getNom()+" / Tentative n°"+rea.getNumeroTentative());
        labelNomRea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel labelEvalRea = new JLabel();
        labelEvalRea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel labelNoteRea = new JLabel();
        labelNoteRea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabel labelCommRea = new JLabel();
        labelCommRea.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        if (rea.isACorriger()){
            labelEvalRea.setText("Etat tentative : A corriger");
            labelNoteRea.setText("Note : Non évaluée");
            labelCommRea.setText("Commentaire : Non évaluée");
        }else{
            labelEvalRea.setText("Etat tentative : Corrigée");
            labelNoteRea.setText("Note : "+rea.getNote());
            labelCommRea.setText("Commentaire : "+rea.getCommentaire());
        }
        
        corrigerRea = new JButton("Evaluer la réalisation");
        controleur = new CtrlAffReaArbre(this,rea,appli,eleve);
        corrigerRea.addActionListener(controleur);
        JPanel ssPanel = new JPanel();
        ssPanel.add(corrigerRea);

        
        this.setLayout(new GridLayout(5,1));
        this.add(labelNomRea);
        this.add(labelEvalRea);
        this.add(labelNoteRea);
        this.add(labelCommRea);
        this.add(ssPanel);
        
        this.setBorder(new javax.swing.border.BevelBorder(BevelBorder.RAISED));
    }
    
    public JButton getButEvaluer(){
        return corrigerRea;
    }
}
