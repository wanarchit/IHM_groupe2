/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ihm_groupe2.Controleur;

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
 * @author Maxime
 */
public class ControleurTableEleves  implements ListSelectionListener{
    
    private ListeEleves myTable;
            
    public ControleurTableEleves(ListeEleves myTable){
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
            Eleve e = modelTable.getElevesRow(selectedRow);
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

