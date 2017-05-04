package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Menu.Dessin;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

/**
 *
 * @author Groupe 2
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
            
        }else if(e.getSource() == leDessin.getButAnnuler()){

            if (leDessin.getNewRealisation().getListeCommande().size() != 0){
                leDessin.getNewRealisation().supprimeDerniereCommande();
                leDessin.getLaTortue().reset();
                if (leDessin.getLaTortue().getClass() == TortueCouleur.class){
                    ((TortueCouleur)leDessin.getLaTortue()).setCouleur("black");
                }else if(leDessin.getLaTortue().getClass() == TortueRapide.class){
                    ((TortueRapide)leDessin.getLaTortue()).setVitesse(1);
                }
                
                appli.rejouerListeActions(leDessin.getNewRealisation().getListeCommande());
                leDessin.RefreshListAction();
                if (leDessin.getLaTortue().getDirection() == 0){        // vers la droite
                    leDessin.getButAvancer().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/droite.png")));
                }else if (leDessin.getLaTortue().getDirection() == 1){  // vers le bas
                    leDessin.getButAvancer().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/reculer.png")));
                }else if (leDessin.getLaTortue().getDirection() == 2){      // vers la gauche
                    leDessin.getButAvancer().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/gauche.png")));
                }else{      // vers le haut
                    leDessin.getButAvancer().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/avancer.png")));
                }
                if (!leDessin.getLaTortue().enTrace()){
                    leDessin.getButEcrire().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/ecrit.png")));
                }else{
                    leDessin.getButEcrire().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/ecrit_pas.png")));
                }
            }

            
        }else if(e.getSource() == leDessin.getButValidation()){
            appli.enregistrerDessin(leDessin.getNewRealisation());
            
        }else if (e.getSource() == leDessin.getButAvancer()){
            leDessin.getLaTortue().avancer();
            Commande avance = new Commande("Avance",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(avance);
            leDessin.RefreshListAction();
        }else if (e.getSource() == leDessin.getButTourner()){
            leDessin.getLaTortue().tourner();
            Commande tourne = new Commande("Tourne",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(tourne);
            leDessin.RefreshListAction();

            if (leDessin.getLaTortue().getDirection() == 0){        // vers la droite
                leDessin.getButAvancer().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/droite.png")));
            }else if (leDessin.getLaTortue().getDirection() == 1){  // vers le bas
                leDessin.getButAvancer().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/reculer.png")));
            }else if (leDessin.getLaTortue().getDirection() == 2){      // vers la gauche
                leDessin.getButAvancer().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/gauche.png")));
            }else{      // vers le haut
                leDessin.getButAvancer().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/avancer.png")));
            }

        }else if (e.getSource() == leDessin.getButEcrire()){
            leDessin.getLaTortue().tracer(!leDessin.getLaTortue().enTrace());
            
            if (!leDessin.getLaTortue().enTrace()){
                Commande ecritPas = new Commande("N'écrit plus",leDessin.getLaTortue());
                leDessin.getNewRealisation().ajouterCommande(ecritPas);
                leDessin.getButEcrire().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/ecrit.png")));
            }else{
                Commande ecrit = new Commande("Ecrit",leDessin.getLaTortue());
                leDessin.getNewRealisation().ajouterCommande(ecrit);
                leDessin.getButEcrire().setIcon(new ImageIcon(getClass().getResource("/Applications/images_boutons/ecrit_pas.png")));
            }

            leDessin.RefreshListAction();
        
        }else if (e.getSource() == leDessin.getButMoinsVite()){
            ((TortueRapide) leDessin.getLaTortue()).ralentir();
            Commande ralenti = new Commande("Ralentie",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(ralenti);
            leDessin.RefreshListAction();
        }else if (e.getSource() == leDessin.getButPlusVite()){
            ((TortueRapide) leDessin.getLaTortue()).accelerer();
            Commande accelere = new Commande("Accélère",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(accelere);
            leDessin.RefreshListAction();   
        }else if (e.getSource() == leDessin.getButNoir()){
            ((TortueCouleur) leDessin.getLaTortue()).setCouleur("black");
            Commande noir = new Commande("Ecrit en noir",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(noir);
            leDessin.RefreshListAction();
        }else if (e.getSource() == leDessin.getButRouge()){
            ((TortueCouleur) leDessin.getLaTortue()).setCouleur("red");
            Commande rouge = new Commande("Ecrit en rouge",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(rouge);
            leDessin.RefreshListAction();
        }else if (e.getSource() == leDessin.getButVert()){
            ((TortueCouleur) leDessin.getLaTortue()).setCouleur("green");
            Commande vert = new Commande("Ecrit en vert",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(vert);
            leDessin.RefreshListAction();
        }else if (e.getSource() == leDessin.getButRose()){
            ((TortueCouleur) leDessin.getLaTortue()).setCouleur("magenta");
            Commande rose = new Commande("Ecrit en rose",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(rose);
            leDessin.RefreshListAction();
        }else if (e.getSource() == leDessin.getButBleu()){
            ((TortueCouleur) leDessin.getLaTortue()).setCouleur("blue");
            Commande bleu = new Commande("Ecrit en bleu",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(bleu);
            leDessin.RefreshListAction();
        }else if (e.getSource() == leDessin.getButJaune()){
            ((TortueCouleur) leDessin.getLaTortue()).setCouleur("yellow");
            Commande jaune = new Commande("Ecrit en jaune",leDessin.getLaTortue());
            leDessin.getNewRealisation().ajouterCommande(jaune);
            leDessin.RefreshListAction();
        }
   
    }
}
