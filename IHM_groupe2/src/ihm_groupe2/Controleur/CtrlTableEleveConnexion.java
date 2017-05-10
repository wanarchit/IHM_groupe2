package ihm_groupe2.Controleur;

import Applications.ApplicationEleve;
import ihm_groupe2.Inferface.Menu.TableEleveVue;
import ihm_groupe2.Modele.TableEleves;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe CtrlTableEleveConnexion
 * Controleur du tableau de connexion des élèves
 * 
 * @author Groupe 2
 */
public class CtrlTableEleveConnexion implements ListSelectionListener {

    private ApplicationEleve appli;
    private TableEleveVue tableEleve;
    
    /**
     * Constructeur du controleur CtrlTableEleveConnexion
     * @param lAppli : application utilisée
     * @param myTable : table utilisée
     */
    public CtrlTableEleveConnexion(ApplicationEleve lAppli, TableEleveVue myTable) {
        appli = lAppli;
        tableEleve = myTable;
    }
    
    @Override
    /**
     * Méthode valueChanged
     * Permet de renvoyer vers le menu de l'élève lorsque l'utilisateur
     * sélectionne un élève dans le tableau
     * Vérifie qu'il sélectionne bien une ligne
     * @param act : list selection event
     */
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