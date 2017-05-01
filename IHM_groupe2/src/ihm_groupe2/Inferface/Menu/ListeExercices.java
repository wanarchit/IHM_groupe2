package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlTableExercices;
import ihm_groupe2.Modele.TableExercices;
import ihm_groupe2.Noyau_fonctionnel.*;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

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
        tableExercices.setAutoCreateRowSorter(true);
        personnalisationTable(tableExercices);
        
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
    
    private void personnalisationTable(JTable tableau) {
        tableau.setFont(new java.awt.Font(Font.DIALOG,Font.PLAIN,16)); // choix police du tableau
        tableau.getTableHeader().setBackground(Color.GRAY);
        tableau.getTableHeader().setForeground(Color.WHITE);
        tableau.getTableHeader().setFont(new java.awt.Font(Font.DIALOG,Font.BOLD,18));
        
        DefaultTableCellRenderer custom = new DefaultTableCellRenderer(); 
        custom.setHorizontalAlignment(JLabel.CENTER); // centre les données
        
        for (int i=0 ; i < tableau.getColumnCount() ; i++) // centre chaque cellule
            if (tableau.getColumnName(i).equals("Image de l'exercice")){
            }
            else{tableau.getColumnModel().getColumn(i).setCellRenderer(custom);   
            }  
    }
}
