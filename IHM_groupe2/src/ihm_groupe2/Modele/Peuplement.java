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
            int check = stmt.executeUpdate("INSERT INTO PROFESSEUR (ID_Professeur,Nom_Professeur,Prenom_Professeur,Login,Mot_De_Passe) VALUES (1,'Conrady','Marin','marinPoitiers','mdpMarin');");
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
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (1,'Hopper',3,'Jaden','/Applications/Images_eleves/eleve_g1.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (2,'Young',2,'Wang','/Applications/Images_eleves/eleve_g2.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (3,'Shields',3,'Whitney','/Applications/Images_eleves/eleve_f1.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (4,'Porter',5,'Julie','/Applications/Images_eleves/eleve_f2.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (5,'Thomas',4,'Tamara','/Applications/Images_eleves/eleve_f3.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (6,'Combs',5,'Thane','/Applications/Images_eleves/eleve_g3.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (7,'Kelly',3,'Elijah','/Applications/Images_eleves/eleve_g4.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (8,'Meyers',4,'Wynne','/Applications/Images_eleves/eleve_g5.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (9,'Wilkinson',1,'Sean','/Applications/Images_eleves/eleve_g6.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (10,'Chase',3,'Shana','/Applications/Images_eleves/eleve_f4.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (11,'Gould',3,'Quinlan','/Applications/Images_eleves/eleve_g7.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (12,'Simmons',5,'Katell','/Applications/Images_eleves/eleve_f5.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (13,'Reese',1,'Lewis','/Applications/Images_eleves/eleve_g8.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (14,'Martinez',2,'Ocean','/Applications/Images_eleves/eleve_f6.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (15,'Sims',2,'Aretha','/Applications/Images_eleves/eleve_f7.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (16,'Davenport',2,'Palmer','/Applications/Images_eleves/eleve_f8.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (17,'Macdonald',5,'Ginger','/Applications/Images_eleves/eleve_f9.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (18,'Keller',4,'Brendan','/Applications/Images_eleves/eleve_g9.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (19,'Maddox',1,'Angelica','/Applications/Images_eleves/eleve_f10.png');");
           stmt.executeUpdate("INSERT INTO ELEVE (ID_Eleve,Nom_Eleve,Id_Classe,Prenom_Eleve,Icon_Eleve) VALUES (20,'Blackburn',2,'Vernon','/Applications/Images_eleves/eleve_g10.png');");  
           
            //Peuplement de la table Exercice
           stmt.executeUpdate("INSERT INTO EXERCICE (ID_Exo,Nom_Exo,Commentaire_Exo,Tortue_Exo,Id_Professeur,Image_Exo) VALUES (1,'Exercice_CP','Faites un simple carré',0,3,'/Images/Exercice1_image.PNG');");
           stmt.executeUpdate("INSERT INTO EXERCICE (ID_Exo,Nom_Exo,Commentaire_Exo,Tortue_Exo,Id_Professeur,Image_Exo) VALUES (2,'Exercice_CE1','Faites un simple rectangle',0,4,'/Images/Exercice5_image.PNG');");
           stmt.executeUpdate("INSERT INTO EXERCICE (ID_Exo,Nom_Exo,Commentaire_Exo,Tortue_Exo,Id_Professeur,Image_Exo) VALUES (3,'Exercice_CE2','Faites un carré rouge entouré dun autre carré rouge',1,5,'/Images/Exercice3_image.PNG');");
           stmt.executeUpdate("INSERT INTO EXERCICE (ID_Exo,Nom_Exo,Commentaire_Exo,Tortue_Exo,Id_Professeur,Image_Exo) VALUES (4,'Exercice_CM1','Faites une télécommande en rouge',1,2,'/Images/Exercice4_image.PNG');");
           stmt.executeUpdate("INSERT INTO EXERCICE (ID_Exo,Nom_Exo,Commentaire_Exo,Tortue_Exo,Id_Professeur,Image_Exo) VALUES (5,'Exercice_CM2','Faites une croix en utilisant différentes vitesses',2,1,'/Images/Exercice2_image.PNG');");
           
            //Peuplement de la table Realisation
           //Eleve 1 (en CP) travaillant sur lexercice 1
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (1,'Non acquis',1,1,1,'Bien pour un premier essai');");
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (2,'Non acquis',1,1,2,'Relisez la consigne');");
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (3,'En cours acquisition',1,1,3,'Peut mieux faire');");
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (4,'En cours acquisition',1,1,4,'Presque bon');");
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (5,'Acquis',1,1,5,'Parfait');");
           //Eleve 2 (CE1) travaillant sur l'exercice 2
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (6,'Non acquis',5,2,1,'Relisez la consigne');");
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (7,'Acquis',5,2,2,'Validé');");
           //Eleve 3 (CE2) travaillant sur l'exercice 3
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (8,'Acquis',12,3,1,'Validé');");
           //Eleve 2 (CM1) travaillant sur l'exercice 4
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (9,'Non acquis',2,4,1,'Travail baclé');");
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (10,'En cours acquisition',2,4,2,'Des efforts mais peut mieux faire');");
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (11,'Acquis',2,4,3,'Validé');");
           //Eleve 2 (CM2) travaillant sur l'exercice 5
           stmt.executeUpdate("INSERT INTO REALISATION (ID_Realisation,Note_Realisation,Id_Eleve,Id_Exo,Numero_Tentative,Commentaire_Realisation) VALUES (12,'Non acquis',9,5,1,'Ce nest pas un travail de CM2');");
           
           //Peuplement
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (1,'Avance');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (2,'Tourne');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (3,'N''ecrit plus');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (4,'Ecrit');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (5,'Ralentie');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (6,'Accélère');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (7,'Ecrit en noir');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (8,'Ecrit en rouge');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (9,'Ecrit en rose');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (10,'Ecrit en jaune');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (11,'Ecrit en vert');");
           stmt.executeUpdate("INSERT INTO COMMANDES (ID_Commande,Nom_Commande) VALUES (12,'Ecrit en bleu');");
           
           //Peuplement de la table A_valide
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (1,1,1);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (1,2,4);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,3,1);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,4,3);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (1,5,3);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,6,3);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,7,1);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,8,2);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,9,5);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,10,1);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,11,1);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (1,12,3);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,13,5);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,14,4);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,15,4);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,16,4);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,17,3);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,18,2);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,19,5);");
           stmt.executeUpdate("INSERT INTO A_valide (Validation_Exo,Id_Eleve,Id_Exo) VALUES (0,20,4);");

           //Peuplement de la table Utilise
            //Realisation 1
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,1,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,1,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,1,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,1,4);");
            //Realisation 2
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,2,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (11,2,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,2,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (12,2,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,2,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,2,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,2,7);");
            //Realisation 3
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,3,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,3,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,3,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,3,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,3,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,3,6);");
            //Realisation 4
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,4,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,4,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,4,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,4,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,4,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,4,7);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,4,8);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,4,9);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,4,10);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,4,11);");
            //Realisation 5 done
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,5,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,5,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,5,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,5,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,5,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,5,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,5,7);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,5,8);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,5,9);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,5,10);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,5,11);");
            //Realisation 6
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,6,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (9,6,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,6,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,6,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (10,6,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,6,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,6,7);");
            //Realisation 7 done
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,7);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,8);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,9);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,10);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,11);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,12);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,13);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,14);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,15);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,16);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,17);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,18);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,19);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,20);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,21);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,22);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,23);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,24);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,25);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,26);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,27);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,28);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,29);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,30);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,31);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,32);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,33);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,34);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,7,35);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,36);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,7,37);");
            //Realisation 8 done
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (8,8,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,7);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,8);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,9);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,10);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,11);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,12);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,13);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,14);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,15);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,16);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,17);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,18);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,19);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,20);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,21);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,22);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,23);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,24);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,25);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,26);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,27);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,8,28);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,8,29);");
            //Realisation 9
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,9,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,9,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,7);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,8);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,9);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,10);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,9,11);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,12);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,9,13);");
            //Realisation 10
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,10,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,10,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,10,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,10,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,10,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,10,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,10,7);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,10,8);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,10,9);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,10,10);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,10,11);");
            //Realisation 11 done
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (8,11,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,7);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,8);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,9);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,10);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,11);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,12);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,13);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,14);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,15);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,16);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,17);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,18);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,19);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,20);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,21);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,22);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,23);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,24);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,25);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,26);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,27);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,28);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,29);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,30);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,31);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,32);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,33);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,34);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,35);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,36);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,37);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,38);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,39);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,40);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,41);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,42);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,43);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,44);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,45);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,46);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,47);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,48);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,49);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,50);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,51);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,52);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,53);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,11,54);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,11,55);");
            //Realisation 12 done
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,12,1);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,12,2);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (6,12,3);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,12,4);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,12,5);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (5,12,6);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,12,7);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,12,8);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (2,12,9);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (6,12,10);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,12,11);");
            stmt.executeUpdate("INSERT INTO UTILISE (Id_Commande,Id_Realisation,Iteration) VALUES (1,12,12);");
        }catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Tables are successfully filled");
    }
}
