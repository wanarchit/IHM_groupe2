package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.ListeExercices;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Delphine
 */
public class CtrlTableExercices implements ListSelectionListener {
    
    private ListeExercices myTable;
            
    public CtrlTableExercices(ListeExercices myTable){
        this.myTable = myTable;
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        Exercice e1 = (Exercice) myTable.getJTable().getValueAt(myTable.getJTable().getSelectedRow(),2);
        //appeller la méthode pour basuler vers la fiche de modification de l'exercice e1
    }
}
