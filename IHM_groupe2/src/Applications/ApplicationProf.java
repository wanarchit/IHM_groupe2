package Applications;

import ihm_groupe2.Inferface.Menu.AfficheEleve;
import ihm_groupe2.Inferface.Menu.ListeClasse;
import ihm_groupe2.Inferface.Menu.ListeEleves;
import ihm_groupe2.Inferface.Menu.ListeExercices;
import ihm_groupe2.Inferface.Menu.MenuConnexionProf;
import ihm_groupe2.Inferface.Menu.MenuEvaluation;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import ihm_groupe2.Inferface.Menu.MenuProf;
import ihm_groupe2.Inferface.Menu.PanelAffExoArbre;
import ihm_groupe2.Inferface.Menu.PanelAffReaArbre;
import ihm_groupe2.Inferface.Menu.PanelCreerExo;
import ihm_groupe2.Inferface.Menu.PanelModifExo;
import ihm_groupe2.Noyau_fonctionnel.Classe;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueG;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
    private ListeClasse listeClasse;
    //private TortueG toruteG;
    //private TortueCouleur tortueCoul;
    //private TortueRapide tortueRap;
    private JPanel newPanelDroite,newPanelDroite2;
    
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
        //exo1.setModifiable(false);
        ImageIcon imageExo2 = new ImageIcon(getClass().getResource("Exercice2_image.png"));
        Exercice exo2 = new Exercice("Exercice 2","Vous devez faire ce dessin en 5 minutes avec la tortue rapide",2,imageExo2);
        ImageIcon imageExo3 = new ImageIcon(getClass().getResource("Exercice3_image.png"));
        Exercice exo3 = new Exercice("Exercice 3","Vous devez faire ce dessin en 15 minutes avec la tortue couleur",1,imageExo3);
        ImageIcon imageExo4 = new ImageIcon(getClass().getResource("Exercice4_image.png"));
        Exercice exo4 = new Exercice("Exercice 4","Vous devez faire ce dessin en 5 minutes avec la tortue couleur",2,imageExo4);
        lesExercices.add(exo1);
        lesExercices.add(exo2);
        lesExercices.add(exo3);
        lesExercices.add(exo4);
        
        //toruteG = new TortueG();
       // tortueRap = new TortueRapide();
       // tortueCoul = new TortueCouleur();
        Realisation maRea = new Realisation(1,"","",exo1);
        Commande maCommande10 = new Commande("Avance",exo1.getMaTortue());
        Commande maCommande11 = new Commande("Avance",exo1.getMaTortue());
        Commande maCommande12 = new Commande("Tourne",exo1.getMaTortue());
        Commande maCommande13 = new Commande("Avance",exo1.getMaTortue());
        Commande maCommande14 = new Commande("Tourne",exo1.getMaTortue());
        Commande maCommande15 = new Commande("Avance",exo1.getMaTortue());
        Commande maCommande16 = new Commande("N'écrit plus",exo1.getMaTortue());
        Commande maCommande17 = new Commande("Avance",exo1.getMaTortue());
        Commande maCommande18 = new Commande("Ecrit",exo1.getMaTortue());
        Commande maCommande19 = new Commande("Avance",exo1.getMaTortue());
        maRea.ajouterCommande(maCommande10);
        maRea.ajouterCommande(maCommande11);
        maRea.ajouterCommande(maCommande12);
        maRea.ajouterCommande(maCommande13);
        maRea.ajouterCommande(maCommande14);
        maRea.ajouterCommande(maCommande15);
        maRea.ajouterCommande(maCommande16);
        maRea.ajouterCommande(maCommande17);
        maRea.ajouterCommande(maCommande18);
        maRea.ajouterCommande(maCommande19);
        eleve.addRealisation(maRea);
        exo1.setModifiable(false);
        
        Realisation maRea2 = new Realisation(1,"","",exo2);
        Commande maCommande2 = new Commande("Avance",exo2.getMaTortue());
        maRea2.ajouterCommande(maCommande2);
        eleve.addRealisation(maRea2);
        exo2.setModifiable(false);
        
        Realisation maRea3 = new Realisation(1,"","",exo2);
        Commande maCommande3 = new Commande("Avance",exo2.getMaTortue());
        maRea3.ajouterCommande(maCommande3);
        eleve2.addRealisation(maRea3);
        
        Realisation maRea4 = new Realisation(1,"","",exo3);
        Commande maCommande4 = new Commande("Avance",exo3.getMaTortue());
        maRea4.ajouterCommande(maCommande4);
        eleve.addRealisation(maRea4);
        exo3.setModifiable(false);
        
        Realisation maRea5 = new Realisation(2,"","",exo2);
        Commande maCommande5 = new Commande("Avance",exo2.getMaTortue());
        maRea5.ajouterCommande(maCommande5);
        eleve.addRealisation(maRea5);
        
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
        newPanelDroite = new JPanel(new BorderLayout());
        newPanelDroite.add(listeExo,BorderLayout.CENTER);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public void afficheEleves(){
        leMenuProf.removeAll();
        //JLabel monLabel1 = new JLabel("Liste des élèves");
        listeEleve = new ListeEleves(lesEleves,this);
        //leMenuProf.setPanelDroite(newPanelDroite);
        newPanelDroite = new JPanel(new BorderLayout());
        newPanelDroite.add(listeEleve,BorderLayout.CENTER);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public void afficheClasses(){
        leMenuProf.removeAll();
        listeClasse = new ListeClasse(lesClasses,this);
        //JLabel monLabel1 = new JLabel("Liste des classes");
        newPanelDroite = new JPanel(new BorderLayout());
        newPanelDroite.add(listeClasse,BorderLayout.CENTER);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public ArrayList<Exercice> getListeExo(){
        return lesExercices;
    }
    
    public void affichelEleve(Eleve leEleve){
        leMenuProf.removeAll();
        AfficheEleve affEleve = new AfficheEleve(leEleve,lesExercices,this);
        
        JPanel newPanelDroite1 = new JPanel(new BorderLayout());
        newPanelDroite1.add(affEleve.getArbre());
        newPanelDroite2 = new JPanel();

        newPanelDroite = new JPanel(new BorderLayout());   
        newPanelDroite.add(newPanelDroite1,BorderLayout.WEST);
        newPanelDroite.add(newPanelDroite2,BorderLayout.CENTER);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public void affichelaClasse(Classe laClasse){
        leMenuProf.removeAll();
        //JLabel monLabel1 = new JLabel("Liste des élèves");
        listeEleve = new ListeEleves(laClasse.getListEleveClasse(),this);
        //leMenuProf.setPanelDroite(newPanelDroite);
        newPanelDroite = new JPanel(new BorderLayout());
        newPanelDroite.add(listeEleve,BorderLayout.CENTER);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public void seDeconnecter(){
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous enregistrer les modifications avant de vous déconnecter ?", "Déconnexion", 
                    JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(option != JOptionPane.NO_OPTION && 
            option != JOptionPane.CANCEL_OPTION && 
            option != JOptionPane.CLOSED_OPTION){
            // ENREGISTRER LES INFO DANS LA BDD !!!
            MenuPrincipal leMenuP = new MenuPrincipal(fenetreMain);
            fenetreMain.setContentPane(leMenuP);
            fenetreMain.repaint();
            fenetreMain.revalidate();
        }else if (option != JOptionPane.YES_OPTION && 
            option != JOptionPane.CANCEL_OPTION && 
            option != JOptionPane.CLOSED_OPTION){
            MenuPrincipal leMenuP = new MenuPrincipal(fenetreMain);
            fenetreMain.setContentPane(leMenuP);
            fenetreMain.repaint();
            fenetreMain.revalidate();
        }            
    }
    
    public void annulerConnexion(){
        MenuPrincipal leMenuP = new MenuPrincipal(fenetreMain);
        fenetreMain.setContentPane(leMenuP);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheExoEleve(Exercice lExo){
        newPanelDroite.remove(newPanelDroite2);
        newPanelDroite2 = new PanelAffExoArbre(lExo);
        newPanelDroite.add(newPanelDroite2,BorderLayout.CENTER);
        leMenuProf.revalidate();
    }
    
    public void afficheReaEleve(Realisation laRea){
        newPanelDroite.remove(newPanelDroite2);
        newPanelDroite2 = new PanelAffReaArbre(laRea,this);
        newPanelDroite.add(newPanelDroite2,BorderLayout.CENTER);
        leMenuProf.revalidate();
    }
    
    public void evaluerRealisation(Realisation laRea){
        MenuEvaluation evalReaP = new MenuEvaluation(this,laRea);
        fenetreMain.setContentPane(evalReaP);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void annuleEval(){
        leMenuProf = new MenuProf(profCo,this);
        fenetreMain.setContentPane(leMenuProf);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }

    
    
}
