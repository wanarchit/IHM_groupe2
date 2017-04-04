package ihm_groupe2.Modele;

import ihm_groupe2.Noyau_fonctionnel.Classe;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import ihm_groupe2.Noyau_fonctionnel.Professeur;
import ihm_groupe2.Noyau_fonctionnel.Realisation;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 * Classe ArbreExercicesEleve
 * Modèle d'arbre pour remplir l'arbre contenant à la racine un élève
 * Chaque noeud est un exercice et est clicable pour renvoyer vers le controleur CtrlArbreExercicesEleve
 * Chaque feuille est une tentative de l'exercice pour l'élève (racine)
 * 
 * @author Paul
 */
public class ArbreExercicesEleve {
    private ImageIcon iconExo;
    public Eleve E1;
    public ArrayList<Exercice> lesExercices;
    
    
    
    public ArbreExercicesEleve (){
        
        Professeur P1 = new Professeur ("azerty", "123456", "Thomas", "Kerdreux");
        Classe CP = new Classe ("CP", P1);
        E1 = new Eleve(CP, "Maxime", "Tanguy");
        Exercice Ex1 = new Exercice ("Exercice1", "Le premier exercice", 1, iconExo);
        Exercice Ex2 = new Exercice ("Exercice2", "Le second exercice", 1, iconExo);
        Realisation R1_1 = new Realisation (1,"1_1","Non acquis",Ex1);
        Realisation R1_2 = new Realisation (2,"1_2","Acquis",Ex1);
        Realisation R2_1 = new Realisation (3,"2_1","Non acquis",Ex2);
        Realisation R2_2 = new Realisation (4,"2_2","Acquis",Ex2);
        E1.addRealisation(R1_1);
        E1.addRealisation(R1_2);
        E1.addRealisation(R2_1);
        E1.addRealisation(R2_2);
        lesExercices = new ArrayList();
        lesExercices.add(Ex1);
        lesExercices.add(Ex2);
    }
    
}
