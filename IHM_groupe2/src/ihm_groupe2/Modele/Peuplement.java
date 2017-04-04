package ihm_groupe2.Modele;
import java.sql.*;

/**
 *
 * @author Marin
 */
public class Peuplement {
    
    public void Peuplement(){
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:IHM_G2.db");
            System.out.println("Opened database successfully");
            stmt = c.createStatement();
            //Peuplement de la table Professeur
           stmt.executeUpdate("INSERT INTO PROFESSEUR (ID_Professeur,Nom_Professeur,Prenom_Professeur,Login,Mot_De_Passe) VALUES (1,'Conrady','Marin','marinPoitiers','mdpMarin');");
           stmt.executeUpdate("INSERT INTO PROFESSEUR (ID_Professeur,Nom_Professeur,Prenom_Professeur,Login,Mot_De_Passe) VALUES (2,'Gand','Paul','paulPoitiers','mdpPaul') ;");
           stmt.executeUpdate("INSERT INTO PROFESSEUR (ID_Professeur,Nom_Professeur,Prenom_Professeur,Login,Mot_De_Passe) VALUES (3,'Rousse','Delphine','delphinePoitiers','mdpDelphine') ;");
           stmt.executeUpdate("INSERT INTO PROFESSEUR (ID_Professeur,Nom_Professeur,Prenom_Professeur,Login,Mot_De_Passe) VALUES (4,'Rivault','Joe','joePoitiers','mdpJoe');");
           stmt.executeUpdate("INSERT INTO PROFESSEUR (ID_Professeur,Nom_Professeur,Prenom_Professeur,Login,Mot_De_Passe) VALUES (5,'Tanguy','Maxime','maxPoitiers','mdpMax');");   
           //Peuplement de la table Classe
           stmt.executeUpdate("INSERT INTO CLASSE (ID_Classe,Id_Professeur,Nom_Classe) VALUES (1,1,'CM2');");
           stmt.executeUpdate("INSERT INTO CLASSE (ID_Classe,Id_Professeur,Nom_Classe) VALUES (2,2,'CM1');");
           stmt.executeUpdate("INSERT INTO CLASSE (ID_Classe,Id_Professeur,Nom_Classe) VALUES (3,3,'CP');");
           stmt.executeUpdate("INSERT INTO CLASSE (ID_Classe,Id_Professeur,Nom_Classe) VALUES (4,4,'CE1');");
           stmt.executeUpdate("INSERT INTO CLASSE (ID_Classe,Id_Professeur,Nom_Classe) VALUES (5,5,'CE2');");
           //Peuplement de la table Eleve
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (1,'Hopper',3,'Jaden');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (2,'Young',2,'Wang');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (3,'Shields',3,'Whitney');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (4,'Porter',5,'Julie');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (5,'Thomas',4,'Tamara');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (6,'Combs',5,'Thane');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (7,'Kelly',3,'Elijah');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (8,'Meyers',4,'Wynne');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (9,'Wilkinson',1,'Sean');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (10,'Chase',3,'Shana');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (11,'Gould',3,'Quinlan');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (12,'Simmons',5,'Katell');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (13,'Reese',1,'Lewis');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (14,'Martinez',2,'Ocean');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (15,'Sims',2,'Aretha');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (16,'Davenport',2,'Palmer');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (17,'Macdonald',5,'Ginger');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (18,'Keller',4,'Brendan');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (19,'Maddox',1,'Angelica');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve) VALUES (20,'Blackburn',2,'Vernon');");   
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Tables peuplées avec succès");
    }
}
