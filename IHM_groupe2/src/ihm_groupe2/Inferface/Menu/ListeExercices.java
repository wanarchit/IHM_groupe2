package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.CtrlTableExercices;
import ihm_groupe2.Modele.TableExercices;
import ihm_groupe2.Noyau_fonctionnel.*;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;

/**
 * Classe permettant d'afficher les exercices existants
 * @author Delphine
 */
public class ListeExercices extends JScrollPane{
    private JTable tableExercices;
    private TableExercices modeleTable;
    private CtrlTableExercices controleur;
    
    /**
     * Constructeur de listeExercices
     */
    public ListeExercices(){
        ArrayList<Exercice> maListe = new ArrayList();
        ImageIcon monImage = new ImageIcon(); //récupérer l'url de l'icone
        controleur = new CtrlTableExercices(this);
        
        //Pour les tests création de ma liste ici sera envoyé via l'application prof
        Exercice ex = new Exercice ("Exercice1", "Comm", 1, monImage);
        Exercice ex2 = new Exercice ("Exercice2", "Comm", 1, monImage);
        maListe.add(ex);
        maListe.add(ex2);
        
        modeleTable = new TableExercices(maListe);
        tableExercices = new JTable (modeleTable);
        
        tableExercices.setRowSelectionAllowed(true);
        tableExercices.setCellSelectionEnabled(true);
        tableExercices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.add(tableExercices);
                          
        ListSelectionModel listSelectionModel = tableExercices.getSelectionModel();        
        listSelectionModel.addListSelectionListener(controleur);
        this.setViewportView(tableExercices);
    }
    
    public void setData (ArrayList<Exercice> maListe){
        modeleTable.setData(maListe);
        modeleTable.fireTableDataChanged();
    } 
    
    public JTable getJTable(){
        return tableExercices;
    }
}
