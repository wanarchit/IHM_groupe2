package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.MenuEvaluation;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 * Classe CtrlEvaluation
 * Controleur des évaluations des réalisations
 * Gère les options possibles lors de l'évaluation telles que rejouer par étape/
 * entièrement - annuler ou encore valider
 * 
 * @author Groupe 2
 */
public class CtrlEvaluation implements ActionListener {
    
    private ApplicationProf appli;
    private MenuEvaluation menuEval;
    private int compteur;
    private Eleve eleve;
    
    /**
     * Constructeur du controleur CtrlEvaluation
     * @param lAppli : application utilisée
     * @param leMenu : menu utilisée
     * @param monEleve : élève concerné 
     */
    public CtrlEvaluation(ApplicationProf lAppli, MenuEvaluation leMenu, Eleve monEleve){
        appli = lAppli;
        menuEval = leMenu;
        eleve = monEleve;
        compteur = 0;
    }

    @Override
    /**
     * Méthode actionPerformed
     * Permet d'appeler les fonctions correspondantes en fonction du bouton
     * choisi par l'utilisateur
     * Vérifie notamment les champs/conditions qui doivent être remplis
     * @param e : action event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == menuEval.getButRejouerEntier()){ //REJOUER EN ENTIER
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
            
        } else if (e.getSource() == menuEval.getButRejouerEtape()){ //REJOUER L ETAPE
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
        }else if (e.getSource() == menuEval.getButValider()){ //VALIDER L EVALUATION
            String commExo = "";
            String noteExo = "";
            Boolean validation = true;
            //VERIFIE QUE TOUS LES CHAMPS SONT SAISIS
            if (menuEval.getCommentaire().getText().isEmpty()){ //SI IL N Y A PAS DE COMMENTAIRE
                validation = false;
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "Vous devez saisir un commentaire", "Evaluation exercice", JOptionPane.INFORMATION_MESSAGE);
            }else{
                commExo = menuEval.getCommentaire().getText();
            }
            if (menuEval.getRadAcquis().isSelected()){
                noteExo = "Acquis";
            }else if (menuEval.getRadEnCours().isSelected()){
                noteExo = "En cours acquisition";
            }else if (menuEval.getRadNonAcquis().isSelected()){
                noteExo = "Non acquis";
            }else{ //AUCUNE NOTE CHOISIE
                validation = false;
                JOptionPane boiteDial = new JOptionPane();
                boiteDial.showMessageDialog(null, "Vous devez choisir une note", "Evaluation exercice", JOptionPane.INFORMATION_MESSAGE);
            }
            if(validation){
                if (noteExo.equals("Acquis")){
                    appli.majListEval(eleve,menuEval.getLaRea().getExercice());
                }
                eleve.getLesRealisations().get(eleve.getLesRealisations().indexOf(menuEval.getLaRea())).setACorriger(false);
                eleve.getLesRealisations().get(eleve.getLesRealisations().indexOf(menuEval.getLaRea())).setNote(noteExo);
                eleve.getLesRealisations().get(eleve.getLesRealisations().indexOf(menuEval.getLaRea())).setCommentaire(commExo);
                appli.annuleEval(); // Même action : pour retourner au menuProf   
            }
        }else if (e.getSource() == menuEval.getButAnnuler()){ //ANNULER L EVALUATION
            appli.annuleEval();
        }
    }
}