package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Menu.TableEleveVue;
import ihm_groupe2.Modele.TableEleves;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Paul
 */
public class CtrlTableEleveConnexion implements ListSelectionListener {

    private ApplicationEleve appli;
    private TableEleveVue tableEleve;
    
    public CtrlTableEleveConnexion(ApplicationEleve lAppli, TableEleveVue myTable) {
        appli = lAppli;
        tableEleve = myTable;
    }
    
    

    @Override
    public void valueChanged(ListSelectionEvent act) {
        TableEleves modelTable = (TableEleves) tableEleve.getModele();
        if (act.getValueIsAdjusting())
                return;
        ListSelectionModel lsm = (ListSelectionModel)act.getSource();
        if (!lsm.isSelectionEmpty()) {

            int selectedRow = lsm.getMinSelectionIndex();
            Eleve el = modelTable.getEleveRow(selectedRow);
            
            appli.seConnecter(el);
        }
    }
    
}
