/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.ListeEleves;
import ihm_groupe2.Inferface.Menu.PanelModifExo;
import ihm_groupe2.Modele.TableEleves;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import javax.swing.JFrame;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Groupe_2
 */
public class CtrlTableEleves  implements ListSelectionListener{
    
    private ListeEleves myTable;
    private ApplicationProf appli;
            
    public CtrlTableEleves(ListeEleves myTable, ApplicationProf lAppli){
        appli = lAppli;
        this.myTable = myTable;

    }
    
    @Override
    public void valueChanged(ListSelectionEvent act) {

        TableEleves modelTable = (TableEleves) myTable.getModele();
        if (act.getValueIsAdjusting())
                return;
        ListSelectionModel lsm = (ListSelectionModel)act.getSource();
        if (!lsm.isSelectionEmpty()) {

            int selectedRow = lsm.getMinSelectionIndex();
            Eleve el = modelTable.getEleveRow(selectedRow);
            
            appli.affichelEleve(el);
        }
    }   
}

