package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.MenuEvaluation;
import ihm_groupe2.Noyau_fonctionnel.Canvas;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Delphine
 */
public class CtrlEvaluation implements ActionListener {
    
    private ApplicationProf appli;
    private MenuEvaluation menuEval;
    
    public CtrlEvaluation(ApplicationProf lAppli, MenuEvaluation leMenu){
        appli = lAppli;
        menuEval = leMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuEval.getButRejouer()){
            menuEval.getLaRea().getExercice().getMaTortue().reset();
            if (menuEval.getLaRea().getExercice().getMaTortue().getClass() == TortueCouleur.class){
                ((TortueCouleur)menuEval.getLaRea().getExercice().getMaTortue()).setCouleur("black");
            }else if(menuEval.getLaRea().getExercice().getMaTortue().getClass() == TortueRapide.class){
                ((TortueRapide)menuEval.getLaRea().getExercice().getMaTortue()).setVitesse(1);
            }
            
                for (Commande cmd:menuEval.getLaRea().getListeCommande()){
                    if(cmd.getCommande().equals("Avance")){
                        cmd.getTortue().avancer();
                    }else if(cmd.getCommande().equals("Tourne")){
                        cmd.getTortue().tourner();
                    }else if(cmd.getCommande().equals("N'écrit plus")){
                        cmd.getTortue().tracer(false);
                    }else if(cmd.getCommande().equals("Ecrit")){
                        cmd.getTortue().tracer(true);
                    }else if(cmd.getCommande().equals("Ralentie")){
                        ((TortueRapide) cmd.getTortue()).ralentir();
                    }else if(cmd.getCommande().equals("Accélère")){
                        ((TortueRapide) cmd.getTortue()).accelerer();
                    }else if(cmd.getCommande().equals("Ecrit en noir")){
                        ((TortueCouleur) cmd.getTortue()).setCouleur("black");
                    }else if(cmd.getCommande().equals("Ecrit en rouge")){
                        ((TortueCouleur) cmd.getTortue()).setCouleur("red");
                    }else if(cmd.getCommande().equals("Ecrit en vert")){
                        ((TortueCouleur) cmd.getTortue()).setCouleur("green");
                    }else if(cmd.getCommande().equals("Ecrit en rose")){
                        ((TortueCouleur) cmd.getTortue()).setCouleur("magenta");
                    }else if(cmd.getCommande().equals("Ecrit en bleu")){
                        ((TortueCouleur) cmd.getTortue()).setCouleur("blue");
                    }else if(cmd.getCommande().equals("Ecrit en jaune")){
                        ((TortueCouleur) cmd.getTortue()).setCouleur("yellow");
                    }
                }
                
        }else if (e.getSource() == menuEval.getButValider()){
            System.out.println("Valider");
        }else if (e.getSource() == menuEval.getButAnnuler()){
            appli.annuleEval();
        }
    }
  
}
    

