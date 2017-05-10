package ihm_groupe2.Controleur;

import Applications.ApplicationProf;
import ihm_groupe2.Inferface.Menu.ListeClasse;
import ihm_groupe2.Modele.TableClasses;
import ihm_groupe2.Noyau_fonctionnel.Classe;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Classe CtrlTableClasses
 * Controleur permettant la gestion du tableau affichant les classes
 * 
 * @author Groupe 2
 */
public class CtrlTableClasses implements ListSelectionListener{
    
    private ListeClasse myTable;
    private ApplicationProf appli;
    
    /**
     * Constructeur du controleur CtrlTableClasses
     * @param myTable : table utilisée
     * @param lAppli : application utilisée
     */
    public CtrlTableClasses(ListeClasse myTable, ApplicationProf lAppli){
        appli = lAppli;
        this.myTable = myTable;
    }
    
    @Override
    /**
     * Méthode valueChanged
     * Permet de renvoyer vers la liste des élèves de cette classe
     * lorsque l'utilisateur sélectionne une classe.
     * Vérifie qu'il a bien sélectionné une ligne
     * @param act : list selection event
     */
    public void valueChanged(ListSelectionEvent act) {
        TableClasses modelTable = (TableClasses) myTable.getModele();
        if (act.getValueIsAdjusting())
           return;
        ListSelectionModel lsm = (ListSelectionModel)act.getSource();
        if (!lsm.isSelectionEmpty()) {
            int selectedRow = lsm.getMinSelectionIndex();
            Classe cl = modelTable.getClasseRow(selectedRow);  
            appli.affichelaClasse(cl);
        }
    }
}