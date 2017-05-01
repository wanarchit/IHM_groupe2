package ihm_groupe2.Modele;
import java.sql.*;

/**
 *
 * @author Marin
 */
public class SqliteJDBC {
 
    public void dbConnection()
    {
    Connection c = null;
    Statement stmt = null;
    try {
      Class.forName("org.sqlite.JDBC");
      c = DriverManager.getConnection("jdbc:sqlite:IHM_G2.db");
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      
      String tableProfesseur = "CREATE TABLE PROFESSEUR " +
      "(ID_Professeur INT PRIMARY KEY     NOT NULL," +
      " Nom_Professeur     CHAR(50) NOT NULL," + 
      " Prenom_Professeur  CHAR(50) NOT NULL," + 
      " Login              CHAR(50) NOT NULL," +
      " Mot_De_Passe       CHAR(50) NOT NULL)";
      stmt.executeUpdate(tableProfesseur);
      
      String tableExercice = "CREATE TABLE EXERCICE " +
      "(ID_Exo INT PRIMARY KEY      NOT NULL," +
      " Nom_Exo           CHAR(50)  NOT NULL," + 
      " Commentaire_Exo   CHAR(250) NOT NULL," + 
      " Tortue_Exo        INT       NOT NULL," + 
      "Id_Professeur      INT       NOT NULL,"+
      "Image_Exo         CHAR(250) NOT NULL,"+
      "FOREIGN KEY(Id_Professeur) REFERENCES PROFESSEUR(ID_Professeur))";
      stmt.executeUpdate(tableExercice);
      
      String tableClasse = "CREATE TABLE CLASSE " +
      "(ID_Classe INT PRIMARY KEY     NOT NULL," +
      "Id_Professeur      INT         NOT NULL,"+
      " Nom_Classe        CHAR(50)    NOT NULL,"+
      "FOREIGN KEY(Id_Professeur) REFERENCES PROFESSEUR(ID_Professeur))"; 
      stmt.executeUpdate(tableClasse);
      
      String tableEleve = "CREATE TABLE ELEVE " +
      "(ID_Eleve INT PRIMARY KEY      NOT NULL," +
      "Nom_Eleve      CHAR(50) NOT NULL," +
      "Id_Classe       INT      NOT NULL,"+
      " Prenom_Eleve   CHAR(50) NOT NULL,"+
      " Icon_Eleve      CHAR(100) NOT NULL,"+
      "FOREIGN KEY(Id_Classe) REFERENCES CLASSE(ID_Classe))";
      stmt.executeUpdate(tableEleve);
      
      String tableRealisation = "CREATE TABLE REALISATION " +
      "(ID_Realisation INT PRIMARY KEY       NOT NULL," +
      "Note_Realisation           CHAR(50)  NOT NULL," +
      "Id_Eleve                    INT       NOT NULL,"+
      "Id_Exo                      INT       NOT NULL,"+
      "Commentaire_Realisation    CHAR(250) NOT NULL,"+
      "Numero_Tentative            INT      NOT NULL,"+
      "FOREIGN KEY(Id_Eleve) REFERENCES ELEVE(ID_Eleve),"+
      "FOREIGN KEY(Id_Exo) REFERENCES EXERCICE(ID_Exo))";
       
      stmt.executeUpdate(tableRealisation);
      
      String tableCommandes = "CREATE TABLE COMMANDES " +
      "(ID_Commande INT PRIMARY KEY      NOT NULL," +
      " Nom_Commande            CHAR(30) NOT NULL)"; 
      stmt.executeUpdate(tableCommandes);
      
      String tableA_valide = "CREATE TABLE A_valide " +//mettre foreign key
      "(Validation_Exo INT NOT NULL,"+
      "Id_Eleve        INT NOT NULL,"+
      "Id_Exo          INT NOT NULL,"+
      "FOREIGN KEY(Id_Eleve) REFERENCES ELEVE(ID_Eleve),"+
      "FOREIGN KEY(Id_Exo) REFERENCES EXERCICE(ID_Exo),"+
      "PRIMARY KEY(Id_Eleve,Id_Exo))";
      stmt.executeUpdate(tableA_valide);
      
      String tableUtilise = "CREATE TABLE UTILISE " +
      "(Id_Commande     INT NOT NULL,"+
      "Id_Realisation  INT NOT NULL,"+
      "Iteration       INT NOT NULL,"+
      "FOREIGN KEY(Id_Commande) REFERENCES COMMANDES(ID_Commande),"+
      "FOREIGN KEY(Id_Realisation) REFERENCES REALISATION(ID_Realisation),"+
      "PRIMARY KEY(Id_Commande,Id_Realisation,Iteration))";
      stmt.executeUpdate(tableUtilise);
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
    }
    System.out.println("Tables created successfully");
  }
}

