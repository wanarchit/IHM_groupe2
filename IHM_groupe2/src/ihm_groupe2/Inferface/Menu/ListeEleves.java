package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlTableEleves;
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
 * Classe ListeEleves
 * Permet de gérer la liste des élèves dans une JTable
 * @author Groupe 2
 */
public class ListeEleves extends JScrollPane {
    
    //public JTree tree;
    private ApplicationProf appli;
    public TableEleves modeleTable;
    private JTable tableEleves;
    private CtrlTableEleves controleur;
    private ArrayList<Eleve> lesEleves;
    /**
     * Constructeur de la classe ListeEleves
     * @param laListeEleve: liste des élèves sous forme de tableau
     * @param lAppli : Application en cours
     */
    public ListeEleves(ArrayList<Eleve> laListeEleve, ApplicationProf lAppli){
    lesEleves = laListeEleve;
    appli = lAppli;
    controleur = new CtrlTableEleves(this,appli);
        
    modeleTable = new TableEleves(lesEleves);
    tableEleves = new JTable (modeleTable);
    
    tableEleves.setRowSelectionAllowed(true);
    tableEleves.setCellSelectionEnabled(true);
    tableEleves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    tableEleves.setRowHeight(120);
    personnalisationTable(tableEleves);
    
    this.add(tableEleves);
    
    
    ListSelectionModel listSelectionModel = tableEleves.getSelectionModel();        
    listSelectionModel.addListSelectionListener(controleur);
    this.setViewportView(tableEleves);

    } 
    /**
     * Méthode setData
     * Permet de modifier le tableau des élèves
     * @param maListe  : ArrayListe modifiée
     */
    public void setData (ArrayList<Eleve> maListe){
        modeleTable.setData(maListe);
        modeleTable.fireTableDataChanged();
    } 
    /**
     * Méthode getJTable
     * Permet de renvoyer la JTable créée dans la classe
     * @return tableEleves: JTable
     */
    public JTable getJTable(){
        return tableEleves;
    }
    /**
     * Méthode getModele
     * Permet de renvoyer le modèle utilisé
     * @return modeleTable: TableEleves
     */
    public TableEleves getModele(){
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
            if (tableau.getColumnName(i).equals("Icone")){
            }
            else{tableau.getColumnModel().getColumn(i).setCellRenderer(custom);   
            }    
    }
}
