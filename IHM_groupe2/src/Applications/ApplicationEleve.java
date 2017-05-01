package Applications;

import ihm_groupe2.Inferface.Menu.Dessin;
import ihm_groupe2.Inferface.Menu.MenuConnexionEleve;
import ihm_groupe2.Inferface.Menu.MenuEleve;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import ihm_groupe2.Inferface.Menu.RejouerReaEleve;
import ihm_groupe2.Noyau_fonctionnel.Classe;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.sql.*;
/**
 * Classe ApplicationEleve : permet de gérer tous les éléments liés aux élèves
 * @author Paul
 */
public class ApplicationEleve {
    
    private MainFrame fenetreMain;
    
    private Classe maClasse;
    private Professeur leProf;
    private ArrayList<Eleve> lesEleves;
    private Eleve eleve,eleve2;
    private ArrayList<Realisation> mesDessins;
    private ArrayList<Classe> lesClasses;
    private ArrayList<Exercice> lesExercices;
    private Eleve eleveCo;
    
    
    public ApplicationEleve(MainFrame main){
        fenetreMain = main;
        
        //----------------------------------
        //----------------------------------
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:IHM_G2.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            ResultSet resProf=stmt.executeQuery("SELECT * FROM PROFESSEUR");
            //stmt.executeUpdate("INSERT INTO CLASSE (ID_Classe,Id_Professeur,Nom_Classe) VALUES (1,1,'CM2');");
            int i=1;
            while(resProf.next()){
                int idProf=resProf.getInt("ID_Professeur");
                String nomProf=resProf.getString("Nom_Professeur");
                String prenomProf=resProf.getString("Prenom_Professeur");
                String loginProf=resProf.getString("Login");
                String mdpProf=resProf.getString("Mot_De_Passe");
                ResultSet resClasses=stmt.executeQuery("SELECT * FROM CLASSE WHERE Id_Professeur="+idProf);
                System.out.println(i);
                i++;
            }


            
            
            
            
            
            
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        
        //----------------------------------
        //----------------------------------
        
        
        leProf = new Professeur("MrProf","12345","LeGrand","Didier");
        maClasse = new Classe("CM1",leProf);
        lesClasses = new ArrayList();
        lesClasses.add(maClasse);
        mesDessins = new ArrayList();
        ImageIcon imageEleve = new ImageIcon(getClass().getResource("/Applications/Images_eleves/eleve_f1.png"));
        eleve = new Eleve(maClasse,"Rousse","Delphine",imageEleve);
        ImageIcon imageEleve2 = new ImageIcon(getClass().getResource("/Applications/Images_eleves/eleve_g1.png"));
        eleve2 = new Eleve(maClasse,"Gand","Paul",imageEleve2);
        lesEleves = new ArrayList();
        lesEleves.add(eleve);
        lesEleves.add(eleve2);
        maClasse.ajoutEleve(eleve);
        maClasse.ajoutEleve(eleve2);
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
    
    
    public void chargerDonnees(){
        
    }
    
    public ArrayList<Eleve> getListeEleve(){
        return lesEleves;
    }
    
    public Eleve tryConnexion(String prenomEleveTryCo, String nomEleveTryCo){
        if (lesClasses.size()!=0){
            for(Classe cl:lesClasses){
                if (cl.getListEleveClasse().size()!=0){
                    for(Eleve el:cl.getListEleveClasse()){
                        if (el.getNomPersonne().equals(nomEleveTryCo)){
                            if (el.getPrenomPersonne().equals(prenomEleveTryCo)){
                                return el;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }
    
    
    public void seConnecter(Eleve lEleve){
        eleveCo = lEleve;
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,lesExercices.get(0),0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void annulerConnexion(){
        MenuPrincipal leMenuP = new MenuPrincipal(fenetreMain);
        fenetreMain.setContentPane(leMenuP);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public Eleve getEleveConnecte(){
        return eleveCo;
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
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,exoSuiv,0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheExercicePrecedant(Exercice exoEnCours){
        Exercice exoPrec = lesExercices.get(lesExercices.indexOf(exoEnCours)-1);
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,exoPrec,0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void annulerDessin(Exercice exoEnCours){
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,exoEnCours,0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void enregistrerDessin(Realisation laRealisation){
        eleveCo.addRealisation(laRealisation);
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,laRealisation.getExercice(),0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Permet de renvoyer le numéro de tentative suivant lors de la création d'une réalisation pour un exercice
     * @param exoEnCours : pour lequel l'élève fait une tentative de dessin
     * @return : le nouveau numéro de tentative de la nouvelle réalisation
     */
    public int getNumTentativeSuiv(Exercice exoEnCours){
        int numTentative = 1;
        for (Realisation rea:eleveCo.getLesRealisations()){
            if (rea.getExercice().equals(exoEnCours)){
                numTentative+=1;
            }
        }
        return numTentative;
    }
    
    public void rejouerListeActions(ArrayList<Commande> lesCommandes){
        for (Commande cmd:lesCommandes){
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
    }
    
    /**
     * Permet de renoyer la liste de toute les tentatives de l'élève pour un exercice
     * @param exoEnCours : exercice en cours d'affichage
     * @return listeTentExo : la liste des tentatives de l'élève pour cet exercice
     */
    public ArrayList<Realisation> getTentativeExo(Exercice exoEnCours){
        ArrayList<Realisation> listeTentExo = new ArrayList();
        for (Realisation rea:eleveCo.getLesRealisations()){
            if (rea.getExercice().equals(exoEnCours)){
                listeTentExo.add(rea);
            }
        }
        return listeTentExo;
    }
    
    public boolean tentativeSuivExist(Exercice exerciceActu, Realisation tentEnCours){
        if (tentEnCours.getNumeroTentative() < getTentativeExo(exerciceActu).size()){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean tentativePrecExist(Exercice exerciceActu, Realisation tentEnCours){
        if (tentEnCours.getNumeroTentative() != 1){
            return true;
        }else{
            return false;
        }
    }
    
    public void afficheTentativeSuivante(Exercice exoEnCours,Realisation tentEnCours){
        int numReaSuiv = tentEnCours.getNumeroTentative();
        MenuEleve leMenuEleve = new MenuEleve(eleve,this,exoEnCours,numReaSuiv);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheTentativePrecedante(Exercice exoEnCours, Realisation tentEnCours){
        int numReaSuiv = tentEnCours.getNumeroTentative()-2;
        
        MenuEleve leMenuEleve = new MenuEleve(eleve,this,exoEnCours,numReaSuiv);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    public void afficheRejouerRea(Realisation tentEnCours){
        new RejouerReaEleve(tentEnCours);
    }
    
}
