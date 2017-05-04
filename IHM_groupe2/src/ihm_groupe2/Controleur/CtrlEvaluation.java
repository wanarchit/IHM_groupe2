package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.MenuEvaluation;
import ihm_groupe2.Noyau_fonctionnel.Canvas;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*; 
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Delphine
 */
public class CtrlEvaluation implements ActionListener {
    
    private ApplicationProf appli;
    private MenuEvaluation menuEval;
    private int compteur;
    private Eleve eleve;
    
    public CtrlEvaluation(ApplicationProf lAppli, MenuEvaluation leMenu, Eleve monEleve){
        appli = lAppli;
        menuEval = leMenu;
        eleve = monEleve;
        compteur = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuEval.getButRejouerEntier()){
            menuEval.getLaRea().getExercice().getMaTortue().reset();
            if (menuEval.getLaRea().getExercice().getMaTortue().getClass() == TortueCouleur.class){
                ((TortueCouleur)menuEval.getLaRea().getExercice().getMaTortue()).setCouleur("black");
            }else if(menuEval.getLaRea().getExercice().getMaTortue().getClass() == TortueRapide.class){
                ((TortueRapide)menuEval.getLaRea().getExercice().getMaTortue()).setVitesse(1);
            }
            for (Commande cmd:menuEval.getLaRea().getListeCommande()){
                appli.doAction(cmd);
            }
            compteur = -1;
            
        } else if (e.getSource() == menuEval.getButRejouerEtape()){
            if (compteur == -1){
                menuEval.getLaRea().getExercice().getMaTortue().reset();
                if (menuEval.getLaRea().getExercice().getMaTortue().getClass() == TortueCouleur.class){
                    ((TortueCouleur)menuEval.getLaRea().getExercice().getMaTortue()).setCouleur("black");
                }else if(menuEval.getLaRea().getExercice().getMaTortue().getClass() == TortueRapide.class){
                    ((TortueRapide)menuEval.getLaRea().getExercice().getMaTortue()).setVitesse(1);
                }
                compteur = 0;
            }else if (compteur != menuEval.getLaRea().getListeCommande().size()){
                appli.doAction(menuEval.getLaRea().getListeCommande().get(compteur));
                compteur += 1;
            }else{
                menuEval.getLaRea().getExercice().getMaTortue().reset();
                if (menuEval.getLaRea().getExercice().getMaTortue().getClass() == TortueCouleur.class){
                    ((TortueCouleur)menuEval.getLaRea().getExercice().getMaTortue()).setCouleur("black");
                }else if(menuEval.getLaRea().getExercice().getMaTortue().getClass() == TortueRapide.class){
                    ((TortueRapide)menuEval.getLaRea().getExercice().getMaTortue()).setVitesse(1);
                }
                compteur = 0;
            }
        }else if (e.getSource() == menuEval.getButValider()){
            String commExo = "";
            String noteExo = "";
            Boolean validation = true;
            if (menuEval.getCommentaire().getText().isEmpty()){
                commExo = "Pas de commentaire de la par du professeur";
            }else{
                commExo = menuEval.getCommentaire().getText();
            }
            if (menuEval.getRadAcquis().isSelected()){
                noteExo = "Acquis";
            }else if (menuEval.getRadEnCours().isSelected()){
                noteExo = "En cours acquisition";
            }else if (menuEval.getRadNonAcquis().isSelected()){
                noteExo = "Non acquis";
            }else{
                validation = false;
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "Vous devez choisir une note", "Evaluation exercice", JOptionPane.INFORMATION_MESSAGE);
            }
            if(validation){
                eleve.getLesRealisations().get(eleve.getLesRealisations().indexOf(menuEval.getLaRea())).setACorriger(false);
                eleve.getLesRealisations().get(eleve.getLesRealisations().indexOf(menuEval.getLaRea())).setNote(noteExo);
                eleve.getLesRealisations().get(eleve.getLesRealisations().indexOf(menuEval.getLaRea())).setCommentaire(commExo);
                //System.out.println("L'évaluation de la réalisation à bien été effectuée");
                appli.annuleEval(); // Même action : pour retourner au menuProf
                
            }
        }else if (e.getSource() == menuEval.getButAnnuler()){
            appli.annuleEval();
        }
    }
    
   
  
}
    

