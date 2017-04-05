/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Controleur;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Maxime
 */
public class ControleurTableResultat  implements ListSelectionListener{
    @Override
    public void valueChanged(ListSelectionEvent listSelectionEvent){
        if (listSelectionEvent.getValueIsAdjusting())
            return;
        ListSelectionModel lsm = (ListSelectionModel)listSelectionEvent.getSource();
        if (lsm.isSelectionEmpty()) {
            System.out.println("No rows selected");
        }
        else{
            int selectedRow = lsm.getMinSelectionIndex();
            //System.out.println("The row "+selectedRow+" is now selected");
            System.out.println("HEY");
        }
    }
}

