package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationEleve;
import ihm_groupe2.Controleur.CtrlTableEleveConnexion;
import ihm_groupe2.Modele.TableEleves;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Classe TableEleveVue
 * @author Groupe 2
 */
public class TableEleveVue extends JScrollPane{
    
    // Permet de valider les informations de connexion de l'élève

    private ApplicationEleve appliEleve;
    private CtrlTableEleveConnexion controleur;
    public TableEleves modeleTable;
    private JTable tableEleves;
    private ArrayList<Eleve> lesEleves;
    
    
    
    public TableEleveVue(ApplicationEleve lAppli){
        appliEleve = lAppli;
        lesEleves = appliEleve.getListeEleve();
        controleur = new CtrlTableEleveConnexion(appliEleve,this);
        
        modeleTable = new TableEleves(lesEleves);
        tableEleves = new JTable (modeleTable);
    
        tableEleves.setRowSelectionAllowed(true);
        tableEleves.setCellSelectionEnabled(true);
        tableEleves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableEleves.setRowHeight(120);

        tableEleves.setAutoCreateRowSorter(true);
        personnalisationTable(tableEleves);
        
        
        this.add(tableEleves);
        ListSelectionModel listSelectionModel = tableEleves.getSelectionModel();        
        listSelectionModel.addListSelectionListener(controleur);
        this.setViewportView(tableEleves);

    }

    public void setData (ArrayList<Eleve> maListe){
        modeleTable.setData(maListe);
        modeleTable.fireTableDataChanged();
    } 
    
    public JTable getJTable(){
        return tableEleves;
    }
    
    public TableEleves getModele(){
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
