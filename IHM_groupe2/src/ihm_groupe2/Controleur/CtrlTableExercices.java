package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.ListeExercices;
import ihm_groupe2.Modele.TableExercices;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Delphine
 */
public class CtrlTableExercices implements ListSelectionListener {
    
    private ListeExercices myTable;
    private ApplicationProf appli;
            
    public CtrlTableExercices(ListeExercices myTable, ApplicationProf lAppli){
        this.myTable = myTable;
        appli = lAppli;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent act) {

        TableExercices modelTable = (TableExercices) myTable.getModele();
        if (act.getValueIsAdjusting())
                return;
        ListSelectionModel lsm = (ListSelectionModel)act.getSource();
        if (!lsm.isSelectionEmpty()) {

            int selectedRow = lsm.getMinSelectionIndex();
            Exercice e = modelTable.getExoRow(selectedRow);
            
            appli.modifExercice(e);
        }
    }   
}   

