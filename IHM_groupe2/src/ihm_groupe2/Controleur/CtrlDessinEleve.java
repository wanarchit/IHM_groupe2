package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Dessin.Dessin;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
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
            
            Commande avance = new Commande("Avance",leDessin.getLaTortue());
            
            //leDessin.getNewRealisation().ajouterCommande();
            leDessin.RefreshListAction();
        }else if (e.getSource() == leDessin.getButTourner()){
            leDessin.getLaTortue().tourner();
        }else if (e.getSource() == leDessin.getButEcrire()){
            leDessin.getLaTortue().tracer(!leDessin.getLaTortue().enTrace());
        
        }else if (e.getSource() == leDessin.getButMoinsVite()){
                ((TortueRapide) leDessin.getLaTortue()).ralentir();
        }else if (e.getSource() == leDessin.getButPlusVite()){
                ((TortueRapide) leDessin.getLaTortue()).accelerer();
                
        }else if (e.getSource() == leDessin.getButNoir()){
                ((TortueCouleur) leDessin.getLaTortue()).setCouleur("black");
        }else if (e.getSource() == leDessin.getButRouge()){
                ((TortueCouleur) leDessin.getLaTortue()).setCouleur("red");
        }else if (e.getSource() == leDessin.getButVert()){
                ((TortueCouleur) leDessin.getLaTortue()).setCouleur("green");
        }else if (e.getSource() == leDessin.getButRose()){
                ((TortueCouleur) leDessin.getLaTortue()).setCouleur("magenta");
        }else if (e.getSource() == leDessin.getButBleu()){
                ((TortueCouleur) leDessin.getLaTortue()).setCouleur("blue");
        }else if (e.getSource() == leDessin.getButJaune()){
                ((TortueCouleur) leDessin.getLaTortue()).setCouleur("yellow");
        }
        
            
            
        
    
        
        
    }
}
