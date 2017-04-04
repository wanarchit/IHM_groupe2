package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Modele.TableEleves;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Delphine
 */
public class ListeEleves extends JScrollPane {
    
    JTable table;
    public ListeEleves(){
        super();
        table = new JTable(new TableEleves());
        this.setViewportView(table);
    } 
   
     
}
