package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationProf;
import ihm_groupe2.Controleur.CtrlTableClasses;
import ihm_groupe2.Modele.TableClasses;
import ihm_groupe2.Noyau_fonctionnel.Classe;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Groupe_2
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
    
    
}
