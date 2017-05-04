package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlTableClasses;
import ihm_groupe2.Modele.TableClasses;
import ihm_groupe2.Noyau_fonctionnel.Classe;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Groupe 2
 */
public class ListeClasse extends JScrollPane {
    
    private ApplicationProf appli;
    public TableClasses modeleTable;
    private JTable listeClasses;
    private CtrlTableClasses controleur;
    private ArrayList<Classe> lesClasses;
    
    public ListeClasse(ArrayList<Classe> laListeClasse, ApplicationProf lAppli){
        lesClasses = laListeClasse;
        appli = lAppli;
        controleur = new CtrlTableClasses(this,appli);

        modeleTable = new TableClasses(lesClasses);
        listeClasses = new JTable (modeleTable);

        listeClasses.setRowSelectionAllowed(true);
        listeClasses.setCellSelectionEnabled(true);
        listeClasses.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        listeClasses.setRowHeight(60);
        listeClasses.setAutoCreateRowSorter(true);
        personnalisationTable(listeClasses);

        this.add(listeClasses);


        ListSelectionModel listSelectionModel = listeClasses.getSelectionModel();        
        listSelectionModel.addListSelectionListener(controleur);
        this.setViewportView(listeClasses);
    }
    
    public void setData (ArrayList<Classe> maListe){
        modeleTable.setData(maListe);
        modeleTable.fireTableDataChanged();
    } 
    
    public JTable getJTable(){
        return listeClasses;
    }
    
    public TableClasses getModele(){
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
            if (tableau.getColumnName(i).equals("Icone")){
            }
            else{tableau.getColumnModel().getColumn(i).setCellRenderer(custom);   
            }    
    }    
}
