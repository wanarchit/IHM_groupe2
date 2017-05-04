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
            ResultSet resProf=stmt.executeQuery("SELECT * FROM PROFESSEUR");
            lesProfs=new ArrayList();
            lesClasses=new ArrayList();
            lesEleves=new ArrayList();
            lesExercices=new ArrayList();
            lesEvals=new ArrayList();
            ResultSet resExercices=stmt4.executeQuery("SELECT * FROM EXERCICE");
            while(resExercices.next()){
                int idExo = resExercices.getInt("ID_Exo");
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
                        lesEleves.add(eleve);
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
                            ResultSet resCmd=stmt6.executeQuery("SELECT * FROM UTILISE JOIN COMMANDES ON UTILISE.Id_Commande=COMMANDES.ID_Commande WHERE Id_Realisation="+idRea);
                            while(resCmd.next()){
                                String nomCmd = resCmd.getString("Nom_Commande");
                                maCmd = new Commande(nomCmd,lesExercices.get(idExo-1).getMaTortue());
                                maRea.ajouterCommande(maCmd);
                            }  
                            eleve.addRealisation(maRea);
                            lesExercices.get(idExo-1).setModifiable(false);
                            ResultSet resEval=stmt7.executeQuery("SELECT * FROM A_valide");
                            while(resEval.next()){
                                int intVal = resEval.getInt("Validation_Exo");
                                Boolean isVal = false;
                                if (intVal == 1){
                                    isVal = true;
                                }
                                Evaluation monEval = new Evaluation(eleve,lesExercices.get(idExo-1),isVal);
                                lesEvals.add(monEval);
                            }
                        }
                    }
                }
            }
            //stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation)            
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

//        lesEleves = new ArrayList();
//        lesProfs = new ArrayList();
//        prof = new Professeur("Prof","12345","LeGrand","Didier");
//        prof2 = new Professeur("Prof2","12345","LePetit","Bernard");
//        lesProfs.add(prof);
//        lesProfs.add(prof2);
//        maClasse = new Classe("CM1",prof);
//        maClasse2 = new Classe("CM2",prof2);
//        lesClasses = new ArrayList();
//        lesClasses.add(maClasse);
//        lesClasses.add(maClasse2);
//        mesDessins = new ArrayList();
//        ImageIcon imageEleve = new ImageIcon(getClass().getResource("/Applications/Images_eleves/eleve_f1.png"));
//        eleve = new Eleve(maClasse,"Rousse","Delphine",imageEleve);
//        ImageIcon imageEleve2 = new ImageIcon(getClass().getResource("/Applications/Images_eleves/eleve_g1.png"));
//        eleve2 = new Eleve(maClasse2,"Gand","Paul",imageEleve2);
//        ImageIcon imageEleve3 = new ImageIcon(getClass().getResource("/Applications/Images_eleves/eleve_g2.png"));
//        eleve3 = new Eleve(maClasse2,"Conrady","Marin",imageEleve3);
//        lesEleves.add(eleve);
//        lesEleves.add(eleve2);
//        lesEleves.add(eleve3);
//        maClasse.ajoutEleve(eleve);
//        maClasse2.ajoutEleve(eleve2);
//        maClasse2.ajoutEleve(eleve3);
//        lesExercices = new ArrayList();
//        ImageIcon imageExo = new ImageIcon(getClass().getResource("Exercice1_image.png"));
//        Exercice exo1 = new Exercice("Exercice 1","Vous devez faire ce dessin en 10 minutes avec la tortue normale",0,imageExo);
//        //exo1.setModifiable(false);
//        ImageIcon imageExo2 = new ImageIcon(getClass().getResource("Exercice2_image.png"));
//        Exercice exo2 = new Exercice("Exercice 2","Vous devez faire ce dessin en 5 minutes avec la tortue rapide",2,imageExo2);
//        ImageIcon imageExo3 = new ImageIcon(getClass().getResource("Exercice3_image.png"));
//        Exercice exo3 = new Exercice("Exercice 3","Vous devez faire ce dessin en 15 minutes avec la tortue couleur",1,imageExo3);
//        ImageIcon imageExo4 = new ImageIcon(getClass().getResource("Exercice4_image.png"));
//        Exercice exo4 = new Exercice("Exercice 4","Vous devez faire ce dessin en 5 minutes avec la tortue couleur",2,imageExo4);
//        lesExercices.add(exo1);
//        lesExercices.add(exo2);
//        lesExercices.add(exo3);
//        lesExercices.add(exo4);
//        
//        //toruteG = new TortueG();
//       // tortueRap = new TortueRapide();
//       // tortueCoul = new TortueCouleur();
//        Realisation maRea = new Realisation(1,"","",exo1);
//        Commande maCommande10 = new Commande("Avance",exo1.getMaTortue());
//        Commande maCommande11 = new Commande("Avance",exo1.getMaTortue());
//        Commande maCommande12 = new Commande("Tourne",exo1.getMaTortue());
//        Commande maCommande13 = new Commande("Avance",exo1.getMaTortue());
//        Commande maCommande14 = new Commande("Tourne",exo1.getMaTortue());
//        Commande maCommande15 = new Commande("Avance",exo1.getMaTortue());
//        Commande maCommande16 = new Commande("N'écrit plus",exo1.getMaTortue());
//        Commande maCommande17 = new Commande("Avance",exo1.getMaTortue());
//        Commande maCommande18 = new Commande("Ecrit",exo1.getMaTortue());
//        Commande maCommande19 = new Commande("Avance",exo1.getMaTortue());
//        maRea.ajouterCommande(maCommande10);
//        maRea.ajouterCommande(maCommande11);
//        maRea.ajouterCommande(maCommande12);
//        maRea.ajouterCommande(maCommande13);
//        maRea.ajouterCommande(maCommande14);
//        maRea.ajouterCommande(maCommande15);
//        maRea.ajouterCommande(maCommande16);
//        maRea.ajouterCommande(maCommande17);
//        maRea.ajouterCommande(maCommande18);
//        maRea.ajouterCommande(maCommande19);
//        eleve.addRealisation(maRea);
//        exo1.setModifiable(false);
//        
//        Realisation maRea2 = new Realisation(1,"","",exo2);
//        Commande maCommande2 = new Commande("Avance",exo2.getMaTortue());
//        maRea2.ajouterCommande(maCommande2);
//        eleve.addRealisation(maRea2);
//        exo2.setModifiable(false);
//        
//        Realisation maRea3 = new Realisation(1,"","",exo2);
//        Commande maCommande3 = new Commande("Avance",exo2.getMaTortue());
//        maRea3.ajouterCommande(maCommande3);
//        eleve2.addRealisation(maRea3);
//        
//        Realisation maRea4 = new Realisation(1,"","",exo3);
//        Commande maCommande4 = new Commande("Avance",exo3.getMaTortue());
//        maRea4.ajouterCommande(maCommande4);
//        eleve.addRealisation(maRea4);
//        exo3.setModifiable(false);
//        
//        Realisation maRea5 = new Realisation(2,"","",exo2);
//        Commande maCommande5 = new Commande("Avance",exo2.getMaTortue());
//        maRea5.ajouterCommande(maCommande5);
//        eleve.addRealisation(maRea5);
        
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
        System.out.println("Fonction BDD supp");
        Connection c = null;
        //Statement stmtDel = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:IHM_G2.db");
            System.out.println("Recreated of database...");
            
            //stmtDel = c.createStatement();
            //stmtDel.executeUpdate("DROP TABLE PROFESSEUR");
            //stmtDel.executeUpdate("DROP TABLE EXERCICE");
            //stmtDel.executeUpdate("DROP TABLE CLASSE");
            //stmtDel.executeUpdate("DROP TABLE ELEVE");
            //stmtDel.executeUpdate("DROP TABLE REALISATION");
            //stmtDel.executeUpdate("DROP TABLE COMMANDES");
            //stmtDel.executeUpdate("DROP TABLE A_valide");
            //stmtDel.executeUpdate("DROP TABLE UTILISE");
            //stmtDel.close();
            ResetBDD resetdb = new ResetBDD();
            resetdb.dbReset();
            System.out.println("Deleted database successfully");
            System.out.println("Update of database ...");
            //SqliteJDBC db = new SqliteJDBC();
            //db.dbConnection(); // Création de toutes les tables et les contraintes
            
            
            
            Statement stmtAdd = null;
            stmtAdd = c.createStatement();
            //for (Professeur p : lesProfs){
               // int idP = lesProfs.indexOf(p)+1;
                //stmtAdd.executeUpdate("INSERT INTO PROFESSEUR (ID_Professeur,Nom_Professeur,Prenom_Professeur,Login,Mot_De_Passe) VALUES ("+
                   //     idP+",'"+p.getNomPersonne()+"','"+p.getPrenomPersonne()+"','"+p.getLogin()+"','"+p.getMotdePasse()+"');");
            //}
           // for (Classe cl : lesClasses){
             //   int idCl = lesClasses.indexOf(cl)+1;
              //  int idP2 = lesProfs.indexOf(cl.getProfesseur())+1;
              //  stmtAdd.executeUpdate("INSERT INTO CLASSE (ID_Classe,Id_Professeur,Nom_Classe) VALUES ("+
                 //       idCl+","+idP2+",'"+cl.getNomClasse()+"');");
           // }
            int idRea = 0;
            for (Eleve el : lesEleves){
                int idEl = lesEleves.indexOf(el)+1;
                int idCl = lesClasses.indexOf(el.getLaClasse())+1;
                //stmtAdd.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES ("+
                    //    idEl+",'"+el.getNomPersonne()+"',"+idCl+",'"+el.getNomPersonne()+"','"+el.getIconEleve().toString()+"');");
                for (Realisation rea : el.getLesRealisations()){
                    idRea++;
                    //int idRea = el.getLesRealisations().indexOf(rea)+1;
                    int idExRea = lesExercices.indexOf(rea.getExercice())+1;
                    
                    stmtAdd.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES ("+
                    idRea+",'"+rea.getNote()+"',"+idEl+","+idExRea+","+rea.getNumeroTentative()+",'"+rea.getCommentaire()+"');");
                    
                    int i=0;
                    for (Commande cmd : rea.getListeCommande()){
                        i++;
                        int idCmd = rea.getListeCommande().indexOf(cmd);
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
            }
            for (Exercice ex : lesExercices){
                int idExo = lesExercices.indexOf(ex)+1;
                String[] parts = ex.getImage().toString().split("/");
                String nomImg = parts[parts.length-1];
                stmtAdd.executeUpdate("INSERT INTO EXERCICE (ID_Exo,Nom_Exo,Commentaire_Exo,Tortue_Exo,Id_Professeur,Image_Exo) VALUES ("+
                        idExo+",'"+ex.getNom()+"','"+ex.getCommentaire()+"',"+ex.getTortueChoisie()+",1,'/Images/"+nomImg+"');");
            }
            
            // Voir pour ne pas supprimer cette table
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (1,'Avance');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (2,'Tourne');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (3,'N''ecrit plus');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (4,'Ecrit');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (5,'Ralentie');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (6,'Accélère');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (7,'Ecrit en noir');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (8,'Ecrit en rouge');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (9,'Ecrit en rose');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (10,'Ecrit en jaune');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (11,'Ecrit en vert');");
//            stmtAdd.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (12,'Ecrit en bleu');"); 

            System.out.println("Update database successfully");
            c.close();
        }catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
   
}
