package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.ControleurTableEleves;
import ihm_groupe2.Modele.TableEleves;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Groupe_2
 */
public class ListeEleves extends JScrollPane {
    
    //public JTree tree;
    private ApplicationProf appli;
    public TableEleves modeleTable;
    private JTable tableEleves;
    private ControleurTableEleves controleur;
    private ArrayList<Eleve> lesEleves;
    
    public ListeEleves(ArrayList<Eleve> laListeEleve, ApplicationProf lAppli){
    lesEleves = laListeEleve;
    appli = lAppli;
    controleur = new ControleurTableEleves(this,appli);
        
    modeleTable = new TableEleves(lesEleves);
    tableEleves = new JTable (modeleTable);
    
    tableEleves.setRowSelectionAllowed(true);
    tableEleves.setCellSelectionEnabled(true);
    tableEleves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    
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
}
