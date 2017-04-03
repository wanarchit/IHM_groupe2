package ihm_groupe2.Controleur;

import ihm_groupe2.Inferface.Menu.ListeExercices;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Delphine
 */
public class CtrlTableExercices {
    
    public CtrlTableExercices(ListeExercices myTable){
        myTable = new ListeExercices();
    }
    
    //CODE A ADAPTER PROBABLEMENT A NOTRE SITUATION
   // ListSelectionModel cellSelectionModel = myTable.getSelectionModel();
   // cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

  //  cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
  //  public void valueChanged(ListSelectionEvent e){
    //    {
   //     String selectedData = null;

 //       int[] selectedRow = myTable.getSelectedRows();
  //      int[] selectedColumns = myTable.getSelectedColumns();
//
     //   for (int i = 0; i < selectedRow.length; i++) {
     //     for (int j = 0; j < selectedColumns.length; j++) {
     //       selectedData = (String) myTable.getValueAt(selectedRow[i], selectedColumns[j]);
     //     }
    //    }
    //    System.out.println("Selected: " + selectedData);
   //   }
   // }
//}
}
