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
        //Exercice exo1 = new Exercice();
        
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
        MenuEleve leMenuEleve = new MenuEleve(eleve,this);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public Eleve getEleveConnecte(){
        return eleve;
    }
    
    public void faireExercice(){
        Dessin leDessin = new Dessin(this);
        fenetreMain.setContentPane(leDessin);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
}
