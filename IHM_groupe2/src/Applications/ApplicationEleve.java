package Applications;

import ihm_groupe2.Inferface.Menu.MenuConnexionEleve;
import ihm_groupe2.Inferface.Menu.MenuEleve;
import ihm_groupe2.Inferface.Menu.MenuPrincipal;
import ihm_groupe2.Inferface.Menu.RejouerReaEleve;
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
import java.util.ArrayList;
import javax.swing.ImageIcon;
import java.sql.*;
/**
 * Classe ApplicationEleve : permet de gérer tous les éléments liés aux élèves
 * @author Groupe 2
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
    private Exercice exo;
    //-----------------
    private ArrayList<Professeur> lesProfs;
    private Realisation maRea; 
    private Commande maCmd;
    private ArrayList<Evaluation> lesEvals;
    
    public ApplicationEleve(MainFrame main){
        fenetreMain = main;
        
        //----------------------------------
        //----------------------------------
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
        }catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        
        
        
        //----------------------------------
        //----------------------------------
        
        
//        leProf = new Professeur("MrProf","12345","LeGrand","Didier");
//        maClasse = new Classe("CM1",leProf);
//        lesClasses = new ArrayList();
//        lesClasses.add(maClasse);
//        mesDessins = new ArrayList();
//        ImageIcon imageEleve = new ImageIcon(getClass().getResource("/Applications/Images_eleves/eleve_f1.png"));
//        eleve = new Eleve(maClasse,"Rousse","Delphine",imageEleve);
//        ImageIcon imageEleve2 = new ImageIcon(getClass().getResource("/Applications/Images_eleves/eleve_g1.png"));
//        eleve2 = new Eleve(maClasse,"Gand","Paul",imageEleve2);
//        lesEleves = new ArrayList();
//        lesEleves.add(eleve);
//        lesEleves.add(eleve2);
//        maClasse.ajoutEleve(eleve);
//        maClasse.ajoutEleve(eleve2);
//        lesExercices = new ArrayList();
//        ImageIcon imageExo = new ImageIcon(getClass().getResource("Exercice1_image.png"));
//        Exercice exo1 = new Exercice("Exercice 1","Vous devez faire ce dessin en 10 minutes avec la tortue normale",0,imageExo);
//        ImageIcon imageExo2 = new ImageIcon(getClass().getResource("Exercice2_image.png"));
//        Exercice exo2 = new Exercice("Exercice 2","Vous devez faire ce dessin en 5 minutes avec la tortue rapide",2,imageExo2);
//        ImageIcon imageExo3 = new ImageIcon(getClass().getResource("Exercice3_image.png"));
//        Exercice exo3 = new Exercice("Exercice 3","Vous devez faire ce dessin en 15 minutes avec la tortue couleur",1,imageExo3);
//        lesExercices.add(exo1);
//        lesExercices.add(exo2);
//        lesExercices.add(exo3);
        
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
        enregistrementBDD();
        //Dessin leDessin = new Dessin(this,exerciceActu);
        //fenetreMain.setContentPane(leDessin);
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
    
    public void enregistrementBDD(){
        System.out.println("Fonction BDD supp");
        Connection c = null;
        Statement stmtDel = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:IHM_G2.db");
            System.out.println("Recreated of database...");
            ResetBDD resetdb = new ResetBDD();
            resetdb.dbReset();
            System.out.println("Deleted database successfully");
            System.out.println("Update of database ...");
            
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
                System.out.println(ex.getImage().toString());
                String[] parts = ex.getImage().toString().split("/");
                String nomImg = parts[parts.length-1];
                System.out.println(nomImg);
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
