package ihm_groupe2.Inferface.Menu;

import Applications.ApplicationEleve;
import ihm_groupe2.Controleur.CtrlConnEleve;
import ihm_groupe2.Controleur.CtrlTableEleveConnexion;
import ihm_groupe2.Modele.TableEleves;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

/**
 * Classe TableEleveVue
 * @author Groupe2
 */
public class TableEleveVue extends JScrollPane{
    
    // Permet de valider les informations de connexion de l'élève

    private ApplicationEleve appliEleve;
    private CtrlTableEleveConnexion controleur;
    public TableEleves modeleTable;
    private JTable tableEleves;
    private ArrayList<Eleve> lesEleves;
    
    
    
    public TableEleveVue(ApplicationEleve lAppli){
        appliEleve = lAppli;
        lesEleves = appliEleve.getListeEleve();
        controleur = new CtrlTableEleveConnexion(appliEleve,this);
        
        modeleTable = new TableEleves(lesEleves);
        tableEleves = new JTable (modeleTable);
    
        tableEleves.setRowSelectionAllowed(true);
        tableEleves.setCellSelectionEnabled(true);
        tableEleves.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tableEleves.setRowHeight(120);
        
        
        
        this.add(tableEleves);
        ListSelectionModel listSelectionModel = tableEleves.getSelectionModel();        
        listSelectionModel.addListSelectionListener(controleur);
        this.setViewportView(tableEleves);

    }

    
    public void setData (ArrayList<Eleve> maListe){
        modeleTable.setData(maListe);
        modeleTable.fireTableDataChanged();
    } 
    
    public JTable getJTable(){
        return tableEleves;
    }
    
    public TableEleves getModele(){
        return modeleTable;
    }
    
}
