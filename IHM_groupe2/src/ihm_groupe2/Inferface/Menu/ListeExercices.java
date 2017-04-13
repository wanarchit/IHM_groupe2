package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlTableExercices;
import ihm_groupe2.Modele.TableExercices;
import ihm_groupe2.Noyau_fonctionnel.*;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * Classe permettant d'afficher les exercices existants
 * @author Delphine
 */
public class ListeExercices extends JScrollPane{
    private ApplicationProf appli;
    private JTable tableExercices;
    private TableExercices modeleTable;
    private CtrlTableExercices controleur;
    private ArrayList<Exercice> maListe;

    /**
     * Constructeur de listeExercices
     */
    public ListeExercices(ArrayList<Exercice> maListeExo, ApplicationProf lAppli){
        appli = lAppli;
        maListe = maListeExo;

        controleur = new CtrlTableExercices(this,appli);
        
        modeleTable = new TableExercices(maListe);
        tableExercices = new JTable (modeleTable);

        tableExercices.setRowSelectionAllowed(true);
        tableExercices.setCellSelectionEnabled(true);
        tableExercices.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableExercices.setRowHeight(120);
        
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
    
    public TableExercices getModele(){
        return modeleTable;
    }
}
