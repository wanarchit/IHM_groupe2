package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlTableExercices;
import ihm_groupe2.Modele.TableExercices;
import ihm_groupe2.Noyau_fonctionnel.*;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe ListeExercices
 * Classe permettant d'afficher les exercices existants
 * @author Groupe 2
 */
public class ListeExercices extends JScrollPane{
    private ApplicationProf appli;
    private JTable tableExercices;
    private TableExercices modeleTable;
    private CtrlTableExercices controleur;
    private ArrayList<Exercice> maListe;

    /**
     * Constructeur de listeExercices
     * @param maListeExo: liste des exercices sous forme de tableau
     * @param lAppli : Application en cours
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
        personnalisationTable(tableExercices);
        
        this.add(tableExercices);
                          
        ListSelectionModel listSelectionModel = tableExercices.getSelectionModel();        
        listSelectionModel.addListSelectionListener(controleur);
        this.setViewportView(tableExercices);
    }
    /**
     * Méthode setData
     * Permet de modifier le tableau de classes
     * @param maListe  : ArrayListe modifiée
     */
    public void setData (ArrayList<Exercice> maListe){
        modeleTable.setData(maListe);
        modeleTable.fireTableDataChanged();
    } 
    /**
     * Méthode getJTable
     * Permet de renvoyer la JTable créée dans la classe
     * @return tableExercices: JTable
     */
    public JTable getJTable(){
        return tableExercices;
    }
    /**
     * Méthode getModele
     * Permet de renvoyer le modèle utilisé
     * @return modeleTable: TableExercices
     */
    public TableExercices getModele(){
        return modeleTable;
    }
    /**
     * Méthode personnalisationTable
     * Permet de changer la disposition et l'aspect graphique de la Jtable générée
     * @param tableau : JTable à modfier
     */
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
