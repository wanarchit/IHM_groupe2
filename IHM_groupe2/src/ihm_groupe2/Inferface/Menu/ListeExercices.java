package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Modele.TableExercices;
import ihm_groupe2.Noyau_fonctionnel.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * Classe permettant d'afficher les exercices existants
 * @author Delphine
 */
public class ListeExercices extends JScrollPane{
    private JTable tableExercices;
    private TableExercices modeleTable;
    
    /**
     * Constructeur de listeExercices
     */
    public ListeExercices(){
        ArrayList<Exercice> maListe = new ArrayList();
        ImageIcon monImage = new ImageIcon(); //récupérer l'url de l'icone
        
        //Pour les tests création de ma liste ici sera envoyé via l'application prof
        Exercice ex = new Exercice ("Exercice1", "Comm", 1, monImage);
        maListe.add(ex);
        
        for (Exercice e : maListe){
            modeleTable = new TableExercices(e);
            tableExercices = new JTable (modeleTable);
            
            tableExercices.setRowSelectionAllowed(true);
            tableExercices.setCellSelectionEnabled(true);
            tableExercices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        this.add(tableExercices);
        this.setViewportView(tableExercices);
    }
    
    public void setData (Exercice e){
        modeleTable.setData(e);
        modeleTable.fireTableDataChanged();
    }
    
}
