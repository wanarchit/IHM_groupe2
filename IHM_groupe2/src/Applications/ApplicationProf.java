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
import ihm_groupe2.Modele.ResetBDD;
import ihm_groupe2.Noyau_fonctionnel.Classe;
import ihm_groupe2.Noyau_fonctionnel.Commande;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Evaluation;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import ihm_groupe2.Noyau_fonctionnel.TortueCouleur;
import ihm_groupe2.Noyau_fonctionnel.TortueRapide;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Classe ApplicationProf : permet de gérer tous les éléments liés aux professeurs
 * @author Groupe 2
 */
public class ApplicationProf {
    
    private MainFrame fenetreMain;
    private Classe maClasse,maClasse2;
    private Professeur prof,prof2;
    private ArrayList<Professeur> lesProfs;
    private ArrayList<Eleve> lesEleves;
    
    private Eleve[] lesEleves2;
    
    private Eleve eleve,eleve2,eleve3;
    private ArrayList<Realisation> mesDessins;
    private ArrayList<Classe> lesClasses;
    private ArrayList<Exercice> lesExercices;
    private Professeur leProf;
    private Professeur profCo;
    private MenuProf leMenuProf;
    private ListeExercices listeExo;
    private ListeEleves listeEleve;
    private ListeClasse listeClasse;
    private Exercice exo;
    private Realisation maRea; 
    private Commande maCmd;
    private ArrayList<Evaluation> lesEvals;
    
    //private TortueG toruteG;
    //private TortueCouleur tortueCoul;
    //private TortueRapide tortueRap;
    private JPanel newPanelDroite,newPanelDroite2;
    
    public ApplicationProf(MainFrame main){
        fenetreMain = main;

        Connection c = null;
        Statement stmt = null;
        Statement stmt2=null;
        Statement stmt3=null;
        Statement stmt4 = null;
        Statement stmt5 = null;
        Statement stmt6 = null;
        Statement stmt7 = null;
        Statement stmt8 = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:IHM_G2.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            stmt2 = c.createStatement();
            stmt3 = c.createStatement();
            stmt4 = c.createStatement();
            stmt5 = c.createStatement();
            stmt6 = c.createStatement();
            stmt7 = c.createStatement();
            stmt8 = c.createStatement();
            ResultSet resProf=stmt.executeQuery("SELECT * FROM PROFESSEUR");
            lesProfs=new ArrayList();
            lesClasses=new ArrayList();
            ResultSet resNbEleve=stmt8.executeQuery("SELECT COUNT(*) AS nbEleve FROM ELEVE");
            int nbEleves = 0;
            while(resNbEleve.next()){
                nbEleves = resNbEleve.getInt("nbEleve");
            }
            lesEleves2= new Eleve[nbEleves];
            lesExercices=new ArrayList();
            lesEvals=new ArrayList();
            ResultSet resExercices=stmt4.executeQuery("SELECT * FROM EXERCICE");
            while(resExercices.next()){
                String imageExercice=resExercices.getString("Image_Exo");
                try{
                    ImageIcon imageExo = new ImageIcon(getClass().getResource(imageExercice));
                    String nomExo=resExercices.getString("Nom_Exo");
                    String comExo=resExercices.getString("Commentaire_Exo");
                    int tortueExo=resExercices.getInt("Tortue_Exo");
                    exo = new Exercice(nomExo,comExo,tortueExo,imageExo);
                    lesExercices.add(exo);
                }catch ( Exception exp ) {
                    ImageIcon imageExo = new ImageIcon(getClass().getResource("/Images/Exercice_erreur.PNG"));
                    String nomExo=resExercices.getString("Nom_Exo");
                    String comExo=resExercices.getString("Commentaire_Exo");
                    int tortueExo=resExercices.getInt("Tortue_Exo");
                    exo = new Exercice(nomExo,comExo,tortueExo,imageExo);
                    lesExercices.add(exo);
                }  
            }
            
            while(resProf.next()){
                int idProf=resProf.getInt("ID_Professeur");
                String nomProf=resProf.getString("Nom_Professeur");
                String prenomProf=resProf.getString("Prenom_Professeur");
                String loginProf=resProf.getString("Login");
                String mdpProf=resProf.getString("Mot_De_Passe");
                ResultSet resClasses=stmt2.executeQuery("SELECT * FROM CLASSE WHERE Id_Professeur="+idProf);
                leProf=new Professeur(loginProf,mdpProf,nomProf,prenomProf);
                lesProfs.add(leProf);
                while(resClasses.next()){
                    int idClasse=resClasses.getInt("ID_Classe");
                    String nomClasse=resClasses.getString("Nom_Classe");
                    maClasse = new Classe(nomClasse,leProf);
                    lesClasses.add(maClasse);
                    ResultSet resEleves=stmt3.executeQuery("SELECT * FROM ELEVE WHERE Id_Classe="+idClasse);
                    while(resEleves.next()){
                        String nomEleve=resEleves.getString("Nom_Eleve");
                        String prenomEleve=resEleves.getString("Prenom_Eleve");
                        String iconeEleve=resEleves.getString("Icon_Eleve");
                        int idEleve=resEleves.getInt("ID_Eleve");
                        ImageIcon imageEleve = new ImageIcon(getClass().getResource(iconeEleve));
                        eleve=new Eleve(maClasse,nomEleve,prenomEleve,imageEleve);
                        lesEleves2[idEleve-1]=eleve;
                        maClasse.ajoutEleve(eleve);
                        mesDessins = new ArrayList();
                        ResultSet resRealisation=stmt5.executeQuery("SELECT * FROM REALISATION WHERE Id_Eleve="+idEleve);
                        while(resRealisation.next()){
                            int idRea=resRealisation.getInt("ID_Realisation");
                            int idExo=resRealisation.getInt("Id_Exo");
                            int numRea=resRealisation.getInt("Numero_Tentative");
                            String comRea=resRealisation.getString("Commentaire_Realisation");
                            String noteRea=resRealisation.getString("Note_Realisation");
                            maRea = new Realisation(numRea,comRea,noteRea,lesExercices.get(idExo-1));
                            if (noteRea.equals("Non acquis") || noteRea.equals("Acquis") || noteRea.equals("En cours acquisition")){
                                maRea.setACorriger(false);
                            }
                            ResultSet resCmd=stmt6.executeQuery("SELECT * FROM UTILISE JOIN COMMANDES ON UTILISE.Id_Commande=COMMANDES.ID_Commande WHERE Id_Realisation="+idRea);
                            while(resCmd.next()){
                                String nomCmd = resCmd.getString("Nom_Commande");
                                maCmd = new Commande(nomCmd,lesExercices.get(idExo-1).getMaTortue());
                                maRea.ajouterCommande(maCmd);
                            }  
                            eleve.addRealisation(maRea);
                            lesExercices.get(idExo-1).setModifiable(false);
                        }
                    }
                }
            }
            lesEleves=new ArrayList();
            for (Eleve ele : lesEleves2){
                lesEleves.add(ele);
            }
            
            ResultSet resEval=stmt7.executeQuery("SELECT * FROM A_valide");
            while(resEval.next()){
                int intVal = resEval.getInt("Validation_Exo");
                int idExo2 = resEval.getInt("Id_Exo");
                int idEl2 = resEval.getInt("Id_Eleve");
                Boolean isVal = false;
                if (intVal == 1){
                    isVal = true;
                }
                Evaluation monEval = new Evaluation(lesEleves.get(idEl2-1),lesExercices.get(idExo2-1),isVal);
                lesEvals.add(monEval);
            }        
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
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
        listeEleve = new ListeEleves(lesEleves,this);
        newPanelDroite = new JPanel(new BorderLayout());
        newPanelDroite.add(listeEleve,BorderLayout.CENTER);
        leMenuProf.setPanelDroite(newPanelDroite);
        leMenuProf.revalidate();
    }
    
    public void afficheClasses(){
        leMenuProf.removeAll();
        listeClasse = new ListeClasse(lesClasses,this);
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
    
    public void majListEval(Eleve eleveEval, Exercice exoEnEval){
        for(Evaluation ev : lesEvals){
            if (ev.getMonEleve().equals(eleveEval) && ev.getMonExercice().equals(exoEnEval)){
                ev.setValidation(true);
            }
        }
    }
    
    public void creaNewEval(Exercice newExo){
        for(Eleve el : lesEleves){
            Evaluation monEval = new Evaluation(el,newExo,false);
            lesEvals.add(monEval);
        }
    }
    
    public void affichelaClasse(Classe laClasse){
        leMenuProf.removeAll();
        listeEleve = new ListeEleves(laClasse.getListEleveClasse(),this);
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
            enregistrementBDD();
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
    
    public void afficheReaEleve(Realisation laRea, Eleve lEleve){
        newPanelDroite.remove(newPanelDroite2);
        newPanelDroite2 = new PanelAffReaArbre(laRea,this,lEleve);
        newPanelDroite.add(newPanelDroite2,BorderLayout.CENTER);
        leMenuProf.revalidate();
    }
    
    public void evaluerRealisation(Realisation laRea, Eleve lEleve){
        MenuEvaluation evalReaP = new MenuEvaluation(this,laRea,lEleve);
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
    
    public void doAction(Commande cmd){
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
    
    public void enregistrementBDD(){
        FenetreLoad progress = new FenetreLoad("Mise à jour de la BDD en cours ...");
        try {
        SwingUtilities.invokeLater(new Runnable() {
          @Override
          public void run() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:IHM_G2.db");
            ResetBDD resetdb = new ResetBDD();
            resetdb.dbReset();
            Statement stmtAdd = null;
            stmtAdd = c.createStatement();

            int idRea = 0;
            int cptTemps = 0;
            for (Eleve el : lesEleves){
                cptTemps+=5;
                int idEl = lesEleves.indexOf(el)+1;
                for (Realisation rea : el.getLesRealisations()){
                    idRea++;
                    int idExRea = lesExercices.indexOf(rea.getExercice())+1;
                    stmtAdd.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES ("+
                    idRea+",'"+rea.getNote()+"',"+idEl+","+idExRea+","+rea.getNumeroTentative()+",'"+rea.getCommentaire()+"');");
                    
                    int i=0;
                    for (Commande cmd : rea.getListeCommande()){
                        i++;
                        int idCmd = 0;
                        if (cmd.getCommande().equals("Avance")){
                            idCmd = 1;
                        }else if (cmd.getCommande().equals("Tourne")){
                            idCmd = 2;
                        }else if (cmd.getCommande().equals("N'ecrit plus")){
                            idCmd = 3;
                        }else if (cmd.getCommande().equals("Ecrit")){
                            idCmd = 4;
                        }else if (cmd.getCommande().equals("Ralentie")){
                            idCmd = 5;
                        }else if (cmd.getCommande().equals("Accélère")){
                            idCmd = 6;
                        }else if (cmd.getCommande().equals("Ecrit en noir")){
                            idCmd = 7;
                        }else if (cmd.getCommande().equals("Ecrit en rouge")){
                            idCmd = 8;
                        }else if (cmd.getCommande().equals("Ecrit en rose")){
                            idCmd = 9;
                        }else if (cmd.getCommande().equals("Ecrit en jaune")){
                            idCmd = 10;
                        }else if (cmd.getCommande().equals("Ecrit en vert")){
                            idCmd = 11;
                        }else if (cmd.getCommande().equals("Ecrit en bleu")){
                            idCmd = 12;
                        }
                        stmtAdd.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES ("+
                                idCmd+","+idRea+","+i+");");
                    }
                }
                                    
                int valExo;
                for(Exercice evalExo:lesExercices){
                     valExo = 0;
                    for (Evaluation lEval : lesEvals){
                        if (lEval.getMonEleve().equals(el) && lEval.getMonExercice().equals(evalExo)){
                            if (lEval.getValidation()){
                                valExo = 1;
                            }
                        }
                    }
                    int idExoVal = lesExercices.indexOf(evalExo)+1;
                    stmtAdd.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES ("+
                        valExo+","+idEl+","+idExoVal+");");           
                }
                System.out.println("Load = "+cptTemps+"%");
            }
            for (Exercice ex : lesExercices){
                int idExo = lesExercices.indexOf(ex)+1;
                String[] parts = ex.getImage().toString().split("/");
                String nomImg = parts[parts.length-1];
                stmtAdd.executeUpdate("INSERT INTO EXERCICE (ID_Exo,Nom_Exo,Commentaire_Exo,Tortue_Exo,Id_Professeur,Image_Exo) VALUES ("+
                        idExo+",'"+ex.getNom()+"','"+ex.getCommentaire()+"',"+ex.getTortueChoisie()+",1,'/Images/"+nomImg+"');");
            }

            System.out.println("Update database successfully");
            c.close();
            progress.closeFrameLoad();
        }catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        }
        });
        java.lang.Thread.sleep(100);
        }
         catch (InterruptedException exp) {
            System.err.println( exp.getClass().getName() + ": " + exp.getMessage() );
            System.exit(0);
      }
    }
}
