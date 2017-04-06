package ihm_groupe2.Inferface.Menu;

import ihm_groupe2.Controleur.ControleurTableEleves;
import ihm_groupe2.Modele.ArbreExercicesEleve;
import ihm_groupe2.Modele.TableEleves;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Maxime
 */
public class ListeEleves extends JScrollPane {
    
    //public JTree tree;
    public TableEleves myTable;
    JTable table;
    ArbreExercicesEleve modele;
    ControleurTableEleves control;
    
    public ListeEleves(){
    super();
    table = new JTable(new TableEleves());
    this.setViewportView(table);
    
    table.getSelectionModel().addListSelectionListener(control);;

    } 
    public TableEleves getModele(){
        return myTable;
    }
}
