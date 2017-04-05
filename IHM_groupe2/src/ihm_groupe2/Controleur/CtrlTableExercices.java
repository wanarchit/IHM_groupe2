package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.ListeExercices;
import ihm_groupe2.Inferface.Menu.PanelModifExo;
import ihm_groupe2.Modele.TableExercices;
import ihm_groupe2.Noyau_fonctionnel.Exercice;
import javax.swing.JFrame;
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
    public void valueChanged(ListSelectionEvent act) {

        TableExercices modelTable = (TableExercices) myTable.getModele();
        if (act.getValueIsAdjusting())
                return;
        ListSelectionModel lsm = (ListSelectionModel)act.getSource();
        if (!lsm.isSelectionEmpty()) {

            int selectedRow = lsm.getMinSelectionIndex();
            Exercice e = modelTable.getExoRow(selectedRow);
            PanelModifExo pan = new PanelModifExo(e);

            JFrame theFram = new JFrame();
            theFram.add(pan);
            theFram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            theFram.setTitle("Application gestion exercices");  
            theFram.setSize(1000, 600);
            theFram.setLocationRelativeTo(null);
            theFram.setVisible(true);
        }
    }   
}   

