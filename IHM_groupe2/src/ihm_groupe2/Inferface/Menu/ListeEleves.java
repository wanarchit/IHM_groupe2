package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Modele.ArbreExercicesEleve;
import ihm_groupe2.Modele.TableEleves;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;

/**
 *
 * @author Maxime
 */
public class ListeEleves extends JScrollPane {
    
    JTable table;
    
    public JTree tree;
    ArbreExercicesEleve modele;
    
    public ListeEleves(){
    super();
    table = new JTable(new TableEleves());
    this.setViewportView(table); 
    } 
}
