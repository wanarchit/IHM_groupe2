package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.ListeEleves;
import ihm_groupe2.Modele.TableEleves;
import ihm_groupe2.Noyau_fonctionnel.Eleve;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe CtrlTableEleves
 * Controleur du tableau contenant la liste des élèves
 * 
 * @author Groupe 2
 */
public class CtrlTableEleves implements ListSelectionListener{
    
    private ListeEleves myTable;
    private ApplicationProf appli;
    
    /**
     * Constructeur du controleur CtrlTableEleves
     * @param myTable : table utilisée
     * @param lAppli : application utilisée
     */
    public CtrlTableEleves(ListeEleves myTable, ApplicationProf lAppli){
        appli = lAppli;
        this.myTable = myTable;
    }
    
    @Override
    /**
     * Méthode valueChanged
     * Permet de renvoyer vers l'arbre contenant les réalisations de l'élève
     * selon la ligne/l'élève que l'utilisateur a choisi
     * Vérifie qu'il a bien sélectionné une ligne
     * @paran act : list selection event
     */
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