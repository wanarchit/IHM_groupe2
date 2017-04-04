package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Dessin.Dessin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Paul
 */
public class CtrlDessinEleve implements ActionListener{
    
    private ApplicationEleve appli;
    private Dessin leDessin;
    
    public CtrlDessinEleve(ApplicationEleve lAppli,Dessin dessinEleve){
        appli = lAppli;
        leDessin = dessinEleve;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == leDessin.getButRetour() ){
            appli.annulerDessin(leDessin.getExoEnCours());
        }else if (e.getSource() == leDessin.getButAvancer()){
            leDessin.getLaTortue().avancer();
        }else if (e.getSource() == leDessin.getButTourner()){
            leDessin.getLaTortue().tourner();
        }else if (e.getSource() == leDessin.getButEcrire()){
            leDessin.getLaTortue().tracer(!leDessin.getLaTortue().enTrace());
        }
    
        
        
    }
}
