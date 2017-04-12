package Applications;

import ihm_groupe2.Inferface.Menu.ListeEleves;
import ihm_groupe2.Inferface.Menu.ListeExercices;
import ihm_groupe2.Inferface.Menu.MenuConnexionProf;
import ihm_groupe2.Inferface.Menu.MenuProf;
import ihm_groupe2.Inferface.Menu.PanelCreerExo;
import ihm_groupe2.Inferface.Menu.PanelModifExo;
import ihm_groupe2.Noyau_fonctionnel.Classe;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Classe ApplicationProf : permet de gérer tous les éléments liés aux professeurs
 * @author Paul
 */
public class ApplicationProf {
    
    private MainFrame fenetreMain;
    private Classe maClasse,maClasse2;
    private Professeur prof,prof2;
    private ArrayList<Professeur> lesProfs;
    private ArrayList<Eleve> lesEleves;
    private Eleve eleve,eleve2,eleve3;
    private ArrayList<Realisation> mesDessins;
    private ArrayList<Classe> lesClasses;
    private ArrayList<Exercice> lesExercices;
    private Professeur profCo;
    private MenuProf leMenuProf;
    private ListeExercices listeExo;
    private ListeEleves listeEleve;
    
    public ApplicationProf(MainFrame main){
        fenetreMain = main;
        lesEleves = new ArrayList();
        lesProfs = new ArrayList();
        prof = new Professeur("Prof","12345","LeGrand","Didier");
        prof2 = new Professeur("Prof2","12345","LePetit","Bernard");
        lesProfs.add(prof);
        lesProfs.add(prof2);
        maClasse = new Classe("CM1",prof);
        maClasse2 = new Classe("CM2",prof2);
        lesClasses = new ArrayList();
        lesClasses.add(maClasse);
        lesClasses.add(maClasse2);
        mesDessins = new ArrayList();
        eleve = new Eleve(maClasse,"Rousse","Delphine");
        eleve2 = new Eleve(maClasse2,"Gand","Paul");
        eleve3 = new Eleve(maClasse2,"Conrady","Marin");
        lesEleves.add(eleve);
        lesEleves.add(eleve2);
        lesEleves.add(eleve3);
        maClasse.ajoutEleve(eleve);
        maClasse2.ajoutEleve(eleve2);
        maClasse2.ajoutEleve(eleve3);
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
        
        MenuConnexionProf menuCoProf = new MenuConnexionProf(this);
        fenetreMain.setContentPane(menuCoProf);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public Professeur tryConnexion(String loginProfTryCo, String mdpProfTryCo){
        if (lesProfs.size()!=0){
            for(Professeur pr:lesProfs){
                if (pr.getLogin().equals(loginProfTryCo)){
                    if (pr.getMotdePasse().equals(mdpProfTryCo)){
                        return pr;
                    }
                }
            }
        }
        return null;
    }
    
    public void seConnecter(Professeur leProf){
        profCo = leProf;
        leMenuProf = new MenuProf(profCo,this);
        fenetreMain.setContentPane(leMenuProf);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void creerExercice(){
        leMenuProf.removeAll();
        leMenuProf.setPanelDroite(new PanelCreerExo(this));
        leMenuProf.revalidate();
    }
    
    public void modifExercice(Exercice lExo){
        leMenuProf.removeAll();
        leMenuProf.setPanelDroite(new PanelModifExo(lExo,this));
        leMenuProf.revalidate();
    }
    
    public void afficheExercices(){
        leMenuProf.removeAll();
        listeExo = new ListeExercices(lesExercices,this);
        JPanel newPanelDroite = new JPanel();
        newPanelDroite.add(listeExo);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public void afficheEleves(){
        leMenuProf.removeAll();
        //JLabel monLabel1 = new JLabel("Liste des élèves");
        listeEleve = new ListeEleves(lesEleves,this);
        //leMenuProf.setPanelDroite(newPanelDroite);
        JPanel newPanelDroite = new JPanel();
        newPanelDroite.add(listeEleve);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public void afficheClasses(){
        leMenuProf.removeAll();
        JLabel monLabel1 = new JLabel("Liste des classes");
        JPanel newPanelDroite = new JPanel();
        newPanelDroite.add(monLabel1);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public ArrayList<Exercice> getListeExo(){
        return lesExercices;
    }
    
    public void affichelEleve(Eleve leEleve){
        leMenuProf.removeAll();
        JPanel testPanel = new JPanel();
        JLabel monLabel = new JLabel("Prénom : "+leEleve.getPrenomPersonne()+" / Nom : "+leEleve.getNomPersonne()+" / Classe : "+leEleve.getLaClasse().getNomClasse());
        testPanel.add(monLabel);
        leMenuProf.setPanelDroite(testPanel);
        leMenuProf.revalidate();
    }
    
    
}
