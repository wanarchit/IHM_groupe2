package Applications;

import ihm_groupe2.Inferface.Dessin.Dessin;
import ihm_groupe2.Inferface.Menu.MenuConnexionEleve;
import ihm_groupe2.Inferface.Menu.MenuEleve;
import ihm_groupe2.Noyau_fonctionnel.Classe;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Classe ApplicationEleve : permet de gérer tous les éléments liés aux élèves
 * @author Paul
 */
public class ApplicationEleve {
    
    private MainFrame fenetreMain;
    
    private Classe maClasse;
    private Professeur leProf;
    private ArrayList<Eleve> LesEleves;
    private Eleve eleve;
    private ArrayList<Realisation> mesDessins;
    private ArrayList<Classe> lesClasses;
    private ArrayList<Exercice> lesExercices;
    
    
    public ApplicationEleve(MainFrame main){
        fenetreMain = main;
        LesEleves = new ArrayList();
        leProf = new Professeur("MrProf","12345","LeGrand","Didier");
        maClasse = new Classe("CM1",leProf);
        lesClasses = new ArrayList();
        lesClasses.add(maClasse);
        mesDessins = new ArrayList();
        eleve = new Eleve(maClasse,"Rousse","Delphine");
        maClasse.ajoutEleve(eleve);
        lesExercices = new ArrayList();
        ImageIcon imageExo = new ImageIcon(getClass().getResource("Exercice1_image.png"));
        Exercice exo1 = new Exercice("Exercice 1","Vous devez faire ce dessin en 10 minutes avec la tortue normale",0,imageExo);
        ImageIcon imageExo2 = new ImageIcon(getClass().getResource("Exercice2_image.png"));
        Exercice exo2 = new Exercice("Exercice 2","Vous devez faire ce dessin en 5 minutes avec la tortue rapide",2,imageExo2);
        ImageIcon imageExo3 = new ImageIcon(getClass().getResource("Exercice3_image.png"));
        Exercice exo3 = new Exercice("Exercice 3","Vous devez faire ce dessin en 15 minutes avec la tortue couleur",1,imageExo3);
        lesExercices.add(exo1);
        lesExercices.add(exo2);
        lesExercices.add(exo3);
        
        MenuConnexionEleve menuCoEleve = new MenuConnexionEleve(this);
        fenetreMain.setContentPane(menuCoEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public MainFrame getMainFrame(){
        return fenetreMain;
    }
    
    public void chargerDonnees(){
        
    }
    
    public boolean tryConnexion(String prenomEleveTryCo, String nomEleveTryCo){
        if (lesClasses.size()!=0){
            for(Classe cl:lesClasses){
                if (cl.getListEleveClasse().size()!=0){
                    for(Eleve el:cl.getListEleveClasse()){
                        if (el.getNomPersonne().equals(nomEleveTryCo)){
                            if (el.getPrenomPersonne().equals(prenomEleveTryCo)){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
    
    public void seConnecter(){
        MenuEleve leMenuEleve = new MenuEleve(eleve,this,lesExercices.get(0));
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public Eleve getEleveConnecte(){
        return eleve;
    }
    
    public void faireExercice(Exercice exerciceActu){
        Dessin leDessin = new Dessin(this,exerciceActu);
        fenetreMain.setContentPane(leDessin);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public boolean exerciceSuivExist(Exercice exerciceActu){
        if (lesExercices.indexOf(exerciceActu) < lesExercices.size()-1){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean exercicePrecExist(Exercice exerciceActu){
        if (lesExercices.indexOf(exerciceActu) != 0){
            return true;
        }else{
            return false;
        }
    }
    
    public void afficheExerciceSuivant(Exercice exoEnCours){
        Exercice exoSuiv = lesExercices.get(lesExercices.indexOf(exoEnCours)+1);
        MenuEleve leMenuEleve = new MenuEleve(eleve,this,exoSuiv);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheExercicePrecedant(Exercice exoEnCours){
        Exercice exoPrec = lesExercices.get(lesExercices.indexOf(exoEnCours)-1);
        MenuEleve leMenuEleve = new MenuEleve(eleve,this,exoPrec);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void annulerDessin(Exercice exoEnCours){
        MenuEleve leMenuEleve = new MenuEleve(eleve,this,exoEnCours);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
}
