package Applications;

import ihm_groupe2.Inferface.Menu.Dessin;
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
import javax.swing.SwingUtilities;

/**
 * Classe ApplicationEleve : permet de gérer tous les éléments liés aux élèves
 * @author Groupe 2
 */
public class ApplicationEleve {
    
    private MainFrame fenetreMain;      // Fenetre principale
    
    private Classe maClasse;            // la classe concernée (chargement des données) -> modifié à chaque tour de boucle
    private Professeur leProf;          // la classe concernée (chargement des données) -> modifié à chaque tour de boucle
    private Eleve eleve;                // la classe concernée (chargement des données) -> modifié à chaque tour de boucle
    private Exercice exo;               // la classe concernée (chargement des données) -> modifié à chaque tour de boucle
    private Realisation maRea;          // la classe concernée (chargement des données) -> modifié à chaque tour de boucle
    private Commande maCmd;             // la classe concernée (chargement des données) -> modifié à chaque tour de boucle
    
    private ArrayList<Eleve> lesEleves;         // Liste de tous les élèves
    private Eleve[] lesEleves2;                 // Tableau de taille "nombre d'élève" : permet de charger les élèves dans l'ordre des id
    private ArrayList<Classe> lesClasses;       // Liste de toutes les classes
    private ArrayList<Exercice> lesExercices;   // Liste de tous les exercices
    private ArrayList<Professeur> lesProfs;     // Liste de tous les profs
    private ArrayList<Evaluation> lesEvals;     // Liste de toutes les évaluations
    private Eleve eleveCo;                      // Eleve qui est connecté à l'application
    
    /**
     * Constructeur de la classe ApplicationEleve
     * Permet de charger toutes les données nécessaires au fonctionnement de l'application élève
     * @param main : fenêtre principale
     */
    public ApplicationEleve(MainFrame main){
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
            //lesEleves=new ArrayList();
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
                int idExo = resExercices.getInt("ID_Exo");
                String imageExercice=resExercices.getString("Image_Exo");
                try{
                    //ImageIcon imageExo = new ImageIcon(getClass().getResource(imageExercice));
                    String nomExo=resExercices.getString("Nom_Exo");
                    String comExo=resExercices.getString("Commentaire_Exo");
                    int tortueExo=resExercices.getInt("Tortue_Exo");
                    exo = new Exercice(nomExo,comExo,tortueExo,imageExercice);
                    lesExercices.add(exo);
                }catch ( Exception exp ) {
                    ImageIcon imageExo = new ImageIcon(getClass().getResource("/Images/Exercice_erreur.PNG"));
                    String nomExo=resExercices.getString("Nom_Exo");
                    String comExo=resExercices.getString("Commentaire_Exo");
                    int tortueExo=resExercices.getInt("Tortue_Exo");
                    exo = new Exercice(nomExo,comExo,tortueExo,imageExercice);
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
                        //lesEleves.add(eleve);
                        lesEleves2[idEleve-1]=eleve;
                        maClasse.ajoutEleve(eleve);
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
                                int idCmd = resCmd.getInt("ID_Commande");
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
        
        MenuConnexionEleve menuCoEleve = new MenuConnexionEleve(this);
        fenetreMain.setContentPane(menuCoEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * fonction getListeEleve : permet de récupérer la liste de tous les élèves
     * @return lesEleves
     */
    public ArrayList<Eleve> getListeEleve(){
        return lesEleves;
    }
    
    /**
     * Fonction tryConnexion : Permet de vérifier les identifiants d'un élève lors de sa connexion
     * Vérifie si l'élève existe ou pas
     * @param prenomEleveTryCo : Prénom entré par l'élève
     * @param nomEleveTryCo : nom entré par l'élève
     * @return el ou null : élève si les identifiants sont corrects et null si les identifiants sont faux.
     */
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
    
    /**
     * Fonction seConnecter : afficher le nouveau panel de l'élève, met à jour la fenetre
     * Met a jour l'élève qui est connecté
     * @param lEleve : l'élève qui tente de se connecter
     */
    public void seConnecter(Eleve lEleve){
        eleveCo = lEleve;
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,lesExercices.get(0),0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Fonction annulerConnexion : Permet de revenir au menu principal à partir du menu de connexion d'un élève
     * Aucun élève ne s'est connecté
     */
    public void annulerConnexion(){
        MenuPrincipal leMenuP = new MenuPrincipal(fenetreMain);
        fenetreMain.setContentPane(leMenuP);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Fonction getEleveConnecte
     * @return eleveCo : renvoie l'élève qui utilise actuellement l'application
     */
    public Eleve getEleveConnecte(){
        return eleveCo;
    }
    
    /**
     * Fonction faireExercice : permet de lancer le panel de dessin de l'exercice voulu
     * @param exerciceActu : Exercice sur lequel l'élève à cliqué
     */
    public void faireExercice(Exercice exerciceActu){
        Dessin leDessin = new Dessin(this,exerciceActu);
        fenetreMain.setContentPane(leDessin);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Fonction exerciceSuivExist : permet de contrôlé s'il y a un autre exercice après l'exercice actuellement affiché pour l'élève
     * @param exerciceActu : l'exercice qui est actuellement affiché
     * @return true ou false selon le cas
     */
    public boolean exerciceSuivExist(Exercice exerciceActu){
        if (lesExercices.indexOf(exerciceActu) < lesExercices.size()-1){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Fonction exercicePrecExist : permet de contrôlé s'il y a un autre exercice avant l'exercice actuellement affiché pour l'élève
     * @param exerciceActu : l'exercice qui est actuellement affiché
     * @return true ou false selon le cas
     */
    public boolean exercicePrecExist(Exercice exerciceActu){
        if (lesExercices.indexOf(exerciceActu) != 0){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Fonction afficheExerciceSuivant : permet de mettre a jour le panel en affichant l'exerice suivant
     * @param exoEnCours : l'exercice qui est actuellement affiché
     */
    public void afficheExerciceSuivant(Exercice exoEnCours){
        Exercice exoSuiv = lesExercices.get(lesExercices.indexOf(exoEnCours)+1);
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,exoSuiv,0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Fonction afficheExercicePrecedant : permet de mettre a jour le panel en affichant l'exerice précédent
     * @param exoEnCours : l'exercice qui est actuellement affiché
     */
    public void afficheExercicePrecedant(Exercice exoEnCours){
        Exercice exoPrec = lesExercices.get(lesExercices.indexOf(exoEnCours)-1);
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,exoPrec,0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Fonction annulerDessin : Permet de revenir au menu principal de l'élève a partir du menu de dessin
     * Va afficher l'exercice en cours de réalisation
     * @param exoEnCours : exercice pour lequel l'élève réalisait un dessin
     */
    public void annulerDessin(Exercice exoEnCours){
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,exoEnCours,0);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Fonction enregistrerDessin : Permet d'ajouter une réalisation à l'élève
     * @param laRealisation : qui vient d'être faite par l'élève connecté
     */
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
    
    /**
     * Fonction rejouerListeActions : Permet de rééxécuter l'ensemble des commandes faites par l'élève
     * @param lesCommandes : liste de toutes les commandes faites par l'élève pour la réalisation en cours
     */
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
     * Fonction ExoIsValidate : Permet de vérifier si l'exerice affiché à l'élève est déjà validé ou non
     * @param exoEnCours : l'exerice actuellement affiché
     * @param monEleve : l'élève qui souhaite effectué l'exerice
     * @return true ou false selon le cas
     */
    public boolean ExoIsValidate(Exercice exoEnCours, Eleve monEleve){
        for (Evaluation eval :lesEvals){
            if (eval.getMonEleve().equals(monEleve) && eval.getMonExercice().equals(exoEnCours)){
                if (eval.getValidation()){
                    return true;
                }else{
                    return false;
                }
            }
        }
        return false;
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
    
    /**
     * Fonction tentativeSuivExist : Permet de controlé si la réalisation suivante existe pour un exercice
     * @param exerciceActu : exercice qui est actuellement affiché à l'élève
     * @param tentEnCours : réalisation qui est actuellement affiché à l'élève
     * @return ture ou false selon le cas
     */
    public boolean tentativeSuivExist(Exercice exerciceActu, Realisation tentEnCours){
        if (tentEnCours.getNumeroTentative() < getTentativeExo(exerciceActu).size()){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Fonction tentativePrecExist : Permet de controlé si la réalisation précédente existe pour un exercice
     * @param exerciceActu : exercice qui est actuellement affiché à l'élève
     * @param tentEnCours : réalisation qui est actuellement affiché à l'élève
     * @return ture ou false selon le cas
     */
    public boolean tentativePrecExist(Exercice exerciceActu, Realisation tentEnCours){
        if (tentEnCours.getNumeroTentative() != 1){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     * Fonction afficheTentativeSuivante : permet d'afficher la réalisation suivante d'un élève pour un exercice donné
     * @param exoEnCours : exercice actuellement affiché à l'élève
     * @param tentEnCours : réalisation qui est actuellement affiché à l'élève
     */
    public void afficheTentativeSuivante(Exercice exoEnCours,Realisation tentEnCours){
        int numReaSuiv = tentEnCours.getNumeroTentative();
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,exoEnCours,numReaSuiv);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Fonction afficheTentativePrecedante : permet d'afficher la réalisation précédente d'un élève pour un exercice donné
     * @param exoEnCours : exercice actuellement affiché à l'élève
     * @param tentEnCours : réalisation qui est actuellement affiché à l'élève
     */
    public void afficheTentativePrecedante(Exercice exoEnCours, Realisation tentEnCours){
        int numReaSuiv = tentEnCours.getNumeroTentative()-2;
        MenuEleve leMenuEleve = new MenuEleve(eleveCo,this,exoEnCours,numReaSuiv);
        fenetreMain.setContentPane(leMenuEleve);
        fenetreMain.repaint();
        fenetreMain.revalidate();
    }
    
    /**
     * Fonction afficheRejouerRea : Permet d'exécuter la fonction qui rejoue la réalisation de l'élève
     * @param tentEnCours 
     */
    public void afficheRejouerRea(Realisation tentEnCours){
        new RejouerReaEleve(tentEnCours);
    }
    
    /**
     * Fonction enregistrementBDD : Permet de mettre a jour la base de donnée avec les nouvelles informations
     * La mise a jour se fait en cas de déconnexion de l'élève (clic sur la croix rouge)
     */
    public void enregistrementBDD(){
        FenetreLoad progress = new FenetreLoad("Mise à jour de la BDD en cours ...");
        // On affiche la fenetre de mise à jour des données
        try {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    Connection c = null;
                    try {
                        Class.forName("org.sqlite.JDBC");
                        c = DriverManager.getConnection("jdbc:sqlite:IHM_G2.db");
                        // On supprime les tables qui seront modifiées (toutes sauf : prof, élève, commandes et classe : ne seront jamais modifiées)
                        ResetBDD resetdb = new ResetBDD();
                        resetdb.dbReset();
                        System.out.println("Update of database ...");

                        Statement stmtAdd = null;
                        stmtAdd = c.createStatement();
                        int idRea = 0;
                        int cptTemps = 0;
                        // Pour tous les élèves :
                        for (Eleve el : lesEleves){
                            cptTemps+=5;
                            int idEl = lesEleves.indexOf(el)+1;
                            // Pour toutes les réalisations de l'élève : 
                            for (Realisation rea : el.getLesRealisations()){
                                idRea++;
                                int idExRea = lesExercices.indexOf(rea.getExercice())+1;
                                stmtAdd.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES ("+
                                idRea+",'"+rea.getNote()+"',"+idEl+","+idExRea+","+rea.getNumeroTentative()+",'"+rea.getCommentaire()+"');");
                                int i=0;
                                // Pour toutes les commandes de la réalisation de l'élève : 
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
                            // Pour tous les exerices : 
                            for(Exercice evalExo:lesExercices){
                                 valExo = 0;
                                 // Pour toutes les évaluations de cet exercice : 
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
                            // On affiche dans la console le temps de chargement des données
                            System.out.println("Load = "+cptTemps+"%");
                        }
                        // Pour tous les exerices :
                        for (Exercice ex : lesExercices){
                            int idExo = lesExercices.indexOf(ex)+1;
                            //String[] parts = ex.getImage().toString().split("/");
                            //String nomImg = parts[parts.length-1];
                            stmtAdd.executeUpdate("INSERT INTO EXERCICE (ID_Exo,Nom_Exo,Commentaire_Exo,Tortue_Exo,Id_Professeur,Image_Exo) VALUES ("+
                                    idExo+",'"+ex.getNom()+"','"+ex.getCommentaire()+"',"+ex.getTortueChoisie()+",1,'"+ex.getNomImage()+"');");
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
        }catch (InterruptedException exp) {
            System.err.println( exp.getClass().getName() + ": " + exp.getMessage() );
            System.exit(0);
        }
    }
}
